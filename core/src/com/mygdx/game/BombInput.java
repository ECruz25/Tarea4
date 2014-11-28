package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BombInput extends InputListener{

	static boolean explode = false;
	
	Bomb bomb;
	
	public BombInput(Bomb bomb) {
		
		super();
		
		explode = true;
		
		this.bomb = bomb;
		
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		
		bomb.remove();
		
		return super.touchDown(event, x, y, pointer, button);
		
	}
	
	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer,
			int button) {
		
		super.touchUp(event, x, y, pointer, button);
	}
	
}
