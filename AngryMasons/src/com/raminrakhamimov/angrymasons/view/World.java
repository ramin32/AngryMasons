package com.raminrakhamimov.angrymasons.view;

import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.raminrakhamimov.angrymasons.AngryMasons;
import com.raminrakhamimov.angrymasons.model.Ship;

public class World {
	AngryMasons game;
	Ship ship;
	
	public World(AngryMasons game) {
		this.game = game;
		Vector2 shipVector = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		ship = new Ship(shipVector, 1, 1, 0, 5f);
	}

	public Ship getShip() {
		return ship;
	}
}
