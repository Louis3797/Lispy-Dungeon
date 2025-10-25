package dsl;

/**
 * Represents the player configuration in the escape room DSL.
 */
public class Player {
    public String characterClass; // "wizard" or "hunter"
    public Integer startX;
    public Integer startY;

    @Override
    public String toString() {
        return "Player{" +
                "class='" + characterClass + '\'' +
                ", startX=" + startX +
                ", startY=" + startY +
                '}';
    }
}
