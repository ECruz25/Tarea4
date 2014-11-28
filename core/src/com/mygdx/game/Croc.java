package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Croc extends Actor{
	
    ArrayList<Image> images;
    
    Image image1;
    Image image2;
    Image image3;
    Image image4;
    Image image5;
    
    int dibujo_actual=0,llamadas_act=0;
    
    float tiempo_act=0;
    
    public Croc(){
    
    	super();
        
    	images = new ArrayList<Image>();
		
		image1 = new Image(new Texture("croc01.png"));
		image1.setX(400);
		image1.setY(250);
		
		image2 = new Image(new Texture("croc02.png"));
		image2.setX(400);
		image2.setY(250);
		
		image3 = new Image(new Texture("croc03.png"));
		image3.setX(400);
		image3.setY(250);
		
		image4 = new Image(new Texture("croc04.png"));
		image4.setX(400);
		image4.setY(250);
		
		image5 = new Image(new Texture("croc05.png"));
		image5.setX(400);
		image5.setY(250);
		
		
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
        
        llamadas_act++;
    
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        images.get(dibujo_actual).draw(batch,parentAlpha);
    }
}