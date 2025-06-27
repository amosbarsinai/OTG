package net.chamosio.otg.rendering.title;

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
        if (currentTime - 2000 > start_fade_in) {
            batch.draw(
                Assets.ICON_512x512,
                0,
                Main.SCREEN_HEIGHT - 512,
                512,
                512
            );
        }
        else if (currentTime - 1000 > start_fade_in) {
            float alpha = Math.min((float)(currentTime - start_fade_in - 1000) / 1000f, 1f);
            batch.setColor(1, 1, 1, alpha);
            batch.draw(
                Assets.ICON_512x512,
                0,
                Main.SCREEN_HEIGHT - 512,
                512,
                512
            );
            batch.setColor(1, 1, 1, 1); // reset color
        }
    }
}
