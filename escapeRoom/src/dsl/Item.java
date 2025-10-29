package dsl;

/**
 * Represents an item in the escape room.
 */
public class Item {
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
