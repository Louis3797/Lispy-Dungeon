package dsl.utils;

import core.utils.components.draw.animation.Animation;
import core.utils.components.path.SimpleIPath;
import core.utils.logging.CustomLogLevel;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Factory utility for loading animations and textures with fallback handling.
 * 
 * <p>
 * Provides methods for:
 * - Loading animation spritesheets with error handling
 * - Creating single-frame animations
 * - Fallback to default textures on failure
 */
public final class AnimationFactory {

    private static final Logger LOGGER = Logger.getLogger(AnimationFactory.class.getSimpleName());

    // Default fallback textures
    private static final String DEFAULT_FALLBACK_TEXTURE = "character/wizard/idle_left.png";
    private static final String DEFAULT_ITEM_TEXTURE = "items/resource/berry";
    private static final String DEFAULT_NPC_TEXTURE = "character/monster/orc_warrior";

    // Private constructor to prevent instantiation
    private AnimationFactory() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Loads an animation spritesheet with fallback handling.
     * 
     * @param texturePath The path to the texture to load
     * @return Map of animation name to Animation, or empty map on failure
     * @throws NullPointerException if texturePath is null
     */
    public static Map<String, Animation> loadSpritesheet(String texturePath) {
        Objects.requireNonNull(texturePath, "texturePath cannot be null");

        try {
            return Animation.loadAnimationSpritesheet(new SimpleIPath(texturePath));
        } catch (Exception e) {
            LOGGER.warning("Failed to load spritesheet: " + texturePath);
            LOGGER.log(CustomLogLevel.DEBUG, "Spritesheet load error details", e);
            return Map.of();
        }
    }

    /**
     * Loads an animation spritesheet with a custom fallback.
     * 
     * @param texturePath  The path to the texture to load
     * @param fallbackPath The fallback texture path if loading fails
     * @return Map of animation name to Animation
     * @throws NullPointerException if texturePath or fallbackPath is null
     */
    public static Map<String, Animation> loadSpritesheetWithFallback(String texturePath, String fallbackPath) {
        Objects.requireNonNull(texturePath, "texturePath cannot be null");
        Objects.requireNonNull(fallbackPath, "fallbackPath cannot be null");

        Map<String, Animation> animations = loadSpritesheet(texturePath);

        if (animations.isEmpty()) {
            LOGGER.info("Using fallback texture: " + fallbackPath);
            animations = loadSpritesheet(fallbackPath);
        }

        return animations;
    }

    /**
     * Creates a single-frame animation from a texture path.
     * 
     * @param texturePath The path to the texture
     * @return The created animation
     * @throws NullPointerException if texturePath is null
     */
    public static Animation createSingleFrameAnimation(String texturePath) {
        Objects.requireNonNull(texturePath, "texturePath cannot be null");

        try {
            return new Animation(new SimpleIPath(texturePath));
        } catch (Exception e) {
            LOGGER.warning("Failed to create animation from: " + texturePath);
            LOGGER.log(CustomLogLevel.DEBUG, "Animation creation error details", e);

            // Try fallback
            try {
                return new Animation(new SimpleIPath(DEFAULT_FALLBACK_TEXTURE));
            } catch (Exception fallbackEx) {
                LOGGER.log(CustomLogLevel.ERROR, "Failed to load fallback texture", fallbackEx);
                throw new RuntimeException("Could not load texture or fallback: " + texturePath, e);
            }
        }
    }

    /**
     * Creates a single-frame animation with a custom fallback texture.
     * 
     * @param texturePath  The path to the texture
     * @param fallbackPath The fallback texture path if loading fails
     * @return The created animation
     * @throws NullPointerException if texturePath or fallbackPath is null
     */
    public static Animation createSingleFrameAnimationWithFallback(String texturePath, String fallbackPath) {
        Objects.requireNonNull(texturePath, "texturePath cannot be null");
        Objects.requireNonNull(fallbackPath, "fallbackPath cannot be null");

        try {
            return new Animation(new SimpleIPath(texturePath));
        } catch (Exception e) {
            LOGGER.warning("Failed to create animation from: " + texturePath + ", using fallback");
            LOGGER.log(CustomLogLevel.DEBUG, "Animation creation error details", e);

            try {
                return new Animation(new SimpleIPath(fallbackPath));
            } catch (Exception fallbackEx) {
                LOGGER.log(CustomLogLevel.ERROR, "Failed to load fallback texture", fallbackEx);
                throw new RuntimeException("Could not load texture or fallback: " + texturePath, e);
            }
        }
    }

    /**
     * Loads a spritesheet specifically for items with appropriate fallback.
     * 
     * @param texturePath The path to the item texture
     * @return Map of animation name to Animation
     * @throws NullPointerException if texturePath is null
     */
    public static Map<String, Animation> loadItemSpritesheet(String texturePath) {
        return loadSpritesheetWithFallback(texturePath, DEFAULT_ITEM_TEXTURE);
    }

    /**
     * Loads a spritesheet specifically for NPCs with appropriate fallback.
     * 
     * @param texturePath The path to the NPC texture
     * @return Map of animation name to Animation
     * @throws NullPointerException if texturePath is null
     */
    public static Map<String, Animation> loadNPCSpritesheet(String texturePath) {
        return loadSpritesheetWithFallback(texturePath, DEFAULT_NPC_TEXTURE);
    }

    /**
     * Gets the default idle animation from a loaded spritesheet.
     * Tries "idle_down", then "idle", then the first available animation.
     * 
     * @param animationMap The map of animations
     * @return The default idle animation, or null if map is empty
     * @throws NullPointerException if animationMap is null
     */
    public static Animation getDefaultIdleAnimation(Map<String, Animation> animationMap) {
        Objects.requireNonNull(animationMap, "animationMap cannot be null");

        if (animationMap.isEmpty()) {
            return null;
        }

        // Try common idle animation names in order of preference
        Animation idle = animationMap.get("idle_down");
        if (idle != null) {
            return idle;
        }

        idle = animationMap.get("idle");
        if (idle != null) {
            return idle;
        }

        // Fallback to first available animation
        return animationMap.values().iterator().next();
    }
}
