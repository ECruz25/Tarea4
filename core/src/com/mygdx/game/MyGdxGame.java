package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	
	SpriteBatch batch;
	
	public static final int GAME_RUNNING = 0;
	
    public static final int GAME_PAUSED = 1;
    
    public int gameStatus;
	
	Music music;
	
	Stage stage;
	Stage menu;
	
	Image nube;
	
	Texture img;
	
	int frame = 0;
	
	int frame1 = 0;
	
	Corredor corredor;
	
	@Override
	public void create () {
		
        stage = new Stage();
        menu = new Stage();
        
        batch = new SpriteBatch();
        
        music = Gdx.audio.newMusic(Gdx.files.internal("fight.wav"));
        
        Gdx.input.setInputProcessor(this);
        
        corredor = new Corredor();
        
//        stage.addActor(corredor);
        
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		corredor.saltar();
		
		return false;
	
	}
	
	void addCorredor(){
		
		stage.addActor(corredor);
		
	}
	
	void addExplode(){
		
		stage.addActor(new Explosion());
		
	}
	
	void addRunner(){
		
		stage.addActor(new Runner());
		
	}
	
	void addCroc(){
		
		stage.addActor(new Croc());
		
	}
	
	void addSun(){
		
		stage.addActor(new Sun());
		
	}
	
	void addBomb(){
    	
        stage.addActor(new Bomb(new Texture("bomba01.png")));
       
    }
	
	void addNube(){
		
		stage.addActor(new Nube(new Texture("nube.png")));
		
	}
	
	void addBackground(){

        stage.addActor(new Plataforma());
		
	}
	
	void addPauseScreen(){
		
		menu.addActor(new Image(new Texture("pause.png")));
		
	}
	
	void resumeGame(){
		
		menu.clear();
		
	}
	
	

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //music.play();
   
        stage.draw();
        stage.act();
        menu.draw();
        menu.act();
        
        if (gameStatus == GAME_PAUSED) {
                    	
        	addPauseScreen();
        	
        }
        
        if(gameStatus == GAME_RUNNING){
        	
        	resumeGame();
        	
        }
        
        if (frame%6000==0){

            addBackground();

        }
        
        if(frame%200000==0){
        	
        	addBomb();
        	
        }
        
        if (frame%100000==0){

            addSun();

        }
        
        if(frame%2000==0){
        	
            addNube();
        	
        }
        
        if (frame%7550000==0){

            addExplode();

        }
        
        if (frame%100000==0){

            addRunner();

        }
        
        if (frame%100000==0){

           	addCorredor();

        }
        
        
        
//        if (frame%100000==0){
//
//            addCroc();
//
//        }
        
        frame+=1;
        frame1+=15;
        
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		if(character == 'M'||character == 'm'){
			
			pauseGame();
			
		}
		
		else if(character == 'p' || character == 'P'){
			
			resume();
			
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void pauseGame() {
		
		try {
			stage.wait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
        gameStatus = GAME_PAUSED;
   
	}

    // this is called by android 
	@Override
    public void pause() {
		
        stage.clear();
    
	}
	
	
}
