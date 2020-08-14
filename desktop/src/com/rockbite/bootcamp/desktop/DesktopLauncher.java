package com.rockbite.bootcamp.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.rockbite.bootcamp.MyGdxGame;

public class DesktopLauncher {
    //Atlas rebuilding flag
    private static boolean rebuildAtlas = true;

    public static void main(String[] arg) {

        if (rebuildAtlas) {
            TexturePacker.Settings settings = new TexturePacker.Settings();
            settings.maxWidth = 2048;
            settings.maxHeight = 2048;
            settings.duplicatePadding = false;
            //TexturePacker.process(settings, source folder of images, output folder, atlas file)
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
