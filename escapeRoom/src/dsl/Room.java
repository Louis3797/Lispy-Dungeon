package dsl;

import java.util.List;

/**
 * Represents a room in the escape room.
 */
public class Room {
    public String description;
    public int x, y, width, height;
    public String pattern; // ASCII art pattern for custom room shapes
    public List<String> items;
    public List<String> connections;
    public String lockedBy;

    @Override
    public String toString() {
        return "Room{" +
                "description='" + description + '\'' +
                ", position=(" + x + "," + y + ")" +
                ", size=" + width + "x" + height +
                ", hasPattern=" + (pattern != null) +
                '}';
    }
}
