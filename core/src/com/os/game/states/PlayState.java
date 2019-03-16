package com.os.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.os.game.GameInit;
import com.os.game.sprites.Cat;
import com.os.game.sprites.Obstacle;

public class PlayState extends State {
	private static final int SPACING = 125;
	private static final int CAT_COUNT = 35;
	
	private Cat cat;
	private Texture bg;
//	private Obstacle obstacle;
	
	private Array<Obstacle> obstacles;
	
	
	protected PlayState(GameStateManager gsm) {
		super(gsm);
		cat = new Cat(150, 250);
		cam.setToOrtho(false, GameInit.WIDTH, GameInit.HEIGHT);
		bg = new Texture("bg.png");
//		obstacle = new Obstacle(250);
		
		obstacles = new Array<Obstacle>();
		
		for (int i = 1; i <= CAT_COUNT; i++) {
			obstacles.add(new Obstacle(i * SPACING + Obstacle.OBS_WIDTH));
		}
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.justTouched()) {
			cat.jump();
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			cat.jump();
			
		}
//		if(Gdx.input.isTouched()) {
//			cat.fly();
//		}
		
	}

	@Override
	public void update(float dt) {
		handleInput();
		cat.update(dt);
		cam.position.x = cat.getPosition().x + 80;
		
		for(int i = 0; i < obstacles.size; i++) {
			Obstacle obstacle = obstacles.get(i);
			if(cam.position.x - (cam.viewportWidth / 2) > obstacle.getPosObs().x + obstacle.getObs().getWidth()) {
				obstacle.reposition(obstacle.getPosObs().x + ((Obstacle.OBS_WIDTH + SPACING * CAT_COUNT)));			
			}
			
			if (obstacle.collides(cat.getBounds())) {
		
				gsm.set(new PlayState(gsm));
			}
		}
		
		cam.update();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
		sb.draw(cat.getTexture(), cat.getPosition().x, cat.getPosition().y);
		
		for (Obstacle obstacle : obstacles) {
			sb.draw(obstacle.getObs(), obstacle.getPosObs().x, obstacle.getPosObs().y);
		}
//		sb.draw(obstacle.getObs(), obstacle.getPosObs().x, obstacle.getPosObs().y);
		
//		sb.draw(cat, GameInit.WIDTH / 2 - (cat.getWidth() / 2), 145);
		sb.end();
	}

	@Override
	public void dispose() {
		bg.dispose();
		cat.dispose();
		for(Obstacle obstacle : obstacles) {
			obstacle.dispose();
		}
			
		System.out.println("***************** Play State Disposed ****************");
	}
	
	
	

}
