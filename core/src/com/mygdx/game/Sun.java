package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public class Sun extends Actor{
	
    ArrayList<Image> images;
    
    Image image1;
    Image image2;
    Image image3;
    Image image4;
    
    int dibujo_actual=0;
    
    float tiempo_act=0;
    
    public Sun(){
    
    	super();
        
    	images = new ArrayList<Image>();
		
		image1 = new Image(new Texture("sun.png"));
		image1.setX(-70);
		image1.setY(650);
		image2 = new Image(new Texture("sun02.png"));
		image2.setX(-70);
		image2.setY(650);
		image3 = new Image(new Texture("sun03.png"));
		image3.setX(-70);
		image3.setY(650);
		image4 = new Image(new Texture("sun.png"));
		image4.setX(-70);
		image4.setY(650);
		
		
		images.add(image1);
		images.add(image2);
		images.add(image3);
		images.add(image4);
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
    
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        images.get(dibujo_actual).draw(batch,parentAlpha);
    }
}