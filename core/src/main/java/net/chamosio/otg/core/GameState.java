package net.chamosio.otg.core;

import net.chamosio.otg.core.entity.PlayerEntity;
import net.chamosio.otg.core.map.Map;

public class GameState {
    public Map map;
    public PlayerEntity player;
    public GameState() {
        map = Map.newMap();
        player = new PlayerEntity(this);
    }
}
