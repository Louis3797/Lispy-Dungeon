package dsl;

import dsl.runtime.ast.Expression;
import dsl.runtime.ast.Trigger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Represents a complete escape room definition parsed from DSL. */
public class EscapeRoomDefinition {
  public Metadata metadata;
  public Map<String, Room> rooms;
  public Map<String, Quiz> quizzes;
  public Map<String, Item> items;
  public Map<String, NPC> npcs;
  public Player player;

  // Dynamic language features
  public Map<String, Expression> variables = new HashMap<>();
  public List<Trigger> triggers;

  // Logic and Events (Legacy/Alternative)
  public Logic logic;
  public List<Event> events;

  /** Get the title of the escape room, or a default if not set. */
  public String getTitle() {
    return metadata != null && metadata.title != null ? metadata.title : "Escape Room";
  }

  /** Check if fog of war is enabled. */
  public boolean isFogOfWarEnabled() {
    return metadata != null && metadata.fogOfWar;
  }

  /** Get the fog of war view distance. */
  public int getFogViewDistance() {
    return metadata != null ? metadata.viewDistance : 7;
  }

  /** Get the camera zoom level. */
  public float getCameraZoom() {
    return metadata != null ? metadata.cameraZoom : 1.0f;
  }

  @Override
  public String toString() {
    return "EscapeRoomDefinition{"
        + "metadata="
        + metadata
        + ", rooms="
        + (rooms != null ? rooms.size() : 0)
        + ", quizzes="
        + (quizzes != null ? quizzes.size() : 0)
        + ", items="
        + (items != null ? items.size() : 0)
        + ", npcs="
        + (npcs != null ? npcs.size() : 0)
        + '}';
  }
}
