package net.chamosio.otg.core.entity;

public final class Hitbox {
    private int x;
    private int y;
    private int width;
    private int height;
    public Hitbox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void x(int x) {
        this.x = x;
    }
    public void y(int y) {
        this.y = y;
    }

    public void topleft(int x, int y)                                      {pos(x, y);}
    public void topright(int x, int y)                     {pos(x - this.width, y);}
    public void bottomleft(int x, int y)                  {pos(x, y - this.height);}
    public void bottomright(int x, int y) {pos(x - this.width, y - this.height);}

    public void left(int x)                    {pos(x, this.y);}
    public void right(int x)   {pos(x - this.width, this.y);}
    public void top(int y)                     {pos(this.x, y);}
    public void bottom(int y) {pos(this.x, y - this.height);}

    public void moveUp(int dy)    {this.y += dy;}
    public void moveDown(int dy)  {this.y -= dy;}
    public void moveLeft(int dx)  {this.x -= dx;}
    public void moveRight(int dx) {this.x += dx;}
    public void move(int dx, int dy) {this.x += dx; this.y += dy;}

    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
}

