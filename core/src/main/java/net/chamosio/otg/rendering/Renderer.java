package net.chamosio.otg.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.chamosio.otg.assets.Assets;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.core.entity.PlayerEntity;

public class Renderer {
    public GameState gameState;
    public SpriteBatch batch;
    public Renderer(GameState gameState, SpriteBatch batch) {
        this.gameState = gameState;
        this.batch = batch;
    }

    public void renderPlayer(PlayerEntity player) {
        batch.draw(
            Assets.PLAYER_TEXTURE,
            player.getHitbox().getX(),
            player.getHitbox().getY(),
            player.getHitbox().getWidth(),
            player.getHitbox().getHeight()
        );
    }

    public void render() {
        renderPlayer(gameState.player);
    }
}
