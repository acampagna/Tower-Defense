package com.towerdefense;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class TowerDefenseDesktop {
	public static void main(String[] args) {
		new JoglApplication(new TowerDefense(), "Tower Defense", 480,320,false);
	}
}
