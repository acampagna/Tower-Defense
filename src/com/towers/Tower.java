package com.towers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tower extends Actor {

	public String name;
	protected Texture texture;
	public int lastShot;
	public int level;
	public int cost;
	
	public Tower() {
		
	}
	
	public Tower(String name) {
		super(name);
	}

	public void update() {
	}

	public void render() {
	}

	public void dispose() {
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(this.texture, x, y);
	}

	@Override
    public boolean touchDown (float x, float y, int pointer) {
        if (!touchable) return false;
        return x > 0 && y > 0 && x < width && y < height;
    }
	
	@Override
    public Actor hit (float x, float y) {
        return x > 0 && y > 0 && x < width && y < height ? this : null;
    }

	@Override
	public void touchDragged(float arg0, float arg1, int arg2) {
	}

	@Override
	public void touchUp(float arg0, float arg1, int arg2) {
	}
	
}