package systems;

import core.System;
import dsl.runtime.DSLRuntime;
import java.util.logging.Logger;

/**
 * System that periodically checks all global triggers.
 *
 * <p>
 * Triggers are event conditions that fire when their condition becomes true,
 * such as: when
 * (keysCollected >= 3) { unlock("boss_room") }
 *
 * <p>
 * This system runs every frame and calls {@link DSLRuntime#checkTriggers()} to
 * evaluate all
 * registered triggers and execute any whose conditions are met.
 */
public class TriggerCheckSystem extends System {

    private static final Logger LOGGER = Logger.getLogger(TriggerCheckSystem.class.getSimpleName());

    private final DSLRuntime runtime;

    /**
     * Create a new trigger check system.
     *
     * @param runtime The DSL runtime to check triggers on
     */
    public TriggerCheckSystem(DSLRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public void execute() {
        if (runtime != null) {
            runtime.checkTriggers();
        }
    }
}
