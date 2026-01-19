package dsl.validation;

/** Represents a validation warning in the DSL. */
public class ValidationWarning {
  private final String message;
  private final String location;
  private final WarningType type;

  public enum WarningType {
    UNUSED_ITEM,
    MISSING_TEXTURE,
    UNREACHABLE_ROOM,
    SUGGESTED_IMPROVEMENT
  }

  public ValidationWarning(WarningType type, String message, String location) {
    this.type = type;
    this.message = message;
    this.location = location;
  }

  public ValidationWarning(WarningType type, String message) {
    this(type, message, "unknown");
  }

  public String getMessage() {
    return String.format("[WARNING:%s] %s (at %s)", type, message, location);
  }

  public WarningType getType() {
    return type;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public String toString() {
    return getMessage();
  }
}
