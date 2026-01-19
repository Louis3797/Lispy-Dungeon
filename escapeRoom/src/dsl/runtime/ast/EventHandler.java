package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Represents an event handler attached to an entity (room, item, NPC, quiz). */
public class EventHandler {
  private final EventType eventType;
  private final StatementBlock body;
  private final String attachedToId; // The entity this handler is attached to
  private final String attachedToType; // "room", "item", "npc", "quiz"

  public EventHandler(
      EventType eventType, StatementBlock body, String attachedToId, String attachedToType) {
    this.eventType = eventType;
    this.body = body;
    this.attachedToId = attachedToId;
    this.attachedToType = attachedToType;
  }

  /** Execute this event handler in the given runtime context. */
  public void execute(DSLRuntime runtime) {
    body.execute(runtime);
  }

  public EventType getEventType() {
    return eventType;
  }

  public StatementBlock getBody() {
    return body;
  }

  public String getAttachedToId() {
    return attachedToId;
  }

  public String getAttachedToType() {
    return attachedToType;
  }

  @Override
  public String toString() {
    return eventType.getKeyword() + " [" + attachedToType + ":" + attachedToId + "] " + body;
  }
}
