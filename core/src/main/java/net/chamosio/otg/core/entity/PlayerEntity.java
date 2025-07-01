package net.chamosio.otg.core.entity;

import net.chamosio.otg.InputHandler;

public class PlayerEntity extends AbstractEntity {
    public static final int K_UP = InputHandler.W;
    public static final int K_LEFT = InputHandler.A;
    public static final int K_DOWN = InputHandler.S;
    public static final int K_RIGHT = InputHandler.D;

    public static int SPEED = 8;

    public PlayerEntity() {
        this.hitbox = new Hitbox(14, 0, 100, 128);
    }

    @Override
    public void update() {
        if (InputHandler.isKeyPressed(K_UP)) this.hitbox.moveUp(SPEED);
        if (InputHandler.isKeyPressed(K_LEFT)) this.hitbox.moveLeft(SPEED);
        if (InputHandler.isKeyPressed(K_DOWN)) this.hitbox.moveDown(SPEED);
        if (InputHandler.isKeyPressed(K_RIGHT)) this.hitbox.moveRight(SPEED);
    }

    public void moveUp() {this.hitbox.moveUp(SPEED);}
    public void moveLeft() {this.hitbox.moveLeft(SPEED);}
    public void moveDown() {this.hitbox.moveDown(SPEED);}
    public void moveRight() {this.hitbox.moveRight(SPEED);}
}
