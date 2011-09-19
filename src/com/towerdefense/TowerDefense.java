package com.towerdefense;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer10;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Label;
import com.map.Map;
import com.map.Tile;
import com.towers.Laser;

public class TowerDefense implements ApplicationListener, InputProcessor {

	static int WIDTH  = 480;
    static int HEIGHT = 320;

    private OrthographicCamera      cam;
    private Map						map;
    private Laser					laser;
    public Stage					stage;
    public Group					gameGroup;
    public Group					uiGroup;
    Vector2 point = new Vector2();
    BitmapFont font;
    ImmediateModeRenderer10 renderer;

    
    public int						inputPhase; //0 = idle, 1 = dragging, 2 = panning

    @Override
    public void create() {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		font = new BitmapFont();
		
		stage = new Stage(WIDTH,HEIGHT,true);
		gameGroup = new Group();
		uiGroup = new Group();
		stage.getRoot().addActor(gameGroup);
		stage.getRoot().addActor(uiGroup);
		
		uiGroup.x = 0;
		uiGroup.y = 0;
		uiGroup.width = WIDTH;
		uiGroup.height = HEIGHT;
		
        cam = new OrthographicCamera(WIDTH, HEIGHT);
        cam.position.set(WIDTH/2, HEIGHT/2, 0);
		
        map = new Map();
        gameGroup.addActor(map);
        
		laser = new Laser();
		
		uiGroup.addActor(laser);
		
		Label fps = new Label("fps", font, "fps: 0");
        fps.x = 10;
        fps.y = HEIGHT-20;
        fps.color.set(0, 1, 0, 1);
        uiGroup.addActor(fps);
		
		inputPhase = 0;
		
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        renderer = new ImmediateModeRenderer10();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
            handleInput();
            GL10 gl = Gdx.graphics.getGL10();
            
            gl.glClearColor(1,1,1,1);
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
            
            cam.update();  
            
            map.batch.setProjectionMatrix(cam.combined);

            gl.glEnable(GL10.GL_TEXTURE_2D);
            
            //laser.render();
            
            map.render();
            
            ((Label)uiGroup.findActor("fps")).setText("fps: " + Gdx.graphics.getFramesPerSecond()
                    + ", groups " + stage.getGroups().size()
                    + ", gameGroup " + gameGroup.getGroups().size()
                    + ", UIGroup " + uiGroup.getGroups().size()
                    + ", Map " + map.getActors().size());
            
            stage.draw();
    }
    
    

    private void handleInput() {
    	if(this.inputPhase == 0) {
    		if(Gdx.input.isTouched(0)) {

                stage.toStageCoordinates(Gdx.input.getX(), Gdx.input.getY(), point);
                Actor actor = stage.hit(point.x, point.y);
                if(actor != null) {
                	//System.out.println(actor.toString());
                	if(actor instanceof Tile) {
                		Vector3 v = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            			cam.unproject(v);
            			Tile tile = (Tile)map.hit(v.x,v.y);
            			if(tile != null) {
            				tile.sprite_id = 5;
            			}
                	}
                }
    		}
    		panCamera();
    	} // End Idle
    	
    	if(this.inputPhase == 1) {
    		
    	} // End Dragging
    	
    	if(this.inputPhase == 2) {
    		
    	} // End Panning
        
    }
    
    private void panCamera() {
        if(Gdx.input.isTouched(0)) {
        	int dx = Gdx.input.getDeltaX(0);
        	int dy = Gdx.input.getDeltaY(0);
        	
        	cam.translate(-dx, dy, 0);
        	if(cam.position.x < 0+(WIDTH/2)) {
        		cam.position.x = 0+(WIDTH/2);
        	}
        	if(cam.position.y < 0+(HEIGHT/2)) {
        		cam.position.y = 0+(HEIGHT/2);
        	}
        	if (cam.position.x > map.width-(WIDTH/2)) {
        		cam.position.x = map.width-(WIDTH/2);
        	}
        	if (cam.position.y > map.height-(HEIGHT/2)) {
        		cam.position.y = map.height-(HEIGHT/2);
        	}
        }
    }

    @Override
    public void resize(int width, int height) {
            // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
            // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
            // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
            // TODO Auto-generated method stub
    }

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		System.out.println("Touch Down");
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		return false;
	}

	@Override
	public boolean touchMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}
}
