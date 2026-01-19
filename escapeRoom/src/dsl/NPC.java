package dsl;

import dsl.runtime.ast.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Represents an NPC in the escape room. */
public class NPC {
  public String description;
  public String texture;
  public String location;
  public Map<String, String> dialogue;
  public boolean hostile;
  public int health;
  public int damage;
  public List<String> givesItems = new ArrayList<>();
  public List<String> requiresItems = new ArrayList<>();
  public List<EventHandler> eventHandlers = new ArrayList<>();

  @Override
  public String toString() {
    return "NPC{"
        + "description='"
        + description
        + '\''
        + ", texture='"
        + texture
        + '\''
        + ", location='"
        + location
        + '\''
        + ", hostile="
        + hostile
        + ", health="
        + health
        + ", damage="
        + damage
        + ", eventHandlers="
        + eventHandlers.size()
        + '}';
  }
}
