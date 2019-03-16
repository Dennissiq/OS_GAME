package com.os.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Cat {
	private static final int GRAVITY = -15;
	private static final int MOVEMENT = 400;
	private Vector3 position;
	private Vector3 velocity;
	private Rectangle bounds;
	
	private Texture cat;
	private Sound meow;
	
	public Cat(int x, int y) {
		position = new Vector3 (x, y, 0);
		velocity = new Vector3 (0, 0, 0);
		cat = new Texture("cat-idle.png");
		bounds = new Rectangle(x, y, cat.getWidth(), cat.getHeight());
		meow = Gdx.audio.newSound(Gdx.files.internal("meow.mp3"));
	}
	
	public void update(float dt) {
		if(position.y > 0 )
			velocity.add(0, GRAVITY, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, velocity.y, 0);
		
		if(position.y < 145) {
			position.y = 145;
		}
		
//		if(position.x > 1366) {
//			position.x = 0;
//		}
		
		velocity.scl(1/dt);
		bounds.setPosition(position.x, position.y);
		
	}

	public Vector3 getPosition() {
		return position;
	}

	public Texture getTexture() {
		return cat;
	}
	
	public void jump() {
		velocity.y = 250;
		meow.play();
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void walk() {
		velocity.y = 25;
		position.x = position.x + 10;
	}
	
	public void fly() {
		velocity.y = 50;
		position.x = position.x + 25;
	}

	public void dispose() {
		cat.dispose();
		meow.dispose();
		
	}
}
