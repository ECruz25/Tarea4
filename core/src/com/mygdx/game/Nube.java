package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.Texture;

public class Nube extends Image{
	
	Nube(Texture texture){
		
		super(texture);
		
		this.setX(1366);
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		this.setY(550);
        
        this.setX(this.getX()-1);
        
        if(this.getX()<-200){
        	
        	this.setX(1366);
        	
        }
        
	}
	
}
