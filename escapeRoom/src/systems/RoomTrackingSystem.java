package systems;

import core.Game;
import core.System;
import core.components.PositionComponent;
import core.utils.Point;
import dsl.EscapeRoomDefinition;
import dsl.Room;
import dsl.runtime.DSLRuntime;
import dsl.runtime.ast.EventType;
import java.util.Map;
import java.util.logging.Logger;

/**
 * System that tracks the player's position and fires room enter/exit events.
 *
 * <p>This system monitors the hero's position each frame and determines which DSL room they are
 * currently in. When the player moves to a different room, it fires ON_EXIT for the old room and
 * ON_ENTER for the new room.
 */
public class RoomTrackingSystem extends System {

  private static final Logger LOGGER = Logger.getLogger(RoomTrackingSystem.class.getSimpleName());

  private final DSLRuntime runtime;
  private final EscapeRoomDefinition definition;
  private String currentRoom = null;

  /**
   * Create a new room tracking system.
   *
   * @param runtime The DSL runtime to fire events on
   * @param definition The escape room definition containing room data
   */
  public RoomTrackingSystem(DSLRuntime runtime, EscapeRoomDefinition definition) {
    this.runtime = runtime;
    this.definition = definition;
  }

  @Override
  public void execute() {
    if (runtime == null || definition == null || definition.rooms == null) {
      return;
    }

    // Get hero position
    var heroOpt = Game.hero();
    if (heroOpt.isEmpty()) return;

    var posOpt = heroOpt.get().fetch(PositionComponent.class);
    if (posOpt.isEmpty()) return;

    Point heroPos = posOpt.get().position();

    // Determine which room the hero is in
    String newRoom = findRoomAt(heroPos);

    // Check if room changed
    if (newRoom != null && !newRoom.equals(currentRoom)) {
      // Fire exit event for old room
      if (currentRoom != null) {
        LOGGER.info("[DSL Event] ON_EXIT -> " + currentRoom);
        runtime.fireEvent(EventType.ON_EXIT, currentRoom);
      }

      // Fire enter event for new room
      LOGGER.info("[DSL Event] ON_ENTER -> " + newRoom);
      runtime.fireEvent(EventType.ON_ENTER, newRoom);

      // Update current room variable in runtime
      runtime.setVariable("current_room", newRoom);

      currentRoom = newRoom;
    }
  }

  /**
   * Find which DSL room the given position is in.
   *
   * <p>Checks if the position falls within any defined room's area.
   *
   * @param pos The position to check
   * @return The room ID, or null if not in any defined room
   */
  private String findRoomAt(Point pos) {
    if (definition.rooms == null) return null;

    for (Map.Entry<String, Room> entry : definition.rooms.entrySet()) {
      String roomId = entry.getKey();
      Room room = entry.getValue();

      // Use default size if not specified (must match DSLLevelLoader defaults)
      int width = room.width > 0 ? room.width : 10;
      int height = room.height > 0 ? room.height : 10;

      // Check if pos is within room bounds
      if (pos.x() >= room.x
          && pos.x() < room.x + width
          && pos.y() >= room.y
          && pos.y() < room.y + height) {
        return roomId;
      }
    }

    // If not in any room, return current room (e.g. in corridor)
    return currentRoom;
  }

  /**
   * Get the current room the player is in.
   *
   * @return The current room ID, or null if unknown
   */
  public String getCurrentRoom() {
    return currentRoom;
  }

  /**
   * Force set the current room (e.g., on level load). Fires ON_ENTER event for the new room.
   *
   * @param roomId The room ID to set
   */
  public void setCurrentRoom(String roomId) {
    if (roomId != null && !roomId.equals(currentRoom)) {
      currentRoom = roomId;
      runtime.setVariable("current_room", roomId);

      LOGGER.info("[DSL Event] ON_ENTER -> " + roomId + " (initial)");
      runtime.fireEvent(EventType.ON_ENTER, roomId);
    }
  }
}
