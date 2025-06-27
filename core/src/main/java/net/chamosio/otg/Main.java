package net.chamosio.otg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.rendering.Renderer;

enum GameMode {
    TITLE_SCREEN
}

public class Main extends ApplicationAdapter {
    public static final int SCREEN_WIDTH  = 1024;
    public static final int SCREEN_HEIGHT = 1024;

    SpriteBatch batch;
    GameState gameState;
    Renderer renderer;
    ShapeRenderer shapeRenderer;

    GameMode gameMode = GameMode.TITLE_SCREEN;

    volatile boolean debug;

    private void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.B)) Gdx.app.exit();
        debug = Gdx.input.isKeyPressed(Input.Keys.T);
        gameState.player.update();
    }

    private void draw(boolean debug) {
        Gdx.gl.glClearColor(0.157f, 0.176f, 0.188f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        if (gameMode == GameMode.TITLE_SCREEN) {
            renderer.renderTitle(debug);
        }

        batch.end();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameState = new GameState();
        shapeRenderer = new ShapeRenderer();
        renderer = new Renderer(gameState, batch, shapeRenderer);

        batch.enableBlending();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);
        draw(debug);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
