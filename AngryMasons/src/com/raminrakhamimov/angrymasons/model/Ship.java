package com.raminrakhamimov.angrymasons.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Ship extends MoveableEntity {

	public Ship(Vector2 position, float width, float height, float rotation, float speed) {
		super(speed, rotation, width, height, position);
	}

	public void update() {
		position.add(velocity.cpy().scl(Gdx.graphics.getDeltaTime() * speed));
		
		if (velocity.x != 0 || velocity.y != 0) {
			rotation = velocity.angle() - 90;
		}
		
		bounds.x = position.x;
		bounds.y = position.y;
	}
	
	

	
}
