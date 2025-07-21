package net.chamosio.otg.core.map;

public class UnknownTile extends Tile {
    @Override
    public String identifier() {
        return "dummy_tile";
    }
    @Override
    public boolean isSolid() {
        return false;
    }
}
