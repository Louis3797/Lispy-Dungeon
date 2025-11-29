package dsl;

import java.util.Map;

/**
 * Represents a complete escape room definition parsed from DSL.
 */
public class EscapeRoomDefinition {
    public Metadata metadata;
    public Map<String, Room> rooms;
    public Player player;

    /**
     * Get the title of the escape room, or a default if not set.
     */
    public String getTitle() {
        return metadata != null && metadata.title != null ? metadata.title : "Escape Room";
    }

    /**
     * Check if fog of war is enabled.
     */
    public boolean isFogOfWarEnabled() {
        return metadata != null && metadata.fogOfWar;
    }

    /**
     * Get the fog of war view distance.
     */
    public int getFogViewDistance() {
        return metadata != null ? metadata.viewDistance : 7;
    }

    /**
     * Get the camera zoom level.
     */
    public float getCameraZoom() {
        return metadata != null ? metadata.cameraZoom : 1.0f;
    }

    @Override
    public String toString() {
        return "EscapeRoomDefinition{" +
                "metadata=" + metadata +
                ", rooms=" + (rooms != null ? rooms.size() : 0) +
                '}';
    }
}
