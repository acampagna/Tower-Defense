package com.map;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Map extends Group{
	public ArrayList<Tile> 			tiles;
	private Texture                 texture;
    public SpriteBatch              batch;
    public int				   		height;
    public int				   		width;

    private TextureRegion[]         regions = new TextureRegion[16];
    final short map[][] ={
    		{3 , 3, 3,11,9 , 3, 3,11, 9, 3, 3, 3, 3, 3, 3, 3, 3 ,3 ,3 ,3 ,3, 4},
    		{3 ,3 ,3 ,11,9 ,3 ,3 ,11,5 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,12, 4},
    		{3 ,6 ,8 ,5 ,9 ,3 ,3 ,13,10,10,10,10,10,10,10,10,10,10,10,5,9, 4},
    		{3 ,11,5 ,10,7 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,11 ,9, 4},
    		{3 ,11,9 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9, 4},
    		{3 ,11,9 ,3 ,3 ,3 ,6 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,12,3 ,3 ,3 ,11,9, 4},
    		{3 ,11,9 ,3 ,3 ,3 ,11,5 ,10,10,10,10,10,10,5 ,9 ,3 ,3 ,3 ,11,9, 4},
    		{3 ,11,5 ,8 ,8 ,8 ,5 ,9 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9 ,3 , 3 ,3 ,11,9, 4},
    		{3 ,13,10,10,10,10,10,7 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9 ,3 , 3 ,3 ,11,9, 4},
    		{3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9 ,3 , 3 ,3 ,11,9, 4},
    		{3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9 ,3 , 3 ,3 ,11,9, 4},
    		{3 ,6 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,5,9 ,3 , 3 ,3 ,11,9, 4},
    		{3 ,11,5 ,10,10,10,10,10,10,10,10,10,10,10,10,7 ,3 ,3 ,3 ,11,9, 4},
    		{3 ,11,9 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9, 4},
    		{3 ,11,9 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,11,9, 4},
    		{3 ,11,5 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,5 ,9 , 4},
    		{3 ,13,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,7, 4},
    		{2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2, 2 ,2 ,2 ,2, 0}
  };
    
    final int WIDTH = map[0].length;
	final int HEIGHT = map.length;
	final int TILE_SIZE = 32;
	
	public Map() {
		super();
		
		texture = new Texture(Gdx.files.internal("data/tiles.png"), true);
        batch = new SpriteBatch();
        tiles = new ArrayList<Tile>();
        
        regions[0] = new TextureRegion(texture, 0, 0, 32, 32); // Green
        regions[1] = new TextureRegion(texture, 32, 0, 32, 32); // Red
        regions[2] = new TextureRegion(texture, 64, 0, 32, 32); // Red
        regions[3] = new TextureRegion(texture, 96, 0, 32, 32); // Red
        
        regions[4] = new TextureRegion(texture, 0, 32, 32, 32); // Green
        regions[5] = new TextureRegion(texture, 32, 32, 32, 32); // Red
        regions[6] = new TextureRegion(texture, 64, 32, 32, 32); // Red
        regions[7] = new TextureRegion(texture, 96, 32, 32, 32); // Red
        
        regions[8] = new TextureRegion(texture, 0, 64, 32, 32); // Green
        regions[9] = new TextureRegion(texture, 32, 64, 32, 32); // Red
        regions[10] = new TextureRegion(texture, 64, 64, 32, 32); // Red
        regions[11] = new TextureRegion(texture, 96, 64, 32, 32); // Red
        
        regions[12] = new TextureRegion(texture, 0, 96, 32, 32); // Green
        regions[13] = new TextureRegion(texture, 32, 96, 32, 32); // Red
        regions[14] = new TextureRegion(texture, 64, 96, 32, 32); // Red
        regions[15] = new TextureRegion(texture, 96, 96, 32, 32); // Red
        
        height = HEIGHT*TILE_SIZE;
        width = WIDTH*TILE_SIZE;
        
        create();
	}
	
	public void create() {
		int n=0;
		Tile tmp;
		
		for(int y=0;y<=17;y++){
			for(int x=0;x<=21;x++){
				tmp = new Tile(n,map[y][x],x*TILE_SIZE,(HEIGHT - 1 - y) * TILE_SIZE);
				System.out.println(tmp.toString());
				this.addActor(tmp);
				n++;
			}
		}
	}
	
	public void render() {
		this.batch.begin();
		for (int i = 0; i < children.size(); i++) {
            Tile child = (Tile)children.get(i);
            if (child.visible) {
            	this.batch.draw(regions[child.sprite_id], child.x, child.y);
            }
        }
		this.batch.end();
	}
	
    
}
