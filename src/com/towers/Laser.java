package com.towers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Laser extends RedTower {
	
	public Laser() {
		System.out.println("Laser:Red Tower Created");
		super.texture = new Texture(Gdx.files.internal("data/tower-red-laser.png"));

		x = 0;
		y = 0;
		width = 32;
		height = 32;
	}
}
