package net.chamosio.otg.core.map;

public abstract class Tile {
    public abstract String identifier();
    public static final int TILE_SIZE = 128;

    public abstract boolean isSolid();
}
