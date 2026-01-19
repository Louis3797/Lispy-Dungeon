package dsl;

import contrib.hud.dialogs.OkDialog;
import core.Entity;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import task.Task;
import task.game.hud.QuizUI;
import task.game.hud.UIAnswerCallback;

/**
 * Utility class for handling quiz interactions.
 *
 * <p>Provides methods to show quiz dialogs and handle completion with rewards.
 */
public class QuizInteractionHandler {
  private static final Logger LOGGER = Logger.getLogger(QuizInteractionHandler.class.getName());

  /**
   * Create an interaction handler that shows a quiz dialog.
   *
   * @param quizComponent The quiz component containing the quiz data
   * @param onSuccess Optional callback to execute on successful completion
   * @param onFailure Optional callback to execute on failure
   * @return BiConsumer that can be used with InteractionComponent
   */
  public static BiConsumer<Entity, Entity> createQuizInteraction(
      QuizComponent quizComponent, Runnable onSuccess, Runnable onFailure) {

    return (entity, hero) -> {
      // Don't show quiz again if already completed
      if (quizComponent.isCompleted()) {
        OkDialog.showOkDialog(
            "Du hast diese Aufgabe bereits gelöst!", "Bereits abgeschlossen", () -> {});
        return;
      }

      // Show the quiz dialog
      QuizUI.showQuizDialog(
          quizComponent.quiz(),
          (Entity dialogEntity) ->
              UIAnswerCallback.uiCallback(
                  quizComponent.quiz(),
                  dialogEntity,
                  (task, taskContents) -> {
                    // Grade the quiz
                    float score = task.gradeTask(taskContents);
                    boolean success = task.state() == Task.TaskState.FINISHED_CORRECT;

                    // Build result message
                    StringBuilder output = new StringBuilder();
                    output
                        .append("Du hast ")
                        .append(score)
                        .append("/")
                        .append(task.points())
                        .append(" Punkte erreicht!\n")
                        .append("Die Aufgabe ist damit ");

                    if (success) {
                      output.append("korrekt gelöst!");
                      quizComponent.markCompleted();

                      // Give reward if specified - the reward message will be shown by the callback
                      String reward = quizComponent.reward();
                      if (reward != null && !reward.isEmpty()) {
                        output.append("\n\nDu hast '").append(reward).append("' erhalten!");
                      }
                    } else {
                      output.append("falsch gelöst.");
                    }

                    // Show result dialog
                    OkDialog.showOkDialog(
                        output.toString(),
                        success ? "Erfolg!" : "Gescheitert",
                        () -> {
                          if (success && onSuccess != null) {
                            onSuccess.run(); // Actually give the reward!
                          } else if (!success && onFailure != null) {
                            onFailure.run();
                          }

                          // Show correct answers on failure
                          if (!success && score < task.points()) {
                            if (!task.explanation().isBlank()
                                && !task.explanation().equals(Task.DEFAULT_EXPLANATION)) {
                              OkDialog.showOkDialog(
                                  task.explanation(), "Erklärung", () -> showCorrectAnswers(task));
                            } else {
                              showCorrectAnswers(task);
                            }
                          }
                        });
                  }));
    };
  }

  /** Show the correct answers for a task. */
  private static void showCorrectAnswers(Task task) {
    OkDialog.showOkDialog(task.correctAnswersAsString(), "Korrekte Antwort", () -> {});
  }

  /**
   * Create a simple quiz interaction with no callbacks.
   *
   * @param quizComponent The quiz component
   * @return BiConsumer for use with InteractionComponent
   */
  public static BiConsumer<Entity, Entity> createQuizInteraction(QuizComponent quizComponent) {
    return createQuizInteraction(quizComponent, null, null);
  }
}
