package dsl;

/**
 * Represents the player configuration in the escape room DSL.
 */
public class Player {
    public String playerClass; // "wizard" or "hunter"
    public Integer startX;
    public Integer startY;
    public Integer health;
    public Integer mana;
    public Integer stamina;
    public Float speed;
    public Float manaRestore;
    public Float staminaRestore;

    @Override
    public String toString() {
        return "Player{" +
                "class='" + playerClass + '\'' +
                ", startPos=(" + startX + "," + startY + ")" +
                ", health=" + health +
                ", mana=" + mana +
                ", stamina=" + stamina +
                ", speed=" + speed +
                ", manaRestore=" + manaRestore +
                ", staminaRestore=" + staminaRestore +
                '}';
    }
}
