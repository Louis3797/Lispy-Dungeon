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

/**
 * Manages doors in the escape room, including locked doors that require items.
 */
public class DoorManager {

    private static final Map<String, DoorTile> doors = new HashMap<>();
    private static final Map<DoorTile, String> lockedDoors = new HashMap<>();
    private static final Map<DoorTile, Entity> doorEntities = new HashMap<>();

    /**
     * Register a door with an ID.
     */
    public static void registerDoor(String id, DoorTile door) {
        doors.put(id, door);
    }

    /**
     * Lock a door and associate it with a required item ID.
     */
    public static void lockDoor(DoorTile door, String requiredItemId) {
        door.close();
        lockedDoors.put(door, requiredItemId);
        System.out.println("  [LOCKED] Locked door (requires: " + requiredItemId + ")");
    }

    /**
     * Register a door entity for visual representation.
     */
    public static void registerDoorEntity(DoorTile door, Entity doorEntity) {
        doorEntities.put(door, doorEntity);
    }

    /**
     * Create an interaction entity for a locked door.
     */
    public static Entity createDoorInteraction(DoorTile door, String requiredItemId, Point position) {
        Entity doorEntity = new Entity("LockedDoor");

        doorEntity.add(new InteractionComponent(
                2.0f, // interaction radius
                true, // repeatable
                (entity, hero) -> {
                    // Check if door is already open
                    if (door.isOpen()) {
                        DialogUtils.showTextPopup(
                                "The door is already open.",
                                "Door");
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
                                "[LOCKED] This door is locked.\n\nYou need: " + requiredItemId,
                                "Locked Door");
                    }
                }));

        return doorEntity;
    }

    /**
     * Attempt to unlock a door using an item from the hero's inventory.
     */
    private static boolean tryUnlockWithInventory(DoorTile door, Entity hero, String requiredItemId) {
        return hero.fetch(InventoryComponent.class)
                .map(inventory -> {
                    // Check if inventory contains the required key
                    for (var item : inventory.items()) {
                        if (item instanceof EscapeRoomKey key) {
                            if (key.getKeyId().equals(requiredItemId)) {
                                // Unlock the door
                                door.open();
                                lockedDoors.remove(door);
                                // Don't remove the key - it stays in inventory for reuse
                                System.out.println("  🔓 Unlocked door with: " + requiredItemId);
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .orElse(false);
    }

    /**
     * Attempt to unlock a door with an item ID (direct unlock without inventory
     * check).
     */
    public static boolean tryUnlockDoor(DoorTile door, String itemId) {
        String requiredItem = lockedDoors.get(door);
        if (requiredItem != null && requiredItem.equals(itemId)) {
            door.open();
            lockedDoors.remove(door);
            System.out.println("  🔓 Unlocked door with: " + itemId);
            updateDoorVisuals(door);
            return true;
        }
        return false;
    }

    /**
     * Update door visuals after unlocking.
     */
    private static void updateDoorVisuals(DoorTile door) {
        Entity doorEntity = doorEntities.get(door);
        if (doorEntity != null) {
            // Remove old locked door entity and replace with unlocked version
            Game.remove(doorEntity);
            // Could spawn new unlocked door entity here if needed
        }
    }

    /**
     * Check if a door is locked.
     */
    public static boolean isLocked(DoorTile door) {
        return lockedDoors.containsKey(door);
    }

    /**
     * Get the required item ID for a locked door.
     */
    public static String getRequiredItem(DoorTile door) {
        return lockedDoors.get(door);
    }

    /**
     * Clear all door registrations (for level reload).
     */
    public static void clear() {
        doors.clear();
        lockedDoors.clear();
        doorEntities.clear();
    }
}
