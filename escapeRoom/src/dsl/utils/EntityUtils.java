package dsl.utils;

import core.Entity;
import core.Game;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Utility class for entity-related operations.
 *
 * <p>Provides methods for: - Finding entities by name or criteria - Checking entity name matches -
 * Entity queries
 */
public final class EntityUtils {

  private static final Logger LOGGER = Logger.getLogger(EntityUtils.class.getSimpleName());

  // Private constructor to prevent instantiation
  private EntityUtils() {
    throw new UnsupportedOperationException("Utility class cannot be instantiated");
  }

  /**
   * Finds an entity by its exact name.
   *
   * @param entityName The name to search for
   * @return Optional containing the found entity, or empty if not found
   * @throws NullPointerException if entityName is null
   */
  public static Optional<Entity> findEntityByName(String entityName) {
    Objects.requireNonNull(entityName, "entityName cannot be null");

    List<Entity> entities = Game.allEntities().toList();

    for (Entity entity : entities) {
      String name = entity.name();
      if (name != null && name.equals(entityName)) {
        return Optional.of(entity);
      }
    }

    return Optional.empty();
  }

  /**
   * Finds an entity by its name (case-insensitive).
   *
   * @param entityName The name to search for
   * @return Optional containing the found entity, or empty if not found
   * @throws NullPointerException if entityName is null
   */
  public static Optional<Entity> findEntityByNameIgnoreCase(String entityName) {
    Objects.requireNonNull(entityName, "entityName cannot be null");

    List<Entity> entities = Game.allEntities().toList();

    for (Entity entity : entities) {
      String name = entity.name();
      if (name != null && name.equalsIgnoreCase(entityName)) {
        return Optional.of(entity);
      }
    }

    return Optional.empty();
  }

  /**
   * Checks if an entity's name matches the given name (case-sensitive).
   *
   * @param entity The entity to check
   * @param expectedName The expected name
   * @return true if names match, false otherwise
   * @throws NullPointerException if entity or expectedName is null
   */
  public static boolean matchesName(Entity entity, String expectedName) {
    Objects.requireNonNull(entity, "entity cannot be null");
    Objects.requireNonNull(expectedName, "expectedName cannot be null");

    String entityName = entity.name();
    return entityName != null && entityName.equals(expectedName);
  }

  /**
   * Checks if an entity's name matches the given name (case-insensitive).
   *
   * @param entity The entity to check
   * @param expectedName The expected name
   * @return true if names match (ignoring case), false otherwise
   * @throws NullPointerException if entity or expectedName is null
   */
  public static boolean matchesNameIgnoreCase(Entity entity, String expectedName) {
    Objects.requireNonNull(entity, "entity cannot be null");
    Objects.requireNonNull(expectedName, "expectedName cannot be null");

    String entityName = entity.name();
    return entityName != null && entityName.equalsIgnoreCase(expectedName);
  }

  /**
   * Finds all entities whose names contain the given substring (case-insensitive).
   *
   * @param substring The substring to search for
   * @return List of entities with names containing the substring
   * @throws NullPointerException if substring is null
   */
  public static List<Entity> findEntitiesByNameContaining(String substring) {
    Objects.requireNonNull(substring, "substring cannot be null");

    String lowerSubstring = substring.toLowerCase();

    return Game.allEntities()
        .filter(
            entity -> {
              String name = entity.name();
              return name != null && name.toLowerCase().contains(lowerSubstring);
            })
        .toList();
  }

  /**
   * Counts entities with a specific name prefix.
   *
   * @param prefix The name prefix to count
   * @return The number of entities with the given prefix
   * @throws NullPointerException if prefix is null
   */
  public static long countEntitiesWithPrefix(String prefix) {
    Objects.requireNonNull(prefix, "prefix cannot be null");

    return Game.allEntities()
        .filter(
            entity -> {
              String name = entity.name();
              return name != null && name.startsWith(prefix);
            })
        .count();
  }

  /**
   * Checks if any entity exists with the given name.
   *
   * @param entityName The name to check for
   * @return true if an entity with this name exists, false otherwise
   * @throws NullPointerException if entityName is null
   */
  public static boolean entityExists(String entityName) {
    Objects.requireNonNull(entityName, "entityName cannot be null");

    return findEntityByName(entityName).isPresent();
  }

  /**
   * Gets the total number of entities in the game.
   *
   * @return The total entity count
   */
  public static long getTotalEntityCount() {
    return Game.allEntities().count();
  }
}
