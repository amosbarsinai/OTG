package net.chamosio.otg.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Assets {
    public static final Texture PLAYER_TEXTURE;

    static {
        PLAYER_TEXTURE = new Texture(Gdx.files.internal("entity/player.png"));
    }

    public static void dispose() {
        PLAYER_TEXTURE.dispose();
    }
}
