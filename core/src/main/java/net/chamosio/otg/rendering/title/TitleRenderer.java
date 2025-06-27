package net.chamosio.otg.rendering.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.Main;
import net.chamosio.otg.assets.Assets;

public class TitleRenderer {

    static long start_fade_in = System.currentTimeMillis();

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    public TitleRenderer(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
    }
    public void render(boolean debug) {
        long currentTime = System.currentTimeMillis();
        float alpha = Math.max(Math.min((float) (currentTime - start_fade_in - 1000) / 1000f, 1f), 0);
        batch.setColor(1, 1, 1, alpha);
        int x = 0;
        int y = Main.SCREEN_HEIGHT - 512;
        int width = 512;
        int height = 512;
        int right = x + width;
        int top = y + 512;
        batch.draw(Assets.ICON_512x512, x, y, width, height);
        batch.setColor(1, 1, 1, 1); // reset color
        if (debug) {
            batch.end();
            Gdx.gl.glLineWidth(5f);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(196, 196, 0, 255);
            shapeRenderer.line(x, top, right, y);
            shapeRenderer.line(right, Main.SCREEN_HEIGHT, x, Main.SCREEN_HEIGHT - 512);
            shapeRenderer.line(x, top, Main.SCREEN_WIDTH, top);
            shapeRenderer.line(x, y, Main.SCREEN_WIDTH, y);
            shapeRenderer.line(x, top, x, 0);
            shapeRenderer.line(right, top, right, 0);
            shapeRenderer.end();
            batch.begin();
        }
    }
}
