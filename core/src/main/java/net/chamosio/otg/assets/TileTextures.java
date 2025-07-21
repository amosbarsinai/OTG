package net.chamosio.otg.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TileTextures { public static void init() {}
    public final static Texture GRASS_TILE;
    public final static Texture BRICK_WALL;
    public final static Texture UNKNOWN_TILE;
    static {
        GRASS_TILE = new Texture(Gdx.files.internal("textures/tile/grass_tile.png"));
        BRICK_WALL = new Texture(Gdx.files.internal("textures/tile/brick_wall.png"));
        UNKNOWN_TILE = new Texture(Gdx.files.internal("textures/tile/unknown_tile.png"));
    }

    public static Texture getTileTexture(String identifier) {
        return switch (identifier) {
            case "grass_tile" -> GRASS_TILE;
            case "brick_wall" -> BRICK_WALL;

            default -> UNKNOWN_TILE;
        };
    }

    public static void dispose() {
        GRASS_TILE.dispose();
        BRICK_WALL.dispose();
        UNKNOWN_TILE.dispose();
    }
}
