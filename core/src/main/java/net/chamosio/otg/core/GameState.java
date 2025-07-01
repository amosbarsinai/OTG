package net.chamosio.otg.core;

import net.chamosio.otg.core.entity.AbstractEntity;
import net.chamosio.otg.core.entity.PlayerEntity;

import java.util.ArrayList;

public class GameState {
    public ArrayList<AbstractEntity> entities;
    public PlayerEntity player;
    public GameState() {
        player = new PlayerEntity();
    }
    public void handleKeyEvent(int key) {
        switch (key) {
            case PlayerEntity.K_UP    ->    player.moveUp();
            case PlayerEntity.K_LEFT  ->  player.moveLeft();
            case PlayerEntity.K_DOWN  ->  player.moveDown();
            case PlayerEntity.K_RIGHT -> player.moveRight();
        }
    }
}
