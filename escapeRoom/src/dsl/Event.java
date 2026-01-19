package dsl;

import java.util.ArrayList;
import java.util.List;

public class Event {
  public String triggerType;
  public String triggerValue; // e.g., puzzle ID, item ID
  public List<Action> actions = new ArrayList<>();

  public static class Action {
    public String type;
    public Object value;

    public Action() {}

    public Action(String type, Object value) {
      this.type = type;
      this.value = value;
    }
  }
}
