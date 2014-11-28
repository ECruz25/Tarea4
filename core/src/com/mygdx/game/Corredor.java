package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public class Corredor extends Actor{
	
    ArrayList<Image> images;
    
    int dibujo_actual=0;
    
    float tiempo_act=0;
    
    float velocidad_y=0;
	
	float aceleracion_y=0.01f;
    
    public Corredor (){
    
    	super();
        
    	images = new ArrayList<Image>();
        
        images.add(new Image(new Texture("run01.png")));
        images.add(new Image(new Texture("run02.png")));
        images.add(new Image(new Texture("run03.png")));
        
        
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
        
        velocidad_y+=aceleracion_y;
		
		this.setY(this.getY()+velocidad_y);
		
		if(this.getY()<=0){
			
			velocidad_y = 0;
			aceleracion_y = 0;
			this.setY(0);
			
		}
		
		//Desplazamiento en Y
		velocidad_y+=aceleracion_y;
		this.setY(this.getY()+velocidad_y);
		
		//Gravedad
		aceleracion_y-=0.25;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
		
    	images.get(dibujo_actual).setX(300);
    	images.get(dibujo_actual).setY(0);
		images.get(dibujo_actual).setY(this.getY());
        
		super.draw(batch, parentAlpha);
        
        images.get(dibujo_actual).draw(batch,parentAlpha);
        
    }
    
	public void saltar(){
		
		System.out.println("toque");
		aceleracion_y=2;
	
	}

}
