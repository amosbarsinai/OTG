package net.chamosio.otg.rendering.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.Main;
import net.chamosio.otg.assets.Assets;
import net.chamosio.otg.gui.Button;
import net.chamosio.otg.gui.TitleScreen;

public class TitleRenderer {

    static long startFadeIn = System.currentTimeMillis();
    static long startFadeOut;
    static float alpha = 0f;
    static String fade = "in";
    static boolean finishedFadeIn = false;

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    TitleScreen titleScreen;

    public TitleRenderer(SpriteBatch batch, ShapeRenderer shapeRenderer, TitleScreen titleScreen) {
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
        this.titleScreen = titleScreen;
    }
    public static boolean getFinishedFadeOut() {
        return alpha == 0f && finishedFadeIn;
    }
    public static void startFadeOut() {
        startFadeOut = System.currentTimeMillis();
        fade = "out";
    }
    private void renderButton(Button button) {
        this.batch.draw(
            Assets.PLAY_BUTTON,
            button.x,
            button.y,
            button.width,
            button.height
        );
    }
    public void render(boolean debug, int[] mousePos) {
        long currentTime = System.currentTimeMillis();
        if (fade.equals("in")) {
            alpha = Math.min(Math.max(0, (float) (currentTime - startFadeIn - 1000) / 1000), 1);
            if (alpha == 1f) finishedFadeIn = true;
        }
        else if (fade.equals("out"))
            alpha = 1f - Math.min(Math.max(0, (float) (currentTime - startFadeOut) / 1000), 1);
        alpha = Math.max(Math.min(alpha, 1f), 0f);
        batch.setColor(1, 1, 1, alpha);
        int width = 512;
        int height = 512;
        int x = 0;
        int y = Main.SCREEN_HEIGHT - height;
        int right = x + width;
        int top = y + height;
        batch.draw(Assets.ICON_512x512, x, y, width, height);
        renderButton(this.titleScreen.playButton);
        batch.setColor(1, 1, 1, 1); // reset color
        if (debug) {
            batch.end();
            Gdx.gl.glLineWidth(5f);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(196, 196, 0, 255);

            shapeRenderer.line(x, top, right, y);
            shapeRenderer.line(right, top, x, y);

            shapeRenderer.line(0, top, Main.SCREEN_WIDTH, top);
            shapeRenderer.line(0, y, Main.SCREEN_WIDTH, y);

            shapeRenderer.line(right, 0, right, Main.SCREEN_HEIGHT);
            shapeRenderer.line(x, 0, x, Main.SCREEN_HEIGHT);

            shapeRenderer.setColor(new Color(0.7f, 0.5f, 0.3f, 1f));

            shapeRenderer.line(
                this.titleScreen.playButton.x,
                this.titleScreen.playButton.y + this.titleScreen.playButton.height,
                this.titleScreen.playButton.x + this.titleScreen.playButton.width,
                this.titleScreen.playButton.y + this.titleScreen.playButton.height
            );
            shapeRenderer.line(
                this.titleScreen.playButton.x + this.titleScreen.playButton.width,
                this.titleScreen.playButton.y,
                this.titleScreen.playButton.x,
                this.titleScreen.playButton.y
            );
            shapeRenderer.line(
                this.titleScreen.playButton.x,
                this.titleScreen.playButton.y + this.titleScreen.playButton.height,
                this.titleScreen.playButton.x,
                this.titleScreen.playButton.y
            );
            shapeRenderer.line(
                this.titleScreen.playButton.x + this.titleScreen.playButton.width,
                this.titleScreen.playButton.y + this.titleScreen.playButton.height,
                this.titleScreen.playButton.x + this.titleScreen.playButton.width,
                this.titleScreen.playButton.y
            );

            shapeRenderer.setColor(new Color(0, 0, 0, 1f));
            shapeRenderer.line(mousePos[0], mousePos[1], right, y);

            shapeRenderer.end();
            batch.begin();
        }
    }
}
