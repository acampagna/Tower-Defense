package com.map;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tile extends Actor{
	public int id;
	public int sprite_id;
	
	public Tile(String name, int id, int sprite_id, int x,int y) {
		super(name);
		this.id = id;
		this.sprite_id = sprite_id;
		this.x = x;
		this.y = y;
		this.width = 32;
		this.height = 32;
	}
	
	public String toString() {
		return "["+this.id+"]"+this.x+","+this.y+" w:"+width+" h: "+height;
	}

	@Override
	public void draw(SpriteBatch arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor hit(float x, float y) {
        return x > 0 && y > 0 && x < width && y < height ? this : null;
	}

	@Override
	public boolean touchDown(float arg0, float arg1, int arg2) {
		return false;
	}

	@Override
	public void touchDragged(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touchUp(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
}
