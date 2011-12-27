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
    final String map[][] ={
		{"","","s:01","","","g:01","","","",""},
		{"","","w:s","","","w:n","","","w:w",""},
		{"","","","","","","","","",""},
		{"","","w:e","","w:s","","","","",""},
		{"","","","","","","","","",""},
		{"","","","","","","","","",""},
		{"","","","","w:e","","","","w:n",""},
		{"","","","","","","","","",""}
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
        regions[1] = new TextureRegion(texture, 0, 32, 32, 32); // Red
        regions[2] = new TextureRegion(texture, 32, 0, 32, 32); // Red
        regions[3] = new TextureRegion(texture, 32, 32, 32, 32); // Red
        
        height = HEIGHT*TILE_SIZE;
        width = WIDTH*TILE_SIZE;
        
        create();
	}
	
	public void create() {
		int n=0;
		Tile tmp;
		
		for(int y=0;y<=17;y++){
			for(int x=0;x<=21;x++){
				tmp = new Tile("tile"+n,n,map[y][x],x*TILE_SIZE,(HEIGHT - 1 - y) * TILE_SIZE);
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
