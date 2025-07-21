package net.chamosio.otg.worldgen;

import net.chamosio.otg.core.map.Map;
import net.chamosio.otg.core.map.Tile;
import net.chamosio.otg.core.map.Tiles;

import java.util.Arrays;
import java.util.Random;

public class WorldGenerator {
    private static final int WALLS_TO_GENERATE = 60;
    public Map generate() {
        Map map = new Map();
        for (Tile[] tile : map.tiles) {
            Arrays.fill(tile, Tiles.GRASS_TILE);
        }
        Random random = new Random();
        for (int i = 0; i < WALLS_TO_GENERATE; i++) {
            int[] current_wall = new int[] {
                random.nextInt(1, Map.WORLD_SIZE),
                random.nextInt(1, Map.WORLD_SIZE)
            };
            int direction = random.nextInt(4);
            while (
                current_wall[0] >= 0 && current_wall[0] < Map.WORLD_SIZE &&
                current_wall[1] >= 0 && current_wall[1] < Map.WORLD_SIZE
            ) {
                map.tiles[current_wall[0]][current_wall[1]] = Tiles.BRICK_WALL_TILE;
                switch (direction) {
                    case 0 -> current_wall[0] += 1;
                    case 1 -> current_wall[1] += 1;
                    case 2 -> current_wall[0] -= 1;
                    case 3 -> current_wall[1] -= 1;
                }
            }
        }
        map.tiles[0][0] = Tiles.GRASS_TILE;
        return map;
    }
}
