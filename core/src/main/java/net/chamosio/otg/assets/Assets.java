package net.chamosio.otg.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Assets {
    public static Texture ICON_512x512;
    public static Texture PLAY_BUTTON;

    public static Texture[] PLAYER_UP;
    public static Texture[] PLAYER_LEFT;
    public static Texture[] PLAYER_DOWN;
    public static Texture[] PLAYER_RIGHT;

    public static void initialize() {
        PlayerOffsetHandler.init();
        TileTextures.init();

        ICON_512x512 = new Texture(Gdx.files.internal("textures/icon512x512.png"));
        PLAY_BUTTON = new Texture(Gdx.files.internal("textures/gui/title/play.png"));

        PLAYER_UP = new Texture[] {
            new Texture(Gdx.files.internal("textures/entity/player/player_up1.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_up2.png")),
        };
        PLAYER_LEFT = new Texture[] {
            new Texture(Gdx.files.internal("textures/entity/player/player_left1.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_left2.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_left3.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_left4.png")),
        };
        PLAYER_DOWN = new Texture[] {
            new Texture(Gdx.files.internal("textures/entity/player/player_down1.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_down2.png")),
        };
        PLAYER_RIGHT = new Texture[] {
            new Texture(Gdx.files.internal("textures/entity/player/player_right1.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_right2.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_right3.png")),
            new Texture(Gdx.files.internal("textures/entity/player/player_right4.png")),
        };
    }

    public static void dispose() {
        for (Texture texture : PLAYER_UP) texture.dispose();
        for (Texture texture : PLAYER_LEFT) texture.dispose();
        for (Texture texture : PLAYER_DOWN) texture.dispose();
        for (Texture texture : PLAYER_RIGHT) texture.dispose();
        ICON_512x512.dispose();
        PLAY_BUTTON.dispose();
    }
}
