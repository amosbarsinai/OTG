package net.chamosio.otg.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Assets {
    public static final Texture PLAYER_TEXTURE;
    public static final Texture ICON_512x512;

    static {
        PLAYER_TEXTURE = new Texture(Gdx.files.internal("entity/player.png"));
        ICON_512x512 = new Texture(Gdx.files.internal("icon512x512.png"));
    }

    public static void dispose() {
        PLAYER_TEXTURE.dispose();
    }
}
