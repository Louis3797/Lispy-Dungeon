package dsl;

import core.Component;
import task.tasktype.Quiz;

/**
 * Component that stores quiz information for entities.
 *
 * <p>Entities with this component can trigger a quiz when interacted with. The quiz is created from
 * DSL definitions and displayed using the game's UI system.
 */
public class QuizComponent implements Component {
  private final Quiz quiz;
  private final String reward;
  private boolean completed;

  /**
   * Create a new QuizComponent.
   *
   * @param quiz The quiz instance to display
   * @param reward The reward identifier to give on successful completion (can be null)
   */
  public QuizComponent(Quiz quiz, String reward) {
    this.quiz = quiz;
    this.reward = reward;
    this.completed = false;
  }

  /**
   * Get the quiz instance.
   *
   * @return The quiz to display
   */
  public Quiz quiz() {
    return quiz;
  }

  /**
   * Get the reward identifier.
   *
   * @return The reward identifier, or null if no reward
   */
  public String reward() {
    return reward;
  }

  /**
   * Check if the quiz has been completed successfully.
   *
   * @return true if completed, false otherwise
   */
  public boolean isCompleted() {
    return completed;
  }

  /** Mark the quiz as completed. */
  public void markCompleted() {
    this.completed = true;
  }
}
