package net.chamosio.otg.core.map;

import net.chamosio.otg.worldgen.WorldGenerator;

import static net.chamosio.otg.core.map.Tile.TILE_SIZE;
import static net.chamosio.otg.core.map.Tiles.UNKNOWN_TILE;

public class Map {
    public Tile[][] tiles = new Tile[WORLD_SIZE][WORLD_SIZE];
    public static final int WORLD_SIZE = 256;
    public static Map newMap() {
        return new WorldGenerator().generate();
    }
    public Tile getTileAt(int x, int y) {
        if (isOutOfBounds(x, y)) return UNKNOWN_TILE;
        return this.tiles[y / TILE_SIZE][x / TILE_SIZE];
    }
    private boolean isOutOfBounds(int x, int y) {
        if (x < -TILE_SIZE) return true;
        if (x > WORLD_SIZE * TILE_SIZE) return true;
        if (y < -TILE_SIZE) return true;
        if (y > WORLD_SIZE * TILE_SIZE) return true;
        return false;
    }
}
