package dsl;

import java.util.*;
import java.util.logging.Logger;

/**
 * Validates DSL definitions to catch errors before spawning entities.
 *
 * <p>Performs comprehensive validation including: - Metadata completeness - Room definitions and
 * connections - Item definitions and references - NPC definitions - Quiz definitions and reward
 * references - Cross-references between entities
 */
public class DSLValidator {

  private static final Logger LOGGER = Logger.getLogger(DSLValidator.class.getSimpleName());

  private final List<String> errors = new ArrayList<>();
  private final List<String> warnings = new ArrayList<>();

  /**
   * Validates an entire escape room definition.
   *
   * @param definition The definition to validate
   * @return true if validation passed (no errors), false otherwise
   * @throws NullPointerException if definition is null
   */
  public boolean validate(EscapeRoomDefinition definition) {
    Objects.requireNonNull(definition, "definition cannot be null");

    errors.clear();
    warnings.clear();

    validateMetadata(definition);
    validateRooms(definition);
    validateItems(definition);
    validateNPCs(definition);
    validateQuizzes(definition);
    validateReferences(definition);

    // Log results
    if (!errors.isEmpty()) {
      LOGGER.severe("DSL Validation failed with " + errors.size() + " error(s):");
      for (String error : errors) {
        LOGGER.severe("  ERROR: " + error);
      }
    }

    if (!warnings.isEmpty()) {
      LOGGER.warning("DSL Validation warnings (" + warnings.size() + "):");
      for (String warning : warnings) {
        LOGGER.warning("  WARNING: " + warning);
      }
    }

    if (errors.isEmpty() && warnings.isEmpty()) {
      LOGGER.info("DSL Validation passed successfully");
    }

    return errors.isEmpty();
  }

  /**
   * Gets all validation errors.
   *
   * @return Unmodifiable list of error messages
   */
  public List<String> getErrors() {
    return Collections.unmodifiableList(errors);
  }

  /**
   * Gets all validation warnings.
   *
   * @return Unmodifiable list of warning messages
   */
  public List<String> getWarnings() {
    return Collections.unmodifiableList(warnings);
  }

  /** Validates metadata section. */
  private void validateMetadata(EscapeRoomDefinition definition) {
    if (definition.metadata == null) {
      errors.add("Metadata: metadata section is missing");
      return;
    }

    if (definition.metadata.title == null || definition.metadata.title.trim().isEmpty()) {
      errors.add("Metadata: title is missing or empty");
    }

    if (definition.metadata.description == null
        || definition.metadata.description.trim().isEmpty()) {
      warnings.add("Metadata: description is missing or empty");
    }
  }

  /** Validates room definitions. */
  private void validateRooms(EscapeRoomDefinition definition) {
    if (definition.rooms == null || definition.rooms.isEmpty()) {
      errors.add("Rooms: No rooms defined");
      return;
    }

    Set<String> roomIds = new HashSet<>();

    for (Map.Entry<String, Room> entry : definition.rooms.entrySet()) {
      String roomId = entry.getKey();
      Room room = entry.getValue();

      if (roomId == null || roomId.trim().isEmpty()) {
        errors.add("Rooms: Found room with empty ID");
        continue;
      }

      if (roomIds.contains(roomId)) {
        errors.add("Rooms: Duplicate room ID '" + roomId + "'");
      }
      roomIds.add(roomId);

      // Validate room dimensions
      if (room.width < 0) {
        errors.add("Room '" + roomId + "': width cannot be negative (" + room.width + ")");
      }
      if (room.height < 0) {
        errors.add("Room '" + roomId + "': height cannot be negative (" + room.height + ")");
      }

      // Validate room position
      if (room.x < 0) {
        warnings.add("Room '" + roomId + "': x position is negative (" + room.x + ")");
      }
      if (room.y < 0) {
        warnings.add("Room '" + roomId + "': y position is negative (" + room.y + ")");
      }

      // Validate connections
      if (room.connections != null) {
        for (String targetRoomId : room.connections) {
          if (targetRoomId == null || targetRoomId.trim().isEmpty()) {
            errors.add("Room '" + roomId + "': has empty connection target");
          }
        }
      }

      // Validate locked_by reference (will be checked in validateReferences)
      if (room.lockedBy != null && room.lockedBy.trim().isEmpty()) {
        errors.add("Room '" + roomId + "': locked_by is empty (should be item ID or null)");
      }
    }
  }

  /** Validates item definitions. */
  private void validateItems(EscapeRoomDefinition definition) {
    if (definition.items == null || definition.items.isEmpty()) {
      warnings.add("Items: No items defined");
      return;
    }

    Set<String> itemIds = new HashSet<>();

    for (Map.Entry<String, Item> entry : definition.items.entrySet()) {
      String itemId = entry.getKey();
      Item item = entry.getValue();

      if (itemId == null || itemId.trim().isEmpty()) {
        errors.add("Items: Found item with empty ID");
        continue;
      }

      if (itemIds.contains(itemId)) {
        errors.add("Items: Duplicate item ID '" + itemId + "'");
      }
      itemIds.add(itemId);

      // Validate item type
      if (item.type == null || item.type.trim().isEmpty()) {
        warnings.add("Item '" + itemId + "': type is missing, will default to 'tool'");
      } else {
        String type = item.type.toLowerCase();
        if (!Arrays.asList("key", "readable", "consumable", "tool").contains(type)) {
          warnings.add(
              "Item '"
                  + itemId
                  + "': unknown type '"
                  + type
                  + "' (valid: key, readable, consumable, tool)");
        }
      }

      // Validate readable content
      if (item.readable && (item.content == null || item.content.trim().isEmpty())) {
        warnings.add("Item '" + itemId + "': marked as readable but has no content");
      }

      // Validate texture path
      if (item.texture == null || item.texture.trim().isEmpty()) {
        warnings.add("Item '" + itemId + "': no texture specified, will use default");
      }

      // Validate description
      if (item.description == null || item.description.trim().isEmpty()) {
        warnings.add("Item '" + itemId + "': no description provided");
      }
    }
  }

  /** Validates NPC definitions. */
  private void validateNPCs(EscapeRoomDefinition definition) {
    if (definition.npcs == null || definition.npcs.isEmpty()) {
      warnings.add("NPCs: No NPCs defined");
      return;
    }

    Set<String> npcIds = new HashSet<>();

    for (Map.Entry<String, NPC> entry : definition.npcs.entrySet()) {
      String npcId = entry.getKey();
      NPC npc = entry.getValue();

      if (npcId == null || npcId.trim().isEmpty()) {
        errors.add("NPCs: Found NPC with empty ID");
        continue;
      }

      if (npcIds.contains(npcId)) {
        errors.add("NPCs: Duplicate NPC ID '" + npcId + "'");
      }
      npcIds.add(npcId);

      // Validate hostile NPC stats
      if (npc.hostile) {
        if (npc.health <= 0) {
          warnings.add("NPC '" + npcId + "': hostile NPC has health <= 0, will use default");
        }
        if (npc.damage <= 0) {
          warnings.add("NPC '" + npcId + "': hostile NPC has damage <= 0, will use default");
        }
      }

      // Validate texture
      if (npc.texture == null || npc.texture.trim().isEmpty()) {
        warnings.add("NPC '" + npcId + "': no texture specified, will use default");
      }
    }
  }

  /** Validates quiz definitions. */
  private void validateQuizzes(EscapeRoomDefinition definition) {
    if (definition.quizzes == null || definition.quizzes.isEmpty()) {
      // Quizzes are optional
      return;
    }

    Set<String> quizIds = new HashSet<>();

    for (Map.Entry<String, Quiz> entry : definition.quizzes.entrySet()) {
      String quizId = entry.getKey();
      Quiz quiz = entry.getValue();

      if (quizId == null || quizId.trim().isEmpty()) {
        errors.add("Quizzes: Found quiz with empty ID");
        continue;
      }

      if (quizIds.contains(quizId)) {
        errors.add("Quizzes: Duplicate quiz ID '" + quizId + "'");
      }
      quizIds.add(quizId);

      // Validate question
      if (quiz.question == null || quiz.question.trim().isEmpty()) {
        errors.add("Quiz '" + quizId + "': question is missing or empty");
      }

      // Validate type
      if (quiz.type != null && !quiz.type.trim().isEmpty()) {
        String type = quiz.type.toLowerCase();
        if (!Arrays.asList("single_choice", "multiple_choice", "free_text").contains(type)) {
          warnings.add(
              "Quiz '"
                  + quizId
                  + "': unknown type '"
                  + type
                  + "' (valid: single_choice, multiple_choice, free_text)");
        }
      }

      // Validate answers
      if (quiz.answers == null || quiz.answers.isEmpty()) {
        errors.add("Quiz '" + quizId + "': no answers provided");
      } else {
        // Validate correct answers
        if (quiz.correctAnswers == null || quiz.correctAnswers.isEmpty()) {
          errors.add("Quiz '" + quizId + "': no correct answers specified");
        } else {
          int maxIndex = quiz.answers.size() - 1;
          for (Integer correctIdx : quiz.correctAnswers) {
            if (correctIdx < 0 || correctIdx > maxIndex) {
              errors.add(
                  "Quiz '"
                      + quizId
                      + "': correct answer index "
                      + correctIdx
                      + " is out of bounds (0-"
                      + maxIndex
                      + ")");
            }
          }
        }
      }

      // Validate attached_to
      if (quiz.attachedTo != null
          && !quiz.attachedTo.trim().isEmpty()
          && !quiz.attachedTo.equals("chest")) {
        // Will be validated in validateReferences
      }

      // Validate reward (will be checked in validateReferences)
      if (quiz.reward != null && quiz.reward.trim().isEmpty()) {
        warnings.add("Quiz '" + quizId + "': reward is empty string (should be item ID or null)");
      }
    }
  }

  /** Validates cross-references between entities. */
  private void validateReferences(EscapeRoomDefinition definition) {
    Set<String> roomIds =
        definition.rooms != null ? definition.rooms.keySet() : Collections.emptySet();
    Set<String> itemIds =
        definition.items != null ? definition.items.keySet() : Collections.emptySet();
    Set<String> npcIds =
        definition.npcs != null ? definition.npcs.keySet() : Collections.emptySet();

    // Validate room connections
    if (definition.rooms != null) {
      for (Map.Entry<String, Room> entry : definition.rooms.entrySet()) {
        String roomId = entry.getKey();
        Room room = entry.getValue();

        // Validate connection targets exist
        if (room.connections != null) {
          for (String targetRoomId : room.connections) {
            if (!roomIds.contains(targetRoomId)) {
              errors.add(
                  "Room '" + roomId + "': connection target '" + targetRoomId + "' does not exist");
            }
          }
        }

        // Validate locked_by item exists
        if (room.lockedBy != null && !room.lockedBy.trim().isEmpty()) {
          if (!itemIds.contains(room.lockedBy)) {
            errors.add(
                "Room '" + roomId + "': locked_by item '" + room.lockedBy + "' is not defined");
          }
        }
      }
    }

    // Validate quiz references
    if (definition.quizzes != null) {
      for (Map.Entry<String, Quiz> entry : definition.quizzes.entrySet()) {
        String quizId = entry.getKey();
        Quiz quiz = entry.getValue();

        // Validate attached_to entity exists
        if (quiz.attachedTo != null
            && !quiz.attachedTo.trim().isEmpty()
            && !quiz.attachedTo.equals("chest")) {
          boolean found = npcIds.contains(quiz.attachedTo) || itemIds.contains(quiz.attachedTo);
          if (!found) {
            errors.add(
                "Quiz '"
                    + quizId
                    + "': attached_to entity '"
                    + quiz.attachedTo
                    + "' is not defined (should be NPC ID, item ID, or 'chest')");
          }
        }

        // Validate reward item exists
        if (quiz.reward != null && !quiz.reward.trim().isEmpty()) {
          if (!itemIds.contains(quiz.reward)) {
            errors.add("Quiz '" + quizId + "': reward item '" + quiz.reward + "' is not defined");
          }
        }
      }
    }
  }
}
