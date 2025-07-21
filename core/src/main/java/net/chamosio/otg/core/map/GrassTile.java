package net.chamosio.otg.core.map;

public class GrassTile extends Tile {
    @Override
    public String identifier() {
        return "grass_tile";
    }
    @Override
    public boolean isSolid() {
        return false;
    }
}
