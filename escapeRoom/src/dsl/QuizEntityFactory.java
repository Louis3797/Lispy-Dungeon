package dsl;

import contrib.components.CollideComponent;
import contrib.components.HealthComponent;
import contrib.components.InteractionComponent;
import contrib.entities.EntityFactory;
import core.Entity;
import core.components.DrawComponent;
import core.components.PositionComponent;
import core.utils.Point;
import core.utils.components.path.SimpleIPath;
import task.tasktype.Quiz;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Factory for creating entities with quiz interactions.
 * 
 * <p>
 * Provides convenient methods to spawn chests, NPCs, and other
 * entities that trigger quizzes when interacted with.
 */
public class QuizEntityFactory {

    private static final String DEFAULT_NPC_TEXTURE = "character/monster/chort";

    /**
     * Create a chest that shows a quiz when opened.
     * 
     * @param position  The position to spawn the chest
     * @param quiz      The quiz to show
     * @param reward    The reward identifier (can be null)
     * @param onSuccess Callback when quiz is solved successfully (can be null)
     * @return The chest entity
     */
    public static Entity createQuizChest(Point position, Quiz quiz, String reward, Runnable onSuccess) {
        try {
            // Create a basic chest
            Entity chest = EntityFactory.newChest(Set.of(), position);

            // Remove default interaction if any
            chest.remove(InteractionComponent.class);

            // Add quiz component
            QuizComponent quizComponent = new QuizComponent(quiz, reward);
            chest.add(quizComponent);

            // Add quiz interaction
            BiConsumer<Entity, Entity> quizInteraction = QuizInteractionHandler.createQuizInteraction(quizComponent,
                    onSuccess, null);

            chest.add(new InteractionComponent(
                    InteractionComponent.DEFAULT_INTERACTION_RADIUS,
                    true,
                    quizInteraction));

            return chest;
        } catch (IOException e) {
            throw new RuntimeException("Failed to create quiz chest", e);
        }
    }

    /**
     * Create a chest that shows a quiz when opened (without callbacks).
     * 
     * @param position The position to spawn the chest
     * @param quiz     The quiz to show
     * @param reward   The reward identifier (can be null)
     * @return The chest entity
     */
    public static Entity createQuizChest(Point position, Quiz quiz, String reward) {
        return createQuizChest(position, quiz, reward, null);
    }

    /**
     * Create an NPC that asks a quiz when talked to.
     * 
     * @param position    The position to spawn the NPC
     * @param texturePath The texture path for the NPC
     * @param quiz        The quiz to show
     * @param reward      The reward identifier (can be null)
     * @param onSuccess   Callback when quiz is solved successfully (can be null)
     * @return The NPC entity
     */
    public static Entity createQuizNPC(Point position, String texturePath, Quiz quiz,
            String reward, Runnable onSuccess) {
        Entity npc = new Entity("QuizNPC");

        // Basic components
        npc.add(new PositionComponent(position));
        npc.add(new DrawComponent(new SimpleIPath(texturePath)));
        npc.add(new CollideComponent());

        // Make invincible
        npc.add(new HealthComponent(9999, (entity) -> {
        }));

        // Add quiz component
        QuizComponent quizComponent = new QuizComponent(quiz, reward);
        npc.add(quizComponent);

        // Add quiz interaction
        BiConsumer<Entity, Entity> quizInteraction = QuizInteractionHandler.createQuizInteraction(quizComponent,
                onSuccess, null);

        npc.add(new InteractionComponent(
                InteractionComponent.DEFAULT_INTERACTION_RADIUS,
                true,
                quizInteraction));

        return npc;
    }

    /**
     * Create an NPC that asks a quiz when talked to (with default texture).
     * 
     * @param position The position to spawn the NPC
     * @param quiz     The quiz to show
     * @param reward   The reward identifier (can be null)
     * @return The NPC entity
     */
    public static Entity createQuizNPC(Point position, Quiz quiz, String reward) {
        return createQuizNPC(position, DEFAULT_NPC_TEXTURE, quiz, reward, null);
    }

    /**
     * Example: Create a test quiz chest with a simple single-choice question.
     * 
     * @param position The position to spawn
     * @return The quiz chest entity
     */
    public static Entity createExampleQuizChest(Point position) {
        Quiz quiz = QuizBuilder.createSingleChoice(
                "Was ist die Hauptstadt von Deutschland?",
                List.of("Berlin", "München", "Hamburg", "Köln"),
                0 // Berlin is correct
        );
        quiz.explanation("Berlin ist seit 1990 die Hauptstadt des wiedervereinigten Deutschlands.");

        return createQuizChest(position, quiz, "gold_key");
    }

    /**
     * Example: Create a test quiz NPC with a multiple-choice question.
     * 
     * @param position The position to spawn
     * @return The quiz NPC entity
     */
    public static Entity createExampleQuizNPC(Point position) {
        Quiz quiz = QuizBuilder.createMultipleChoice(
                "Welche der folgenden Aussagen sind korrekt?",
                List.of(
                        "Die Erde ist flach",
                        "Wasser besteht aus H2O",
                        "Die Sonne ist ein Stern",
                        "Der Mond ist größer als die Erde"),
                List.of(1, 2) // H2O and Stern are correct
        );
        quiz.explanation("Wasser hat die chemische Formel H2O und die Sonne ist ein Stern.");

        return createQuizNPC(position, quiz, "wisdom_scroll");
    }
}
