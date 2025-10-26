package dsl.utils;

import core.Game;
import core.level.DungeonLevel;
import core.level.Tile;
import core.utils.Point;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Utility class for position-related operations in escape room levels.
 * 
 * <p>
 * Provides methods for:
 * - Finding random floor positions
 * - Getting positions within specific areas
 * - Calculating distances between points
 */
public final class PositionUtils {

    private static final Logger LOGGER = Logger.getLogger(PositionUtils.class.getSimpleName());
    private static final Random RANDOM = new Random();

    // Private constructor to prevent instantiation
    private PositionUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Gets a random floor tile position in the current level.
     * 
     * @return A random floor position, or null if no floor tiles available
     */
    public static Point getRandomFloorPosition() {
        var levelOpt = Game.currentLevel();
        if (levelOpt.isEmpty()) {
            LOGGER.warning("Cannot get random floor position: no level loaded");
            return null;
        }

        var level = (DungeonLevel) levelOpt.get();
        List<Tile> floorTiles = level.floorTiles().stream()
                .map(tile -> (Tile) tile)
                .toList();

        if (floorTiles.isEmpty()) {
            LOGGER.warning("Cannot get random floor position: no floor tiles in level");
            return null;
        }

        Tile randomTile = floorTiles.get(RANDOM.nextInt(floorTiles.size()));
        return randomTile.position();
    }

    /**
     * Gets a random floor position within a specific rectangular area.
     * 
     * @param minX Minimum X coordinate (inclusive)
     * @param minY Minimum Y coordinate (inclusive)
     * @param maxX Maximum X coordinate (inclusive)
     * @param maxY Maximum Y coordinate (inclusive)
     * @return A random floor position within the bounds, or null if none available
     */
    public static Point getRandomFloorPositionInArea(int minX, int minY, int maxX, int maxY) {
        var levelOpt = Game.currentLevel();
        if (levelOpt.isEmpty()) {
            LOGGER.warning("Cannot get random floor position: no level loaded");
            return null;
        }

        var level = (DungeonLevel) levelOpt.get();
        List<Tile> floorTiles = level.floorTiles().stream()
                .map(tile -> (Tile) tile)
                .filter(tile -> {
                    Point pos = tile.position();
                    return pos.x() >= minX && pos.x() <= maxX && pos.y() >= minY && pos.y() <= maxY;
                })
                .toList();

        if (floorTiles.isEmpty()) {
            LOGGER.warning("Cannot get random floor position: no floor tiles in specified area");
            return null;
        }

        Tile randomTile = floorTiles.get(RANDOM.nextInt(floorTiles.size()));
        return randomTile.position();
    }

    /**
     * Calculates the Manhattan distance between two points.
     * 
     * @param p1 First point
     * @param p2 Second point
     * @return The Manhattan distance
     * @throws NullPointerException if either point is null
     */
    public static int manhattanDistance(Point p1, Point p2) {
        Objects.requireNonNull(p1, "p1 cannot be null");
        Objects.requireNonNull(p2, "p2 cannot be null");

        return (int) (Math.abs(p1.x() - p2.x()) + Math.abs(p1.y() - p2.y()));
    }

    /**
     * Calculates the Euclidean distance between two points.
     * 
     * @param p1 First point
     * @param p2 Second point
     * @return The Euclidean distance
     * @throws NullPointerException if either point is null
     */
    public static double euclideanDistance(Point p1, Point p2) {
        Objects.requireNonNull(p1, "p1 cannot be null");
        Objects.requireNonNull(p2, "p2 cannot be null");

        float dx = p1.x() - p2.x();
        float dy = p1.y() - p2.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Checks if a point is within a rectangular area.
     * 
     * @param point The point to check
     * @param minX  Minimum X coordinate (inclusive)
     * @param minY  Minimum Y coordinate (inclusive)
     * @param maxX  Maximum X coordinate (inclusive)
     * @param maxY  Maximum Y coordinate (inclusive)
     * @return true if point is within bounds, false otherwise
     * @throws NullPointerException if point is null
     */
    public static boolean isWithinBounds(Point point, int minX, int minY, int maxX, int maxY) {
        Objects.requireNonNull(point, "point cannot be null");

        return point.x() >= minX && point.x() <= maxX && point.y() >= minY && point.y() <= maxY;
    }

    /**
     * Creates a new point with an offset applied.
     * 
     * @param point The original point
     * @param dx    X offset
     * @param dy    Y offset
     * @return A new point with the offset applied
     * @throws NullPointerException if point is null
     */
    public static Point offset(Point point, int dx, int dy) {
        Objects.requireNonNull(point, "point cannot be null");

        return point.translate(dx, dy);
    }
}
