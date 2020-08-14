package com.rockbite.bootcamp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;

    //starting position x
    float xPos = 1000;
    //starting position x
    float yPos = 650;

    //one step of a texture
    private final float delta = 1;
    //counter for rendering animation
    private float counter;
    //index of region in the texture
    private int index = 0;
    //index that show how long yPos must not be changed
    private int stopIndex = 0;
    //array of regions from texture
    private final Array<TextureAtlas.AtlasRegion> regions = new Array<>();
    //internal path of compiled images
    private final String internalPathOfCompilingPictures = "images/butterflyAtlas.png";
    //internal path of TextureAtlas
    private final String textureInternalPath = "images/butterflyAtlas.png";

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture(textureInternalPath);
        img.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        TextureAtlas textureAtlas = new TextureAtlas(internalPathOfCompilingPictures);

        regions.add(textureAtlas.findRegion("1", -1));
        regions.add(textureAtlas.findRegion("2", -1));
        regions.add(textureAtlas.findRegion("3", -1));
        regions.add(textureAtlas.findRegion("4", -1));
        regions.add(textureAtlas.findRegion("5", -1));
        regions.add(textureAtlas.findRegion("6", -1));
        regions.add(textureAtlas.findRegion("7", -1));
        regions.add(textureAtlas.findRegion("8", -1));
        regions.add(textureAtlas.findRegion("9", -1));
        regions.add(textureAtlas.findRegion("10", -1));
        regions.add(textureAtlas.findRegion("11", -1));
        regions.add(textureAtlas.findRegion("12", -1));
        regions.add(textureAtlas.findRegion("13", -1));
        regions.add(textureAtlas.findRegion("14", -1));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.41015625f, 0.6015625f, 0.7578125f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        counter += Gdx.graphics.getDeltaTime();

        if (counter >= 0.016) {
            animate();
            counter = 0;
        }

        batch.begin();
        batch.draw(regions.get(index++ % 14), xPos, yPos, 150, 200);
        batch.end();
//		System.out.println(Gdx.graphics.getDeltaTime());
    }

    void reset() {
        xPos = 1000;
        yPos = 650;
        stopIndex = 0;
    }

    private void animate() {
        yPos -= delta;
        xPos -= delta;

        if (((yPos > 495) && (yPos < 505)) && stopIndex < 100) {
            yPos += delta;
            stopIndex++;
        }
        if (stopIndex >= 100) {
            yPos += delta * 2;
        }
        if (xPos < 600) {
            reset();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
