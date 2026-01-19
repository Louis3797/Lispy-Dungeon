package dsl.validation;

import java.util.ArrayList;
import java.util.List;

/** Result of validating an Escape Room definition. */
public class ValidationResult {
  private final List<ValidationError> errors;
  private final List<ValidationWarning> warnings;

  public ValidationResult() {
    this.errors = new ArrayList<>();
    this.warnings = new ArrayList<>();
  }

  public void addError(ValidationError error) {
    errors.add(error);
  }

  public void addWarning(ValidationWarning warning) {
    warnings.add(warning);
  }

  public boolean isValid() {
    return errors.isEmpty();
  }

  public List<ValidationError> getErrors() {
    return new ArrayList<>(errors);
  }

  public List<ValidationWarning> getWarnings() {
    return new ArrayList<>(warnings);
  }

  public boolean hasWarnings() {
    return !warnings.isEmpty();
  }
}
