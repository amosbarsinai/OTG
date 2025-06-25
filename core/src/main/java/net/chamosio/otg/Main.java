package net.chamosio.otg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.rendering.Renderer;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    GameState gameState;
    Renderer renderer;

    private void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.B)) Gdx.app.exit();
        gameState.player.update();
    }

    private void draw() {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        renderer.render();

        batch.end();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameState = new GameState();
        renderer = new Renderer(gameState, batch);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
