package dsl.validation;

/** Represents a validation error in the DSL. */
public class ValidationError {
  private final String message;
  private final String location;
  private final ErrorType type;

  public enum ErrorType {
    DUPLICATE_ID,
    MISSING_REQUIRED_FIELD,
    INVALID_REFERENCE,
    INVALID_VALUE,
    SYNTAX_ERROR
  }

  public ValidationError(ErrorType type, String message, String location) {
    this.type = type;
    this.message = message;
    this.location = location;
  }

  public ValidationError(ErrorType type, String message) {
    this(type, message, "unknown");
  }

  public String getMessage() {
    return String.format("[%s] %s (at %s)", type, message, location);
  }

  public ErrorType getType() {
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
