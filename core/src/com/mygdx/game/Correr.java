package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Correr extends Image{
	
	public Correr(Texture texture){
		
		super(texture);
		
	}
	
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
        
		this.setX(this.getX()+3);
        
	}
	
}
