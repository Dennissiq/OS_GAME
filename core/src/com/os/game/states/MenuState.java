package com.os.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.os.game.GameInit;

public class MenuState extends State{
	private Texture background;
	private Texture title;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);

		background = new Texture("bg-bw.png");
		title = new Texture("title3.png");
		
		
	}

	@Override
	public void handleInput() {
		if(Gdx.input.justTouched()) {
			gsm.set(new PlayState(gsm));		
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			gsm.set(new PlayState(gsm));
			
		}
		
	}

	@Override
	public void update(float dt) {
		handleInput();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(background, 0,0, GameInit.WIDTH, GameInit.HEIGHT);
		sb.draw(title, GameInit.WIDTH / 2 - (title.getWidth() / 2), GameInit.HEIGHT/2);
		sb.end();
		
	}

	@Override
	public void dispose() {
		background.dispose();
		title.dispose();
		
		System.out.println("***************** Menu State Disposed ****************\n "
				+ "\r\n"
				+ "              a          a\r\n" + 
				"             aaa        aaa\r\n" + 
				"            aaaaaaaaaaaaaaaa\r\n" + 
				"           aaaaaaaaaaaaaaaaaa\r\n" + 
				"          aaaaafaaaaaaafaaaaaa\r\n" + 
				"          aaaaaaaaaaaaaaaaaaaa\r\n" + 
				"           aaaaaaaaaaaaaaaaaa\r\n" + 
				"            aaaaaaa  aaaaaaa\r\n" + 
				"             aaaaaaaaaaaaaa\r\n" + 
				"  a         aaaaaaaaaaaaaaaa\r\n" + 
				" aaa       aaaaaaaaaaaaaaaaaa\r\n" + 
				" aaa      aaaaaaaaaaaaaaaaaaaa\r\n" + 
				" aaa     aaaaaaaaaaaaaaaaaaaaaa\r\n" + 
				" aaa    aaaaaaaaaaaaaaaaaaaaaaaa\r\n" + 
				"  aaa   aaaaaaaaaaaaaaaaaaaaaaaa\r\n" + 
				"  aaa   aaaaaaaaaaaaaaaaaaaaaaaa\r\n" + 
				"  aaa    aaaaaaaaaaaaaaaaaaaaaa\r\n" + 
				"   aaa    aaaaaaaaaaaaaaaaaaaa\r\n" + 
				"    aaaaaaaaaaaaaaaaaaaaaaaaaa\r\n" + 
				"     aaaaaaaaaaaaaaaaaaaaaaaaa\n");
	
	}

}
