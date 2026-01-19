package dsl;

import java.util.logging.Logger;

/**
 * Handles difficulty scaling for escape rooms. Modifies monster stats and player stats based on
 * difficulty setting.
 */
public class DifficultyModifier {

  private static final Logger LOGGER = Logger.getLogger(DifficultyModifier.class.getSimpleName());

  public enum Difficulty {
    EASY(0.7f, 1.3f), // Monsters 70% power, Player 130% power
    NORMAL(1.0f, 1.0f), // Standard balance
    HARD(1.5f, 0.8f), // Monsters 150% power, Player 80% power
    EXTREME(2.0f, 0.6f); // Monsters 200% power, Player 60% power

    public final float monsterMultiplier;
    public final float playerMultiplier;

    Difficulty(float monsterMultiplier, float playerMultiplier) {
      this.monsterMultiplier = monsterMultiplier;
      this.playerMultiplier = playerMultiplier;
    }

    /** Parse difficulty string to enum, case-insensitive. Returns NORMAL if string is invalid. */
    public static Difficulty fromString(String difficultyStr) {
      if (difficultyStr == null || difficultyStr.isEmpty()) {
        return NORMAL;
      }

      try {
        return Difficulty.valueOf(difficultyStr.toUpperCase());
      } catch (IllegalArgumentException e) {
        LOGGER.warning("Unknown difficulty '" + difficultyStr + "', defaulting to NORMAL");
        return NORMAL;
      }
    }
  }

  private final Difficulty difficulty;

  public DifficultyModifier(String difficultyStr) {
    this.difficulty = Difficulty.fromString(difficultyStr);
    LOGGER.info(
        "Difficulty set to: "
            + difficulty
            + " (monsters: "
            + (difficulty.monsterMultiplier * 100)
            + "%, player: "
            + (difficulty.playerMultiplier * 100)
            + "%)");
  }

  /** Apply difficulty scaling to monster health. */
  public int scaleMonsterHealth(int baseHealth) {
    return Math.round(baseHealth * difficulty.monsterMultiplier);
  }

  /** Apply difficulty scaling to monster damage. */
  public int scaleMonsterDamage(int baseDamage) {
    return Math.round(baseDamage * difficulty.monsterMultiplier);
  }

  /** Apply difficulty scaling to player health. */
  public int scalePlayerHealth(int baseHealth) {
    return Math.round(baseHealth * difficulty.playerMultiplier);
  }

  /** Apply difficulty scaling to player mana. */
  public int scalePlayerMana(int baseMana) {
    return Math.round(baseMana * difficulty.playerMultiplier);
  }

  /** Apply difficulty scaling to player stamina. */
  public int scalePlayerStamina(int baseStamina) {
    return Math.round(baseStamina * difficulty.playerMultiplier);
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }
}
