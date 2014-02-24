package com.raminrakhamimov.angrymasons.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.raminrakhamimov.angrymasons.model.Ship;

public class WorldRenderer {
	
	World world;
	SpriteBatch batch;
	Ship ship;
	OrthographicCamera camera;
	Texture shipTexture;
	float width;
	float height;
	
	public WorldRenderer(World world) {
		this.world = world;
		
		width = Gdx.graphics.getWidth() / 40;
		height = Gdx.graphics.getHeight() / 40;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		camera.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		
		shipTexture = new Texture("data/ship.png");
		shipTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		ship = world.getShip();
		camera.position.set(ship.getPosition().x, ship.getPosition().y, 0);
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(shipTexture, 
				   ship.getPosition().x,
				   ship.getPosition().y,
				   0,
				   0,
				   ship.getWidth(), 
				   ship.getHeight(),
				   1,
				   1,
				   ship.getRotation(),
				   0,
				   0, 
				   shipTexture.getWidth(),
				   shipTexture.getHeight(),
				   false,
				   false);
		batch.end();
		
	}
	
	public void dispose () {
		batch.dispose();
		shipTexture.dispose();
	}

}
