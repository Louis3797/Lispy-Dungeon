package dsl;

import contrib.item.Item;

import dsl.utils.AnimationFactory;

/**
 * A key item for the escape room that can be used to unlock doors.
 */
public class EscapeRoomKey extends Item {

    private final String keyId;

    /**
     * Creates a new escape room key.
     *
     * @param keyId       The unique identifier for this key (e.g., "golden_key")
     * @param displayName The name shown in inventory
     * @param description The description of the key
     * @param texturePath The texture path for the key
     */
    public EscapeRoomKey(String keyId, String displayName, String description, String texturePath) {
        super(
                displayName != null ? displayName : "Key",
                description != null ? description : "A key that unlocks something.",
                AnimationFactory.createSingleFrameAnimationWithFallback(
                        texturePath != null ? texturePath : "items/key/small_key.png",
                        "items/key/small_key.png"));
        this.keyId = keyId;
    }

    /**
     * Gets the unique identifier for this key.
     *
     * @return The key ID
     */
    public String getKeyId() {
        return keyId;
    }
}
