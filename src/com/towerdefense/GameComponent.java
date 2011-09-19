package com.towerdefense;

public abstract class GameComponent {
    
    public GameComponent() {
    }
    
    public abstract void update();
    public abstract void render();
    public abstract void dispose();
}
