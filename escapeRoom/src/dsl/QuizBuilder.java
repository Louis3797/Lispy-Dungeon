package dsl;

import task.tasktype.Quiz;
import task.tasktype.quizquestion.FreeText;
import task.tasktype.quizquestion.MultipleChoice;
import task.tasktype.quizquestion.SingleChoice;

import java.util.List;

/**
 * Builder for creating Quiz instances from simple data.
 * 
 * <p>
 * Provides a convenient way to create quizzes without dealing with
 * the complexity of the Task/Quiz system directly.
 */
public class QuizBuilder {

    /**
     * Quiz type enumeration.
     */
    public enum QuizType {
        SINGLE_CHOICE,
        MULTIPLE_CHOICE,
        FREE_TEXT
    }

    private String question;
    private QuizType type;
    private List<String> answers;
    private List<Integer> correctIndices;
    private String explanation;

    /**
     * Set the question text.
     */
    public QuizBuilder question(String question) {
        this.question = question;
        return this;
    }

    /**
     * Set the quiz type.
     */
    public QuizBuilder type(QuizType type) {
        this.type = type;
        return this;
    }

    /**
     * Set the answer options.
     */
    public QuizBuilder answers(List<String> answers) {
        this.answers = answers;
        return this;
    }

    /**
     * Set the indices of correct answers (0-based).
     */
    public QuizBuilder correctIndices(List<Integer> correctIndices) {
        this.correctIndices = correctIndices;
        return this;
    }

    /**
     * Set an explanation shown when the quiz is answered incorrectly.
     */
    public QuizBuilder explanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

    /**
     * Build the Quiz instance.
     * 
     * @return The configured Quiz
     * @throws IllegalStateException if required fields are missing
     */
    public Quiz build() {
        if (question == null || question.isEmpty()) {
            throw new IllegalStateException("Question is required");
        }
        if (type == null) {
            throw new IllegalStateException("Quiz type is required");
        }

        Quiz quiz = switch (type) {
            case SINGLE_CHOICE -> new SingleChoice(question);
            case MULTIPLE_CHOICE -> new MultipleChoice(question);
            case FREE_TEXT -> new FreeText(question);
        };

        // Add answers (not for free text)
        if (type != QuizType.FREE_TEXT && answers != null) {
            for (String answer : answers) {
                quiz.addAnswer(new Quiz.Content(answer));
            }
        }

        // Add correct answer indices
        if (correctIndices != null) {
            for (int index : correctIndices) {
                quiz.addCorrectAnswerIndex(index);
            }
        }

        // Set explanation
        if (explanation != null && !explanation.isEmpty()) {
            quiz.explanation(explanation);
        }

        return quiz;
    }

    /**
     * Create a simple single-choice quiz.
     * 
     * @param question     The question text
     * @param answers      List of answer options
     * @param correctIndex The index of the correct answer (0-based)
     * @return The configured Quiz
     */
    public static Quiz createSingleChoice(String question, List<String> answers, int correctIndex) {
        return new QuizBuilder()
                .question(question)
                .type(QuizType.SINGLE_CHOICE)
                .answers(answers)
                .correctIndices(List.of(correctIndex))
                .build();
    }

    /**
     * Create a simple multiple-choice quiz.
     * 
     * @param question       The question text
     * @param answers        List of answer options
     * @param correctIndices The indices of correct answers (0-based)
     * @return The configured Quiz
     */
    public static Quiz createMultipleChoice(String question, List<String> answers, List<Integer> correctIndices) {
        return new QuizBuilder()
                .question(question)
                .type(QuizType.MULTIPLE_CHOICE)
                .answers(answers)
                .correctIndices(correctIndices)
                .build();
    }

    /**
     * Create a simple free-text quiz.
     * 
     * @param question      The question text
     * @param correctAnswer The correct answer text
     * @return The configured Quiz
     */
    public static Quiz createFreeText(String question, String correctAnswer) {
        Quiz quiz = new FreeText(question);
        quiz.addAnswer(new Quiz.Content(correctAnswer));
        quiz.addCorrectAnswerIndex(0);
        return quiz;
    }
}
