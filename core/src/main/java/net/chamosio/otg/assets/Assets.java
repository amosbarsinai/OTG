package net.chamosio.otg.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Assets {
    public static Texture PLAYER_TEXTURE;
    public static Texture ICON_512x512;
    public static Texture PLAY_BUTTON;

    public static void initialize() {
        PLAYER_TEXTURE = new Texture(Gdx.files.internal("entity/player.png"));
        ICON_512x512 = new Texture(Gdx.files.internal("icon512x512.png"));
        PLAY_BUTTON = new Texture(Gdx.files.internal("gui/title/play.png"));
    }

    public static void dispose() {
        PLAYER_TEXTURE.dispose();
        ICON_512x512.dispose();
        PLAY_BUTTON.dispose();
    }
}
