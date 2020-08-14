package com.rockbite.bootcamp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float xPos;
	float yPos;

	private final float delta = 0.2f;
	private float counter;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.41015625f, 0.6015625f, 0.7578125f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		counter += Gdx.graphics.getDeltaTime();

		if(counter >= 0.016){
			animate();
			counter = 0;
		}

		batch.begin();
		batch.draw(img, xPos, yPos, 150, 200);
		batch.end();
//		System.out.println(Gdx.graphics.getDeltaTime());
	}

	private void animate() {
		xPos += delta;
		yPos += delta;
	}

	@Override
	public void dispose () {
//		System.out.println("Game Over");
		batch.dispose();
		img.dispose();
	}
}
