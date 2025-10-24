package dsl;

import java.util.List;
import java.util.Map;

/**
 * Represents a complete escape room definition parsed from DSL.
 */
public class EscapeRoomDefinition {
    public Metadata metadata;
    public Map<String, Room> rooms;
    public Map<String, Quiz> quizzes;
    public Map<String, Item> items;
    public Map<String, NPC> npcs;

    /**
     * Get the title of the escape room, or a default if not set.
     */
    public String getTitle() {
        return metadata != null && metadata.title != null ? metadata.title : "Escape Room";
    }

    @Override
    public String toString() {
        return "EscapeRoomDefinition{" +
                "metadata=" + metadata +
                ", rooms=" + (rooms != null ? rooms.size() : 0) +
                ", quizzes=" + (quizzes != null ? quizzes.size() : 0) +
                ", items=" + (items != null ? items.size() : 0) +
                ", npcs=" + (npcs != null ? npcs.size() : 0) +
                '}';
    }
}

/**
 * Metadata about the escape room.
 */
class Metadata {
    public String title;
    public String description;
    public String difficulty;
    public int maxTime;

    @Override
    public String toString() {
        return "Metadata{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", maxTime=" + maxTime +
                '}';
    }
}

/**
 * Represents a room in the escape room.
 */
class Room {
    public String description;
    public int x, y, width, height;
    public List<String> items;
    public List<String> connections;
    public String lockedBy;
    public String atmosphere;

    @Override
    public String toString() {
        return "Room{" +
                "description='" + description + '\'' +
                ", position=(" + x + "," + y + ")" +
                ", size=" + width + "x" + height +
                '}';
    }
}

/**
 * Represents a quiz in the escape room.
 */
class Quiz {
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

/**
 * Represents an item in the escape room.
 */
class Item {
    public String description;
    public String type;
    public String texture;
    public boolean visible;
    public boolean readable;
    public String content;

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", texture='" + texture + '\'' +
                '}';
    }
}

/**
 * Represents an NPC in the escape room.
 */
class NPC {
    public String description;
    public String texture;
    public String location;
    public Map<String, String> dialogue;

    @Override
    public String toString() {
        return "NPC{" +
                "description='" + description + '\'' +
                ", texture='" + texture + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
