package net.chamosio.otg.core.map;

public class BrickWallTile extends Tile {
    @Override
    public String identifier() {
        return "brick_wall";
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
