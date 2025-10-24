package dsl;

import contrib.components.InteractionComponent;
import contrib.hud.DialogUtils;
import core.Entity;
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
        System.out.println("  🔒 Locked door (requires: " + requiredItemId + ")");
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
                    // TODO: Check if hero has the required item in inventory
                    // For now, just show a message
                    if (door.isOpen()) {
                        DialogUtils.showTextPopup(
                                "The door is already open.",
                                "Door");
                    } else {
                        DialogUtils.showTextPopup(
                                "This door is locked. You need: " + requiredItemId,
                                "Locked Door");
                    }
                }));

        return doorEntity;
    }

    /**
     * Attempt to unlock a door with an item.
     */
    public static boolean tryUnlockDoor(DoorTile door, String itemId) {
        String requiredItem = lockedDoors.get(door);
        if (requiredItem != null && requiredItem.equals(itemId)) {
            door.open();
            lockedDoors.remove(door);
            System.out.println("  🔓 Unlocked door with: " + itemId);
            return true;
        }
        return false;
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
    }
}
