package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Plataforma extends Image {

	int velocidad=30;
	Plataforma(){
		super(new Texture("mountains.png"));
		this.setX(500);
		this.setY(-200);
	}
	
	public void act(float delta){
		super.act(delta);
		this.setX(this.getX()-delta*velocidad);
	}
}

