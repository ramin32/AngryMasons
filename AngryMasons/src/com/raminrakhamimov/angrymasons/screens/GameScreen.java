package com.raminrakhamimov.angrymasons.screens;

import com.badlogic.gdx.Screen;
import com.raminrakhamimov.angrymasons.AngryMasons;
import com.raminrakhamimov.angrymasons.view.World;
import com.raminrakhamimov.angrymasons.view.WorldRenderer;

public class GameScreen implements Screen {

	private AngryMasons game;
	World world;
	WorldRenderer renderer;

	public GameScreen(AngryMasons game) {
		this.game = game;
		world = new World(game);
		renderer = new WorldRenderer(world);
	}
	@Override
	public void render(float delta) {
		world.update();
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {
		dispose();		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		world.dispose();

	}

}
