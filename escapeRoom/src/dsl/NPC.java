package dsl;

import java.util.Map;

/**
 * Represents an NPC in the escape room.
 */
public class NPC {
    public String description;
    public String texture;
    public String location;
    public Map<String, String> dialogue;
    public boolean hostile;
    public int health;
    public int damage;

    @Override
    public String toString() {
        return "NPC{" +
                "description='" + description + '\'' +
                ", texture='" + texture + '\'' +
                ", location='" + location + '\'' +
                ", hostile=" + hostile +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}
