package dsl;

import dsl.runtime.ast.EventHandler;
import java.util.ArrayList;
import java.util.List;

/** Represents a room in the escape room. */
public class Room {
  public String description;
  public int x, y, width, height;
  public String pattern; // ASCII art pattern for custom room shapes
  public List<String> items;
  public List<String> connections;
  public String lockedBy;

  // event handlers
  public List<EventHandler> eventHandlers = new ArrayList<>();

  @Override
  public String toString() {
    return "Room{"
        + "description='"
        + description
        + '\''
        + ", position=("
        + x
        + ","
        + y
        + ")"
        + ", size="
        + width
        + "x"
        + height
        + ", hasPattern="
        + (pattern != null)
        + ", eventHandlers="
        + eventHandlers.size()
        + '}';
  }
}
