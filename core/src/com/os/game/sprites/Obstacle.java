package com.os.game.sprites;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Obstacle {
	private static final int FLUCTUATION = 130;
	private static final int OBS_GAP = 50;
	private static final int LOWEST_OPENING = 300;
	public static final int OBS_WIDTH = 30;

	private Texture obs;
	private Vector2 posObs;
	private Random rand;
	private Rectangle bounds;
	
	public Obstacle(float x) {
		obs = new Texture("cat-min-inverted.png");
		rand = new Random();
		
//		posObs = new Vector2 (x, 145);
		posObs = new Vector2 (x + 400, 145 +  rand.nextInt(FLUCTUATION + OBS_GAP + LOWEST_OPENING));
		
		bounds = new Rectangle(posObs.x, posObs.y, obs.getWidth(), obs.getHeight());
	}
	
	public void reposition (float x) {
		posObs.set(x, 145 + rand.nextInt(FLUCTUATION + OBS_GAP + LOWEST_OPENING));
		bounds.setPosition(posObs.x, posObs.y);
	}
	
	public boolean collides(Rectangle player) {
		
		return player.overlaps(bounds);
	}
	
	
	public Texture getObs() {
		return obs;
	}
	
	public Vector2 getPosObs() {
		return posObs;
	}

	public void dispose() {
		obs.dispose();
		
	}

}
