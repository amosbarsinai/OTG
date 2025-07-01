package net.chamosio.otg.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.gui.TitleScreen;
import net.chamosio.otg.rendering.title.TitleRenderer;

public class Renderer {
    GameRenderer gameRenderer;
    TitleRenderer titleRenderer;

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    public Renderer(TitleScreen titleScreen, GameState gameState, SpriteBatch batch, ShapeRenderer shapeRenderer) {
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
        this.gameRenderer = new GameRenderer(gameState, batch, shapeRenderer);
        this.titleRenderer = new TitleRenderer(batch, shapeRenderer, titleScreen);
    }

    public void renderGame(boolean debug) {
        gameRenderer.render(debug);
    }
    public void renderTitle(boolean debug, int[] mousePos) {
        titleRenderer.render(debug, mousePos);
    }
}
