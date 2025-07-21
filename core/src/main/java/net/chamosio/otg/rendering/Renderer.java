package net.chamosio.otg.rendering;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.core.GameState;

public class Renderer {
    GameRenderer gameRenderer;

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    public Renderer(GameState gameState, SpriteBatch batch, ShapeRenderer shapeRenderer, BitmapFont font) {
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
        this.gameRenderer = new GameRenderer(gameState, batch, shapeRenderer, font);
    }

    public void renderGame(boolean debug) {
        gameRenderer.render(debug);
    }
}
