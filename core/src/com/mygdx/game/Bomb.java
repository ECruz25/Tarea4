package com.mygdx.game;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bomb extends Image{
	
	ArrayList<Image> images;
	
	Image image1;
    Image image2;
    Image image3;
	
	int y = 300;
	
	Corredor p;
	
	int j = 0;
	
	int dibujo_actual=0;
	    
	float tiempo_act=0;
	    
	float velocidad_y=5;

	public Bomb(Corredor p){
		  
	      super();
	      
	      this.p = p;
	      
	      images = new ArrayList<Image>();
	      
	      image1 = new Image(new Texture("bomba01.png"));
	      image2 = new Image(new Texture("bomba02.png"));
	      image3 = new Image(new Texture("bomba03.png"));
	      
	      images.add(image1);
	      images.add(image2);
	      images.add(image3);
	      
//	      this.setX(1000);
	      
	  }
	  
	  @Override
	  public void act(float delta) {
		  
		  super.act(delta);

		  tiempo_act+=delta;
	        
	      if(tiempo_act>0.1f){
	            
	    	  dibujo_actual++;
	    	  tiempo_act=0;
	        
	      }

	      if (dibujo_actual>=images.size()){
	        
	    	  dibujo_actual=0;
	        
	      }
		  
	      this.setY(550);
	        
	      this.setX(this.getX()-15);
	        
	      if(this.getX()<0){
	        	
	    	  this.setX(1200);
	        	
	      }
	      
	      Rectangle r1=new Rectangle(this.getX(), this.getY(), 100, 100);
			
	      Rectangle r2=new Rectangle(p.getX(), p.getY(), 100, 100);
			
			if(r1.overlaps(r2)){
			
				System.out.println("Colision!");
				System.out.println("Perdiste");
				images.add(new Image(new Texture("gameover.png")));
			
			}
			
//			if(this.getX()<p.getX()+50
//					&& this.getX()+50>p.getX()
//					&& this.getY()<p.getY()+50
//					&& this.getY()+50>p.getY()){
//					
//				System.out.println("Colision!");
//				
//				images.add(new Image(new Texture("gameover.png")));	
//				
//			}
	    
	  }
	  
	  @Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		
		images.get(dibujo_actual).setHeight(150);
		images.get(dibujo_actual).setWidth(150);
		
		images.get(dibujo_actual).draw(batch,parentAlpha);

		images.get(dibujo_actual).setX(this.getX()-1);
	      
		
	}
	
}