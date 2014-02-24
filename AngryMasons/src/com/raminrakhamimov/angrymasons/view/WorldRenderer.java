package com.raminrakhamimov.angrymasons.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.raminrakhamimov.angrymasons.model.Follower;
import com.raminrakhamimov.angrymasons.model.Ship;

public class WorldRenderer {
	
	World world;
	SpriteBatch batch;
	Ship ship;
	Follower follower;
	OrthographicCamera camera;
	Texture shipTexture;
	Texture followerTexture;
	float width;
	float height;
	ShapeRenderer sr;
	
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
		
		followerTexture = new Texture("data/follower.png");
		followerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sr = new ShapeRenderer();
	}
	
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		ship = world.getShip();
		follower = world.getFollower();
		
		camera.position.set(ship.getPosition().x, ship.getPosition().y, 0);
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(shipTexture, 
				ship.getPosition().x, ship.getPosition().y, 
				ship.getWidth()/2, 	ship.getHeight()/2, 
				ship.getWidth(), ship.getHeight(), 
				1, 1, 
				ship.getRotation(), 
				0, 0, 
				shipTexture.getWidth(), shipTexture.getHeight(), 
				false, false);
		batch.draw(followerTexture, 
				follower.getPosition().x, follower.getPosition().y, 
				follower.getWidth()/2, follower.getHeight()/2, 
				follower.getWidth(), follower.getHeight(), 
				1, 1, 
				follower.getRotation(), 
				0, 0, 
				followerTexture.getWidth(), followerTexture.getHeight(),
				false, false);
		
		batch.end();
		
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Line);
		sr.setColor(Color.CYAN);
		sr.rect(ship.getPosition().x, ship.getPosition().y, ship.getWidth(), ship.getHeight());
		sr.setColor(Color.RED);
		sr.rect(follower.getPosition().x, follower.getPosition().y, follower.getWidth(), follower.getHeight());
		
		sr.end();
		
	}
	
	public void dispose () {
		batch.dispose();
		shipTexture.dispose();
		sr.dispose();
	}

}
