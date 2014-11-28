package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bomb extends Image{
	
	int y = 300;
	
	int j = 0;

	 Bomb(Texture texture){
		  
	      super(texture);

	      addListener(new BombInput(this));
	      
	      this.setX(1000);
	      
	  }
	  
	  @Override
	  public void act(float delta) {
		  
		  super.act(delta);
		  
		  this.setY(0);
		  
		  this.setX(this.getX()-15);
	        
	      if(this.getX()<50){
	        	
	    	  this.setX(1000);
	    	  
	    	  j++;
	        	
	     }
	    
	  }
	
}