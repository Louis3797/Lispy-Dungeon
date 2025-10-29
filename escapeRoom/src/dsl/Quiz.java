package dsl;

import java.util.List;

/**
 * Represents a quiz in the escape room.
 */
public class Quiz {
    public String type;
    public String question;
    public List<String> answers;
    public List<Integer> correctAnswers;
    public String explanation;
    public String reward;
    public String attachedTo;

    @Override
    public String toString() {
        return "Quiz{" +
                "type='" + type + '\'' +
                ", question='" + question + '\'' +
                ", attachedTo='" + attachedTo + '\'' +
                ", reward='" + reward + '\'' +
                '}';
    }
}
