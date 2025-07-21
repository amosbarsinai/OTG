package net.chamosio.otg.core.entity;

import net.chamosio.otg.core.GameState;
import net.chamosio.otg.core.map.Tile;

import static net.chamosio.otg.core.map.Tile.TILE_SIZE;

public abstract class AbstractEntity {

    public Hitbox hitbox;
    public volatile Direction direction;

    public int speed;

    public abstract void update();

    GameState gameState;

    public AbstractEntity(GameState gameState) {
        this.gameState = gameState;
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }
    public int getX() {
        return this.hitbox.getX();
    }
    public int getY() {
        return this.hitbox.getY();
    }
    public int getTop() {
        return getY() + getHeight();
    }
    public int getRight() {
        return getX() + getWidth();
    }
    public int getWidth() {
        return this.hitbox.getWidth();
    }
    public int getHeight() {
        return this.hitbox.getHeight();
    }

    public int collidesUp() {
        Tile tile1 = gameState.map.getTileAt(getX(), getTop());
        Tile tile2 = gameState.map.getTileAt(getRight(), getTop());

        if (tile1.isSolid() || tile2.isSolid()) {
            return 0;
        }

        int nextTop = getTop() + speed;
        Tile nextTile1 = gameState.map.getTileAt(getX(), nextTop);
        Tile nextTile2 = gameState.map.getTileAt(getRight(), nextTop);

        if (nextTile1.isSolid() || nextTile2.isSolid()) {
            return Math.min(speed, TILE_SIZE - (getTop() % TILE_SIZE) - 1);
        }

        return speed;
    }

    public int collidesLeft() {
        Tile tile1 = gameState.map.getTileAt(getX(), getTop());
        Tile tile2 = gameState.map.getTileAt(getX(), getY());

        if (tile1.isSolid() || tile2.isSolid()) {
            return 0;
        }

        int nextLeft = getX() - speed;
        Tile nextTile1 = gameState.map.getTileAt(nextLeft, getY());
        Tile nextTile2 = gameState.map.getTileAt(nextLeft, getTop());

        if (nextTile1.isSolid() || nextTile2.isSolid()) {
            return Math.min(speed, (getX() % TILE_SIZE) - 1);
        }

        return speed;
    }

    public int collidesDown() {
        Tile tile1 = gameState.map.getTileAt(getRight(), getY());
        Tile tile2 = gameState.map.getTileAt(getX(), getY());

        if (tile1.isSolid() || tile2.isSolid()) {
            return 0;
        }

        int nextDown = getY() - speed;
        Tile nextTile1 = gameState.map.getTileAt(getX(), nextDown);
        Tile nextTile2 = gameState.map.getTileAt(getRight(), nextDown);

        if (nextTile1.isSolid() || nextTile2.isSolid()) {
            return Math.min(speed, (getY() % TILE_SIZE) - 1);
        }

        return speed;
    }

    public int collidesRight() {
        Tile tile1 = gameState.map.getTileAt(getRight(), getY());
        Tile tile2 = gameState.map.getTileAt(getRight(), getTop());

        if (tile1.isSolid() || tile2.isSolid()) {
            return 0;
        }

        int nextRight = getRight() + speed;
        Tile nextTile1 = gameState.map.getTileAt(nextRight, getY());
        Tile nextTile2 = gameState.map.getTileAt(nextRight, getTop());

        if (nextTile1.isSolid() || nextTile2.isSolid()) {
            return Math.min(speed, TILE_SIZE - (getRight() % TILE_SIZE) - 1);
        }

        return speed;
    }
}
