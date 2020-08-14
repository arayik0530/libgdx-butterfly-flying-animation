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
    private final static float delta = 1;
    //counter for rendering animation
    private float counter;
    //index of region in the texture
    private int index = 0;
    //index that show how long yPos must not be changed
    private int stopIndex = 0;
    private final Array<TextureAtlas.AtlasRegion> regions = new Array<>();
    //internal path of the texture
    private final String textureInternalPath = "images/butterflyAtlas.png";
    //index of the regions in atlas
    private final int regionIndex = -1;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture(textureInternalPath);
        img.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        TextureAtlas textureAtlas = new TextureAtlas("images/butterflyAtlas.atlas");

        regions.add(textureAtlas.findRegion("1", regionIndex));
        regions.add(textureAtlas.findRegion("2", regionIndex));
        regions.add(textureAtlas.findRegion("3", regionIndex));
        regions.add(textureAtlas.findRegion("4", regionIndex));
        regions.add(textureAtlas.findRegion("5", regionIndex));
        regions.add(textureAtlas.findRegion("6", regionIndex));
        regions.add(textureAtlas.findRegion("7", regionIndex));
        regions.add(textureAtlas.findRegion("8", regionIndex));
        regions.add(textureAtlas.findRegion("9", regionIndex));
        regions.add(textureAtlas.findRegion("10", regionIndex));
        regions.add(textureAtlas.findRegion("11", regionIndex));
        regions.add(textureAtlas.findRegion("12", regionIndex));
        regions.add(textureAtlas.findRegion("13", regionIndex));
        regions.add(textureAtlas.findRegion("14", regionIndex));
    }

    @Override
    public void render() {
        //background color
        Gdx.gl.glClearColor(0.41015625f, 0.6015625f, 0.7578125f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        counter += Gdx.graphics.getDeltaTime();

        if (counter >= 0.016) {
            animate();
            counter = 0;
        }

        batch.begin();
        //draw(regions[index], xPos, yPos, width, height)
        batch.draw(regions.get(index++ % regions.size), xPos, yPos, 150, 200);
        batch.end();
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
