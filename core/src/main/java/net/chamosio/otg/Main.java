package net.chamosio.otg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.assets.Assets;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.gui.TitleScreen;
import net.chamosio.otg.rendering.Renderer;
import net.chamosio.otg.rendering.title.TitleRenderer;

public class Main extends ApplicationAdapter implements InputProcessor {
    public static final int SCREEN_WIDTH  = 1024;
    public static final int SCREEN_HEIGHT = 1024;

    SpriteBatch batch;
    GameState gameState;
    Renderer renderer;
    ShapeRenderer shapeRenderer;
    TitleScreen titleScreen;

    public static GameFlowMode gameFlowMode = GameFlowMode.TITLE_SCREEN;

    volatile boolean debug;

    volatile int[] mousePos = {0, 0};

    private static final float TICK_RATE = 1f / 32f; // 32 ticks per second
    private float accumulator = 0f;

    private void update() {
        debug = Gdx.input.isKeyPressed(Input.Keys.T);
        if (gameFlowMode == GameFlowMode.PLAYING) gameState.player.update();
    }
    public static void startGame() {
        TitleRenderer.startFadeOut();
    }

    private void draw(boolean debug) {
        Gdx.gl.glClearColor(0.157f, 0.176f, 0.188f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        switch (gameFlowMode) {
            case TITLE_SCREEN ->
                {
                    renderer.renderTitle(debug, mousePos);
                    if (TitleRenderer.getFinishedFadeOut()) {
                        gameFlowMode = GameFlowMode.PLAYING;
                    }
                }
            case PLAYING -> renderer.renderGame(debug);
        }

        batch.end();
    }

    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);

        Assets.initialize(); // lazy initialization should happen before anything handling textures gets invoked

        this.titleScreen = new TitleScreen();

        batch = new SpriteBatch();
        gameState = new GameState();
        shapeRenderer = new ShapeRenderer();
        renderer = new Renderer(titleScreen, gameState, batch, shapeRenderer);

        batch.enableBlending();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void render() {
        accumulator += Gdx.graphics.getDeltaTime();
        while (accumulator >= TICK_RATE) {
            update();
            accumulator -= TICK_RATE;
        }
        draw(debug);
    }

    @Override
    public void dispose() {
        batch.dispose();
        Assets.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.B) Gdx.app.exit();
        InputHandler.handleKeyPressed(InputHandler.gdxToLocal(keycode));
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        InputHandler.handleKeyReleased(InputHandler.gdxToLocal(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (gameFlowMode == GameFlowMode.TITLE_SCREEN) {
            this.titleScreen.handleClickEvent(screenX, SCREEN_HEIGHT - screenY);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mousePos = new int[] {screenX, SCREEN_HEIGHT - screenY};
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
