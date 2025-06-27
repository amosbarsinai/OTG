package net.chamosio.otg.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.chamosio.otg.assets.Assets;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.core.entity.Hitbox;
import net.chamosio.otg.core.entity.PlayerEntity;

public class GameRenderer {
    public GameState gameState;
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    public GameRenderer(GameState gameState, SpriteBatch batch, ShapeRenderer renderer) {
        this.gameState = gameState;
        this.batch = batch;
        this.shapeRenderer = renderer;
    }

    public void renderPlayer(PlayerEntity player, boolean debug) {
        batch.draw(
            Assets.PLAYER_TEXTURE,
            player.getHitbox().getX() - 14,
            player.getHitbox().getY(),
            player.getHitbox().getWidth() + 28,
            player.getHitbox().getHeight()
        );
        if (debug) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            Hitbox playerHitbox = player.getHitbox();
            shapeRenderer.rect(
                playerHitbox.getX(),
                playerHitbox.getY(),
                playerHitbox.getWidth(),
                playerHitbox.getHeight()
            );
            shapeRenderer.end();
        }
    }

    public void render(boolean debug) {
        renderPlayer(gameState.player, debug);
    }
}
