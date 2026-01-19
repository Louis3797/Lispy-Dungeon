package dsl.runtime.ast;

/** Represents the type of event that can trigger a handler. */
public enum EventType {
  // Room events
  ON_ENTER("on_enter"),
  ON_EXIT("on_exit"),
  ON_FIRST_ENTER("on_first_enter"),
  ON_CLEAR("on_clear"),

  // Item events
  ON_PICKUP("on_pickup"),
  ON_USE("on_use"),
  ON_DROP("on_drop"),

  // NPC events
  ON_INTERACT("on_interact"),
  ON_DEATH("on_death"),

  // Quiz events
  ON_CORRECT("on_correct"),
  ON_INCORRECT("on_wrong"),

  // Global events
  ON_PUZZLE_SOLVED("on_puzzle_solved"),
  ON_TIME_WARNING("on_time_warning");

  private final String keyword;

  EventType(String keyword) {
    this.keyword = keyword;
  }

  public String getKeyword() {
    return keyword;
  }

  /** Parse an event type from its DSL keyword. */
  public static EventType fromKeyword(String keyword) {
    for (EventType type : values()) {
      if (type.keyword.equals(keyword)) {
        return type;
      }
    }
    throw new IllegalArgumentException("Unknown event type: " + keyword);
  }
}
