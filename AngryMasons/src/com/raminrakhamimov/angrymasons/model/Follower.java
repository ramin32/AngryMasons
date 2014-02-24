package com.raminrakhamimov.angrymasons.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Follower extends MoveableEntity {
	
	private static final float ROTATION_SPEED = 500;

	public Follower(float speed, float rotation, float width, float height,
			Vector2 position) {
		super(speed, rotation, width, height, position);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(Ship ship) {
		velocity.lerp(ship.getPosition(), Gdx.graphics.getDeltaTime());
		
		rotation += Gdx.graphics.getDeltaTime() * ROTATION_SPEED;
		
		if (rotation > 360) {
			rotation -= 360;
		}
		super.update(ship);
		
	}

}
