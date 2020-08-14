package com.rockbite.bootcamp.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.rockbite.bootcamp.MyGdxGame;

public class DesktopLauncher {
    private static boolean rebuildAtlas = true;
    private static boolean drawDebugOutline = true; //TODO

    public static void main(String[] arg) {

        if (rebuildAtlas) {
            TexturePacker.Settings settings = new TexturePacker.Settings();
            settings.maxWidth = 2048;
            settings.maxHeight = 2048;
            settings.duplicatePadding = false;
            settings.debug = drawDebugOutline;
            //TexturePacker.process(settings, source folder this can be in
            TexturePacker.process(settings, "pics",
                    "images",
                    "butterflyAtlas");
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Butterfly";
        config.width = 1200;
        config.height = 800;
        new LwjglApplication(new MyGdxGame(), config);
    }
}
