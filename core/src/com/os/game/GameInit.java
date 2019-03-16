package com.os.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.os.game.states.GameStateManager;
import com.os.game.states.MenuState;


public class GameInit extends ApplicationAdapter {
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		music.dispose();
	}

	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;
	public static final String TITLE = "Try Cat";
	private GameStateManager gsm;
	private SpriteBatch batch;
	
	private Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("Cyberblast-Title.mp3"));
		music.setLooping(true);
//		music.setVolume(0.1f);
		music.play();
		Gdx.gl.glClearColor(0, 0, 1, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
}
