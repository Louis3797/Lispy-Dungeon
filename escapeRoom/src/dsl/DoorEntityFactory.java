package dsl;

import contrib.components.CollideComponent;
import contrib.components.InteractionComponent;
import contrib.components.InventoryComponent;
import contrib.hud.DialogUtils;
import core.Entity;
import core.Game;
import core.components.DrawComponent;
import core.components.PositionComponent;
import core.level.elements.tile.DoorTile;
import core.utils.Point;

import dsl.utils.AnimationFactory;

import java.util.List;

/**
 * Factory for creating door entities with visual indicators.
 */
public class DoorEntityFactory {

    // Configuration constants
    private static final float DOOR_INTERACTION_RADIUS = 2.0f;

    /**
     * Create visual indicator entity for a locked door.
     * 
     * @param door           The door tile
     * @param requiredItemId The item required to unlock
     * @param position       Position for the door
     * @param direction      Door direction ("top", "bottom", "left", "right")
     * @param wallEntities   List of wall entities associated with this door
     * @return Entity representing the locked door
     */
    public static Entity createLockedDoorIndicator(DoorTile door, String requiredItemId, Point position,
            String direction, List<Entity> wallEntities) {
        Entity doorEntity = new Entity("LockedDoor");

        // Visual component showing it's closed/locked
        String closedTexture = "dungeon/default/door/" + direction + "_closed.png";
        doorEntity.add(new PositionComponent(position));
        doorEntity.add(new DrawComponent(AnimationFactory.createSingleFrameAnimation(closedTexture)));
        doorEntity.add(new CollideComponent());

        // Interaction to check inventory and unlock
        doorEntity.add(new InteractionComponent(
                DOOR_INTERACTION_RADIUS,
                true,
                (entity, hero) -> {
                    if (door.isOpen()) {
                        DialogUtils.showTextPopup(
                                "The door is now open!",
                                "Door");
                    } else {
                        // Check hero's inventory for the required key
                        boolean hasKey = hero.fetch(InventoryComponent.class)
                                .map(inventory -> {
                                    for (var item : inventory.items()) {
                                        if (item instanceof EscapeRoomKey key) {
                                            if (key.getKeyId().equals(requiredItemId)) {
                                                return true;
                                            }
                                        }
                                    }
                                    return false;
                                })
                                .orElse(false);

                        if (hasKey) {
                            // Unlock the door
                            door.open();

                            // Remove locked door but keep walls
                            Game.remove(doorEntity);

                            // Spawn unlocked door
                            Entity unlockedDoor = createUnlockedDoorIndicator(door, position, direction);
                            Game.add(unlockedDoor);

                            DialogUtils.showTextPopup(
                                    "🔓 You unlocked the door with your " + requiredItemId + "!",
                                    "Success");
                        } else {
                            DialogUtils.showTextPopup(
                                    "[LOCKED] This door is locked.\n\nRequired: " + requiredItemId,
                                    "Locked Door");
                        }
                    }
                }));

        // Register this door entity
        DoorManager.registerDoorEntity(door, doorEntity);

        return doorEntity;
    }

    /**
     * Create visual indicator for an unlocked door.
     * 
     * @param door      The door tile
     * @param position  Position for the door
     * @param direction Door direction ("top", "bottom", "left", "right")
     * @return Entity representing the unlocked door
     */
    public static Entity createUnlockedDoorIndicator(DoorTile door, Point position, String direction) {
        Entity doorEntity = new Entity("UnlockedDoor");

        // Visual component showing it's open
        String openTexture = "dungeon/default/door/" + direction + ".png";
        doorEntity.add(new PositionComponent(position));
        doorEntity.add(new DrawComponent(AnimationFactory.createSingleFrameAnimation(openTexture)));
        // No CollideComponent - player can walk through open doors

        doorEntity.add(new InteractionComponent(
                DOOR_INTERACTION_RADIUS,
                true,
                (entity, hero) -> {
                    DialogUtils.showTextPopup(
                            "This door connects to another room.",
                            "Door");
                }));

        return doorEntity;
    }
}
