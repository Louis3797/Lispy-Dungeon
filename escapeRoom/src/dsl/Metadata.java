package dsl;

/**
 * Metadata about the escape room.
 */
public class Metadata {
    public String title;
    public String description;
    public String difficulty;
    public int maxTime;
    public boolean fogOfWar;
    public int viewDistance = 7; // default view distance
    public float cameraZoom = 1.0f; // default zoom level

    @Override
    public String toString() {
        return "Metadata{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", maxTime=" + maxTime +
                ", fogOfWar=" + fogOfWar +
                ", viewDistance=" + viewDistance +
                ", cameraZoom=" + cameraZoom +
                '}';
    }
}
