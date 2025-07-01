package net.chamosio.otg.gui;

public abstract class Button {
    public abstract void onClick();
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean isIn(int x, int y) {
        return x >= this.x && x <= this.x + this.width &&
            y >= this.y && y <= this.y + this.height;
    }
}
