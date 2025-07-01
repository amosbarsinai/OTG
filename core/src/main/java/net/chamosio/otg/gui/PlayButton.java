package net.chamosio.otg.gui;

import net.chamosio.otg.Main;

public class PlayButton extends Button {
    @Override
    public void onClick() {
        Main.startGame();
    }

    public PlayButton(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
