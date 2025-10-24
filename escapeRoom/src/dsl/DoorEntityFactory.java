package dsl;

import contrib.components.CollideComponent;
import contrib.components.InteractionComponent;
import contrib.hud.DialogUtils;
import core.Entity;
import core.components.DrawComponent;
import core.components.PositionComponent;
import core.level.elements.tile.DoorTile;
import core.utils.Point;
import core.utils.components.path.SimpleIPath;

/**
 * Factory for creating door entities with visual indicators.
 */
public class DoorEntityFactory {

    private static final String LOCKED_DOOR_TEXTURE = "dungeon/door_locked";
    private static final String UNLOCKED_DOOR_TEXTURE = "dungeon/door_open";

    /**
     * Create a visual indicator entity for a locked door.
     * 
     * @param door           The door tile
     * @param requiredItemId The item required to unlock
     * @param position       Position for the indicator
     * @return Entity representing the locked door
     */
    public static Entity createLockedDoorIndicator(DoorTile door, String requiredItemId, Point position) {
        Entity doorIndicator = new Entity("LockedDoorIndicator");

        // Visual component showing it's locked
        doorIndicator.add(new PositionComponent(position));
        doorIndicator.add(new DrawComponent(new SimpleIPath(LOCKED_DOOR_TEXTURE)));
        doorIndicator.add(new CollideComponent());

        // Interaction to show what's needed
        doorIndicator.add(new InteractionComponent(
                2.0f,
                true,
                (entity, hero) -> {
                    if (door.isOpen()) {
                        DialogUtils.showTextPopup(
                                "The door is now open!",
                                "Door");
                    } else {
                        DialogUtils.showTextPopup(
                                "🔒 This door is locked.\n\nRequired: " + requiredItemId,
                                "Locked Door");
                    }
                }));

        return doorIndicator;
    }

    /**
     * Create a visual indicator for an unlocked door.
     * 
     * @param door     The door tile
     * @param position Position for the indicator
     * @return Entity representing the unlocked door
     */
    public static Entity createUnlockedDoorIndicator(DoorTile door, Point position) {
        Entity doorIndicator = new Entity("UnlockedDoorIndicator");

        doorIndicator.add(new PositionComponent(position));
        doorIndicator.add(new DrawComponent(new SimpleIPath(UNLOCKED_DOOR_TEXTURE)));
        doorIndicator.add(new CollideComponent());

        doorIndicator.add(new InteractionComponent(
                2.0f,
                true,
                (entity, hero) -> {
                    if (door.isOpen()) {
                        DialogUtils.showTextPopup(
                                "This door connects to another room.",
                                "Door",
                                () -> {
                                });
                    } else {
                        DialogUtils.showTextPopup(
                                "The door is closed.",
                                "Door",
                                () -> {
                                });
                    }
                }));

        return doorIndicator;
    }
}
