package com.raminrakhamimov.angrymasons;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Angry Masons " + AngryMasons.VERSION;
		cfg.useGL20 = true;
		cfg.width = 1280;
		cfg.height = 700;
		
		new LwjglApplication(new AngryMasons(), cfg);
	}
}
