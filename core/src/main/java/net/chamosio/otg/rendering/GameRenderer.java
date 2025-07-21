package net.chamosio.otg.rendering;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import net.chamosio.otg.Main;
import net.chamosio.otg.assets.Assets;
import net.chamosio.otg.assets.PlayerOffsetHandler;
import net.chamosio.otg.assets.TileTextures;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.core.entity.PlayerEntity;
import net.chamosio.otg.core.map.Tile;

import static net.chamosio.otg.core.map.Map.WORLD_SIZE;
import static net.chamosio.otg.core.map.Tile.TILE_SIZE;

public class GameRenderer {
    public GameState gameState;
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    OrthographicCamera camera = new OrthographicCamera();

    int cameraX = 128;
    int cameraY = 128;


    private int animationFrame = 0;
    private long lastFrameUpdate = 0;

    BitmapFont font;

    public GameRenderer(GameState gameState, SpriteBatch batch, ShapeRenderer renderer, BitmapFont font) {
        this.gameState = gameState;
        this.batch = batch;
        this.font = font;
        this.shapeRenderer = renderer;
        camera.setToOrtho(false, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    }

    public void renderMap() {
        Tile[][] tiles = this.gameState.map.tiles;

        int minCol = (int)(camera.position.x - camera.viewportWidth / 2) / TILE_SIZE;
        int maxCol = (int)(camera.position.x + camera.viewportWidth / 2) / TILE_SIZE;
        int minRow = (int)(camera.position.y - camera.viewportHeight / 2) / TILE_SIZE;
        int maxRow = (int)(camera.position.y + camera.viewportHeight / 2) / TILE_SIZE;

        minCol = Math.max(minCol, 0);
        maxCol = Math.min(maxCol, tiles[0].length - 1);
        minRow = Math.max(minRow, 0);
        maxRow = Math.min(maxRow, tiles.length - 1);

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                Texture tileTexture = TileTextures.getTileTexture(tiles[i][j].identifier());
                batch.draw(tileTexture, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }


    public void renderPlayer() {
        batch.setColor(1, 1, 1, 1);
        long currentTime = System.nanoTime();

        PlayerEntity player = gameState.player;

        if (player.isMoving) {
            // Only update every 200ms
            if (currentTime - lastFrameUpdate > 200_000_000) {
                animationFrame++;
                lastFrameUpdate = currentTime;
            }
        }

        Texture playerTexture = switch (player.direction) {
            case UP -> Assets.PLAYER_UP[animationFrame % 2];
            case LEFT -> Assets.PLAYER_LEFT[animationFrame % 4];
            case DOWN -> Assets.PLAYER_DOWN[animationFrame % 2];
            case RIGHT -> Assets.PLAYER_RIGHT[animationFrame % 4];
        };

        batch.draw(
            playerTexture,
            player.getX() + PlayerOffsetHandler.PLAYER_OFFSET_X,
            player.getY() + PlayerOffsetHandler.PLAYER_OFFSET_Y,
            player.getWidth() + PlayerOffsetHandler.PLAYER_OFFSET_WIDTH,
            player.getHeight() + PlayerOffsetHandler.PLAYER_OFFSET_HEIGHT
        );
    }

    public void render(boolean debug) {
        PlayerEntity player = gameState.player;

        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        renderMap();
        renderPlayer();
        batch.end();
        if (debug) {
            shapeRenderer.setProjectionMatrix(camera.combined);

            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            // render map tile borders
            shapeRenderer.setColor(Color.YELLOW);

            Tile[][] tiles = gameState.map.tiles;

            int minCol = (int)(camera.position.x - camera.viewportWidth / 2) / TILE_SIZE;
            int maxCol = (int)(camera.position.x + camera.viewportWidth / 2) / TILE_SIZE;
            int minRow = (int)(camera.position.y - camera.viewportHeight / 2) / TILE_SIZE;
            int maxRow = (int)(camera.position.y + camera.viewportHeight / 2) / TILE_SIZE;

            minCol = Math.max(minCol, 0);
            maxCol = Math.min(maxCol, tiles[0].length - 1);
            minRow = Math.max(minRow, 0);
            maxRow = Math.min(maxRow, tiles.length - 1);

            for (int col = minCol; col <= maxCol + 1; col++) {
                float x = col * TILE_SIZE;
                shapeRenderer.line(x, minRow * TILE_SIZE, x, (maxRow + 1) * TILE_SIZE);
            }

            for (int row = minRow; row <= maxRow + 1; row++) {
                float y = row * TILE_SIZE;
                shapeRenderer.line(minCol * TILE_SIZE, y, (maxCol + 1) * TILE_SIZE, y);
            }

            // render player hitbox
            shapeRenderer.setColor(Color.BLACK);

            shapeRenderer.line(
                player.getX(),
                player.getY(),
                player.getX() + player.getWidth(),
                player.getY()
            );
            shapeRenderer.line(
                player.getX(),
                player.getY() + player.getHeight(),
                player.getX() + player.getWidth(),
                player.getY() + player.getHeight()
            );
            shapeRenderer.line(
                player.getX(),
                player.getY(),
                player.getX(),
                player.getY() + player.getHeight()
            );
            shapeRenderer.line(
                player.getX() + player.getWidth(),
                player.getY(),
                player.getX() + player.getWidth(),
                player.getY() + player.getHeight()
            );

            shapeRenderer.end();

            batch.setProjectionMatrix(new Matrix4().setToOrtho2D(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT));
            batch.begin();
            font.draw(
                batch,
                "Player X: " + player.getX() + ", Y: " + player.getY()  +
                    ", Top: " + player.getTop() + ", Right: " + player.getRight(),
                10,
                Main.SCREEN_HEIGHT - 10
            );
            batch.end();
        }
    }
}
