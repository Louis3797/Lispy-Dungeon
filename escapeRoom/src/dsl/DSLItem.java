package dsl;

import contrib.item.Item;
import core.Entity;
import core.utils.components.draw.animation.Animation;
import dsl.runtime.DSLRuntime;
import dsl.runtime.ast.EventType;

/**
 * A custom Item implementation that hooks into the DSL runtime. This allows items to trigger DSL
 * events (ON_USE) when used.
 */
public class DSLItem extends Item {
  private final String itemId;
  private final DSLRuntime runtime;

  public DSLItem(
      String itemId,
      String displayName,
      String description,
      Animation inventoryAnimation,
      Animation worldAnimation,
      DSLRuntime runtime) {
    super(displayName, description, inventoryAnimation, worldAnimation);
    this.itemId = itemId;
    this.runtime = runtime;
  }

  @Override
  public void use(Entity user) {
    // 1. Default behavior: Remove from inventory
    super.use(user);

    // 2. Fire DSL event
    if (runtime != null) {
      runtime.fireEvent(EventType.ON_USE, itemId);
    }
  }
}
