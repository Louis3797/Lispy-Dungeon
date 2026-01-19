package dsl;

import contrib.components.InteractionComponent;
import contrib.components.InventoryComponent;
import contrib.hud.DialogUtils;
import core.Entity;
import core.Game;
import core.level.elements.tile.DoorTile;
import core.utils.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/** Manages doors in the escape room, including locked doors that require items. */
public class DoorManager {

  private static final Logger LOGGER = Logger.getLogger(DoorManager.class.getSimpleName());

  // Configuration constants
  private static final float DOOR_INTERACTION_RADIUS = 2.0f;

  private static final Map<String, DoorTile> doors = new HashMap<>();
  private static final Map<DoorTile, String> lockedDoors = new HashMap<>();
  private static final Map<DoorTile, Entity> doorEntities = new HashMap<>();

  /**
   * Register a door with an ID.
   *
   * @param id The unique identifier for the door
   * @param door The door tile to register
   * @throws NullPointerException if id or door is null
   */
  public static void registerDoor(String id, DoorTile door) {
    Objects.requireNonNull(id, "id cannot be null");
    Objects.requireNonNull(door, "door cannot be null");

    doors.put(id, door);
  }

  /**
   * Lock a door and associate it with a required item ID.
   *
   * @param door The door tile to lock
   * @param requiredItemId The ID of the item required to unlock
   * @throws NullPointerException if door or requiredItemId is null
   */
  public static void lockDoor(DoorTile door, String requiredItemId) {
    Objects.requireNonNull(door, "door cannot be null");
    Objects.requireNonNull(requiredItemId, "requiredItemId cannot be null");

    door.close();
    lockedDoors.put(door, requiredItemId);
    LOGGER.info("  [LOCKED] Locked door (requires: " + requiredItemId + ")");
  }

  /**
   * Register a door entity for visual representation.
   *
   * @param door The door tile
   * @param doorEntity The entity representing the door
   * @throws NullPointerException if door or doorEntity is null
   */
  public static void registerDoorEntity(DoorTile door, Entity doorEntity) {
    Objects.requireNonNull(door, "door cannot be null");
    Objects.requireNonNull(doorEntity, "doorEntity cannot be null");

    doorEntities.put(door, doorEntity);
  }

  /**
   * Create an interaction entity for a locked door.
   *
   * @param door The door tile
   * @param requiredItemId The ID of the required item
   * @param position The position for the interaction entity
   * @return The created door interaction entity
   * @throws NullPointerException if any parameter is null
   */
  public static Entity createDoorInteraction(DoorTile door, String requiredItemId, Point position) {
    Objects.requireNonNull(door, "door cannot be null");
    Objects.requireNonNull(requiredItemId, "requiredItemId cannot be null");
    Objects.requireNonNull(position, "position cannot be null");
    Entity doorEntity = new Entity("LockedDoor");

    doorEntity.add(
        new InteractionComponent(
            DOOR_INTERACTION_RADIUS,
            true,
            (entity, hero) -> {
              // Check if door is already open
              if (door.isOpen()) {
                DialogUtils.showTextPopup("The door is already open.", "Door");
                return;
              }

              // Try to unlock with inventory
              if (tryUnlockWithInventory(door, hero, requiredItemId)) {
                DialogUtils.showTextPopup(
                    "🔓 You unlocked the door with your key!",
                    "Success",
                    () -> updateDoorVisuals(door));
              } else {
                DialogUtils.showTextPopup(
                    "[LOCKED] This door is locked.\n\nYou need: " + requiredItemId, "Locked Door");
              }
            }));

    return doorEntity;
  }

  /** Attempt to unlock a door using an item from the hero's inventory. */
  private static boolean tryUnlockWithInventory(DoorTile door, Entity hero, String requiredItemId) {
    return hero.fetch(InventoryComponent.class)
        .map(
            inventory -> {
              // Check if inventory contains the required key
              for (var item : inventory.items()) {
                if (item instanceof EscapeRoomKey key) {
                  if (key.getKeyId().equals(requiredItemId)) {
                    // Unlock the door
                    door.open();
                    lockedDoors.remove(door);
                    // Don't remove the key it stays in inventory for reuse
                    LOGGER.info("Unlocked door with: " + requiredItemId);
                    return true;
                  }
                }
              }
              return false;
            })
        .orElse(false);
  }

  /** Attempt to unlock a door with an item ID (direct unlock without inventory check). */
  public static boolean tryUnlockDoor(DoorTile door, String itemId) {
    String requiredItem = lockedDoors.get(door);
    if (requiredItem != null && requiredItem.equals(itemId)) {
      door.open();
      lockedDoors.remove(door);
      LOGGER.info("Unlocked door with: " + itemId);
      updateDoorVisuals(door);
      return true;
    }
    return false;
  }

  /** Update door visuals after unlocking. */
  private static void updateDoorVisuals(DoorTile door) {
    Entity doorEntity = doorEntities.get(door);
    if (doorEntity != null) {
      // Remove old locked door entity and replace with unlocked version
      Game.remove(doorEntity);
      // Could spawn new unlocked door entity here if needed
    }
  }

  /** Check if a door is locked. */
  public static boolean isLocked(DoorTile door) {
    return lockedDoors.containsKey(door);
  }

  /** Get the required item ID for a locked door. */
  public static String getRequiredItem(DoorTile door) {
    return lockedDoors.get(door);
  }

  /** Clear all door registrations (for level reload). */
  public static void clear() {
    doors.clear();
    lockedDoors.clear();
    doorEntities.clear();
  }

  /**
   * Unlock a door by its registered ID.
   *
   * @param doorId The ID of the door to unlock
   * @return true if the door was found and unlocked, false otherwise
   */
  public static boolean unlockDoor(String doorId) {
    DoorTile door = doors.get(doorId);
    if (door != null) {
      door.open();
      lockedDoors.remove(door);
      updateDoorVisuals(door);
      LOGGER.info("Unlocked door by ID: " + doorId);
      return true;
    }
    LOGGER.warning("Door not found for unlock: " + doorId);
    return false;
  }

  /**
   * Lock a door by its registered ID.
   *
   * @param doorId The ID of the door to lock
   * @param requiredItemId The item required to unlock (optional, can be null)
   * @return true if the door was found and locked, false otherwise
   */
  public static boolean lockDoorById(String doorId, String requiredItemId) {
    DoorTile door = doors.get(doorId);
    if (door != null) {
      door.close();
      if (requiredItemId != null) {
        lockedDoors.put(door, requiredItemId);
      }
      LOGGER.info("Locked door by ID: " + doorId);
      return true;
    }
    LOGGER.warning("Door not found for lock: " + doorId);
    return false;
  }
}
