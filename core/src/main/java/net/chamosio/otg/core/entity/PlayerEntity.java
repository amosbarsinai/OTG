package net.chamosio.otg.core.entity;

import net.chamosio.otg.InputHandler;
import net.chamosio.otg.core.GameState;
import net.chamosio.otg.core.map.Tile;

import static net.chamosio.otg.core.map.Map.WORLD_SIZE;

public class PlayerEntity extends AbstractEntity {
    public static final int K_UP = InputHandler.W;
    public static final int K_LEFT = InputHandler.A;
    public static final int K_DOWN = InputHandler.S;
    public static final int K_RIGHT = InputHandler.D;

    public volatile boolean isMoving;

    public PlayerEntity(GameState gameState) {
        super(gameState);
        this.speed = 9;
        this.hitbox = new Hitbox(0, 0, 100, 100);
        this.direction = Direction.DOWN;
    }

    @Override
    public void update() {
        this.isMoving = false;
        if (InputHandler.isKeyPressed(K_UP)) this.moveUp(collidesUp());
        if (InputHandler.isKeyPressed(K_LEFT)) this.moveLeft(collidesLeft());
        if (InputHandler.isKeyPressed(K_DOWN)) this.moveDown(collidesDown());
        if (InputHandler.isKeyPressed(K_RIGHT)) this.moveRight(collidesRight());

        if (InputHandler.isKeyPressed(InputHandler.H)) {
            speed = 42;
            hitbox.teleport(WORLD_SIZE * Tile.TILE_SIZE - 1, WORLD_SIZE * Tile.TILE_SIZE - 1);
        }
    }

    private void moveUp(int delta) {
        this.hitbox.moveUp(delta);
        this.direction = Direction.UP;
        this.isMoving = true;
    }
    private void moveLeft(int delta) {
        this.hitbox.moveLeft(delta);
        this.direction = Direction.LEFT;
        this.isMoving = true;
    }
    private void moveDown(int delta) {
        this.hitbox.moveDown(delta);
        this.direction = Direction.DOWN;
        this.isMoving = true;
    }
    private void moveRight(int delta) {
        this.hitbox.moveRight(delta);
        this.direction = Direction.RIGHT;
        this.isMoving = true;
    }
}
