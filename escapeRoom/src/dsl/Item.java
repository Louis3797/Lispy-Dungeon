package dsl;

import dsl.runtime.ast.EventHandler;
import java.util.ArrayList;
import java.util.List;

/** Represents an item in the escape room. */
public class Item {
  public String description;
  public String type;
  public String texture;
  public boolean visible = true; // Default to visible
  public boolean readable = false;
  public String content;

  // event handlers
  public List<EventHandler> eventHandlers = new ArrayList<>();

  @Override
  public String toString() {
    return "Item{"
        + "description='"
        + description
        + '\''
        + ", type='"
        + type
        + '\''
        + ", texture='"
        + texture
        + '\''
        + ", eventHandlers="
        + eventHandlers.size()
        + '}';
  }
}
