package dsl.validation;

import dsl.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Validates an EscapeRoomDefinition for correctness and completeness.
 */
public class EscapeRoomValidator {

    public ValidationResult validate(EscapeRoomDefinition definition) {
        ValidationResult result = new ValidationResult();

        // Validate metadata
        validateMetadata(definition.metadata, result);

        // Validate rooms
        if (definition.rooms != null) {
            validateRooms(definition.rooms, result);
        } else {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                    "At least one room is required",
                    "rooms"));
        }

        // Validate items
        if (definition.items != null) {
            validateItems(definition.items, result);
        }

        // Validate NPCs
        if (definition.npcs != null) {
            validateNPCs(definition.npcs, definition.rooms, result);
        }

        // Validate quizzes
        if (definition.quizzes != null) {
            validateQuizzes(definition.quizzes, definition.items, result);
        }

        // Validate player
        if (definition.player != null) {
            validatePlayer(definition.player, result);
        }

        // Cross-validate references
        validateReferences(definition, result);

        return result;
    }

    private void validateMetadata(Metadata metadata, ValidationResult result) {
        if (metadata == null) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                    "Metadata section is required",
                    "metadata"));
            return;
        }

        if (metadata.title == null || metadata.title.isEmpty()) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                    "Metadata title is required",
                    "metadata.title"));
        }

        if (metadata.description == null || metadata.description.isEmpty()) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                    "Metadata description is required",
                    "metadata.description"));
        }

        if (metadata.difficulty == null || metadata.difficulty.isEmpty()) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                    "Metadata difficulty is required",
                    "metadata.difficulty"));
        }

        if (metadata.maxTime <= 0) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.INVALID_VALUE,
                    "Metadata max_time must be positive",
                    "metadata.max_time"));
        }

        if (metadata.viewDistance < 1) {
            result.addWarning(new ValidationWarning(
                    ValidationWarning.WarningType.SUGGESTED_IMPROVEMENT,
                    "View distance less than 1 may cause visibility issues",
                    "metadata.view_distance"));
        }

        if (metadata.cameraZoom < 0.5f || metadata.cameraZoom > 2.0f) {
            result.addWarning(new ValidationWarning(
                    ValidationWarning.WarningType.SUGGESTED_IMPROVEMENT,
                    "Camera zoom outside recommended range (0.5 - 2.0)",
                    "metadata.camera_zoom"));
        }
    }

    private void validateRooms(java.util.Map<String, Room> rooms, ValidationResult result) {
        Set<String> roomIds = new HashSet<>();

        for (var entry : rooms.entrySet()) {
            String roomId = entry.getKey();
            Room room = entry.getValue();

            // Check for duplicates
            if (!roomIds.add(roomId)) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.DUPLICATE_ID,
                        "Duplicate room ID: " + roomId,
                        "rooms." + roomId));
            }

            // Validate room properties
            if (room.description == null || room.description.isEmpty()) {
                result.addWarning(new ValidationWarning(
                        ValidationWarning.WarningType.SUGGESTED_IMPROVEMENT,
                        "Room missing description: " + roomId,
                        "rooms." + roomId));
            }

            // Check if room has either dimensions or pattern
            // Width/height of 0 means auto-size from pattern, which is valid
            boolean hasExplicitDimensions = room.width > 0 && room.height > 0;
            boolean hasPattern = room.pattern != null && !room.pattern.isEmpty();

            if (!hasExplicitDimensions && !hasPattern) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.INVALID_VALUE,
                        "Room must have either explicit width/height or a pattern: " + roomId,
                        "rooms." + roomId));
            }

            // If dimensions are negative, that's an error
            if (room.width < 0) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.INVALID_VALUE,
                        "Room width cannot be negative: " + roomId,
                        "rooms." + roomId + ".width"));
            }

            if (room.height < 0) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.INVALID_VALUE,
                        "Room height cannot be negative: " + roomId,
                        "rooms." + roomId + ".height"));
            }
        }
    }

    private void validateItems(java.util.Map<String, Item> items, ValidationResult result) {
        Set<String> itemIds = new HashSet<>();

        for (var entry : items.entrySet()) {
            String itemId = entry.getKey();
            Item item = entry.getValue();

            // Check for duplicates
            if (!itemIds.add(itemId)) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.DUPLICATE_ID,
                        "Duplicate item ID: " + itemId,
                        "items." + itemId));
            }

            // Validate required fields
            if (item.type == null || item.type.isEmpty()) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                        "Item missing type: " + itemId,
                        "items." + itemId + ".type"));
            }

            if (item.texture == null || item.texture.isEmpty()) {
                result.addWarning(new ValidationWarning(
                        ValidationWarning.WarningType.MISSING_TEXTURE,
                        "Item missing texture: " + itemId,
                        "items." + itemId + ".texture"));
            }
        }
    }

    private void validateNPCs(java.util.Map<String, NPC> npcs,
            java.util.Map<String, Room> rooms,
            ValidationResult result) {
        Set<String> npcIds = new HashSet<>();

        for (var entry : npcs.entrySet()) {
            String npcId = entry.getKey();
            NPC npc = entry.getValue();

            // Check for duplicates
            if (!npcIds.add(npcId)) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.DUPLICATE_ID,
                        "Duplicate NPC ID: " + npcId,
                        "npcs." + npcId));
            }

            // Validate location
            if (npc.location == null || npc.location.isEmpty()) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                        "NPC missing location: " + npcId,
                        "npcs." + npcId + ".location"));
            } else if (rooms != null && !rooms.containsKey(npc.location)) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.INVALID_REFERENCE,
                        "NPC location references non-existent room: " + npc.location,
                        "npcs." + npcId + ".location"));
            }

            // Validate hostile NPCs
            if (npc.hostile) {
                if (npc.health <= 0) {
                    result.addError(new ValidationError(
                            ValidationError.ErrorType.INVALID_VALUE,
                            "Hostile NPC must have positive health: " + npcId,
                            "npcs." + npcId + ".health"));
                }
            }
        }
    }

    private void validateQuizzes(java.util.Map<String, Quiz> quizzes,
            java.util.Map<String, Item> items,
            ValidationResult result) {
        Set<String> quizIds = new HashSet<>();

        for (var entry : quizzes.entrySet()) {
            String quizId = entry.getKey();
            Quiz quiz = entry.getValue();

            // Check for duplicates
            if (!quizIds.add(quizId)) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.DUPLICATE_ID,
                        "Duplicate quiz ID: " + quizId,
                        "quizzes." + quizId));
            }

            // Validate required fields
            if (quiz.question == null || quiz.question.isEmpty()) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                        "Quiz missing question: " + quizId,
                        "quizzes." + quizId + ".question"));
            }

            if (quiz.answers == null || quiz.answers.isEmpty()) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                        "Quiz missing answers: " + quizId,
                        "quizzes." + quizId + ".answers"));
            }

            if (quiz.correctAnswers == null || quiz.correctAnswers.isEmpty()) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.MISSING_REQUIRED_FIELD,
                        "Quiz missing correct_answers: " + quizId,
                        "quizzes." + quizId + ".correct_answers"));
            }

            // Validate correct answers indices
            if (quiz.answers != null && quiz.correctAnswers != null) {
                for (int index : quiz.correctAnswers) {
                    if (index < 0 || index >= quiz.answers.size()) {
                        result.addError(new ValidationError(
                                ValidationError.ErrorType.INVALID_VALUE,
                                "Quiz correct answer index out of range: " + index,
                                "quizzes." + quizId + ".correct_answers"));
                    }
                }
            }

            // Validate reward reference
            if (quiz.reward != null && items != null && !items.containsKey(quiz.reward)) {
                result.addError(new ValidationError(
                        ValidationError.ErrorType.INVALID_REFERENCE,
                        "Quiz reward references non-existent item: " + quiz.reward,
                        "quizzes." + quizId + ".reward"));
            }
        }
    }

    private void validatePlayer(Player player, ValidationResult result) {
        if (player.health != null && player.health <= 0) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.INVALID_VALUE,
                    "Player health must be positive",
                    "player.health"));
        }

        if (player.speed != null && player.speed <= 0) {
            result.addError(new ValidationError(
                    ValidationError.ErrorType.INVALID_VALUE,
                    "Player speed must be positive",
                    "player.speed"));
        }

        if (player.manaRestore != null && player.manaRestore < 0) {
            result.addWarning(new ValidationWarning(
                    ValidationWarning.WarningType.SUGGESTED_IMPROVEMENT,
                    "Player mana_restore is negative",
                    "player.mana_restore"));
        }
    }

    private void validateReferences(EscapeRoomDefinition definition, ValidationResult result) {
        // Validate room connections
        if (definition.rooms != null) {
            for (var entry : definition.rooms.entrySet()) {
                String roomId = entry.getKey();
                Room room = entry.getValue();

                if (room.connections != null) {
                    for (String targetRoom : room.connections) {
                        if (!definition.rooms.containsKey(targetRoom)) {
                            result.addError(new ValidationError(
                                    ValidationError.ErrorType.INVALID_REFERENCE,
                                    "Room connection references non-existent room: " + targetRoom,
                                    "rooms." + roomId + ".connections"));
                        }
                    }
                }

                // Validate locked_by
                if (room.lockedBy != null && definition.items != null &&
                        !definition.items.containsKey(room.lockedBy)) {
                    result.addError(new ValidationError(
                            ValidationError.ErrorType.INVALID_REFERENCE,
                            "Room locked_by references non-existent item: " + room.lockedBy,
                            "rooms." + roomId + ".locked_by"));
                }
            }
        }
    }
}
