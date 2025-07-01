package net.chamosio.otg.gui;

import net.chamosio.otg.Main;
import net.chamosio.otg.assets.Assets;

public class TitleScreen {
    public PlayButton playButton;
    public TitleScreen() {
        this.playButton = new PlayButton(
            Main.SCREEN_WIDTH - Assets.PLAY_BUTTON.getWidth() - 40 /*padding*/,
            40 /*padding*/,
            Assets.PLAY_BUTTON.getWidth(),
            Assets.PLAY_BUTTON.getHeight()
        );
    }
    public void handleClickEvent(int x, int y) {
        if (playButton.isIn(x, y)) playButton.onClick();
    }
}
