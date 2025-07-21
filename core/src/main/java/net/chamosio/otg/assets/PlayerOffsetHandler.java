package net.chamosio.otg.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.util.Objects;

public class PlayerOffsetHandler {
    public static int PLAYER_OFFSET_X;
    public static int PLAYER_OFFSET_Y;
    public static int PLAYER_OFFSET_WIDTH;
    public static int PLAYER_OFFSET_HEIGHT;
    public static void init() {
        FileHandle fileHandle = Gdx.files.internal("textures/entity/player/offsets.toml");
        String tomlContent = fileHandle.readString("UTF-8");

        TomlParseResult result = Toml.parse(tomlContent);

        if (result.hasErrors()) {
            result.errors().forEach(
                err -> System.err.println("Error in fetching player model offsets: " + err)
            );
            return;
        }

        PLAYER_OFFSET_X = Objects.requireNonNull(result.getLong("offsets.x")).intValue();
        PLAYER_OFFSET_Y = Objects.requireNonNull(result.getLong("offsets.y")).intValue();
        PLAYER_OFFSET_WIDTH = Objects.requireNonNull(result.getLong("offsets.width")).intValue();
        PLAYER_OFFSET_HEIGHT = Objects.requireNonNull(result.getLong("offsets.height")).intValue();
    }
}
