package net.chamosio.otg.core.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerEntity extends AbstractEntity {
    public static final int K_UP = Input.Keys.W;
    public static final int K_LEFT = Input.Keys.A;
    public static final int K_DOWN = Input.Keys.S;
    public static final int K_RIGHT = Input.Keys.D;

    public static int SPEED = 4;

    public PlayerEntity() {
        this.hitbox = new Hitbox(14, 0, 100, 128);
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(K_UP)) this.hitbox.moveUp(SPEED);
        if (Gdx.input.isKeyPressed(K_LEFT)) this.hitbox.moveLeft(SPEED);
        if (Gdx.input.isKeyPressed(K_DOWN)) this.hitbox.moveDown(SPEED);
        if (Gdx.input.isKeyPressed(K_RIGHT)) this.hitbox.moveRight(SPEED);
    }
}
