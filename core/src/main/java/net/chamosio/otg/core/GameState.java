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
}
