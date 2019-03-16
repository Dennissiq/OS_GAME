package com.os.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.os.game.GameInit;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		  config.width = GameInit.WIDTH;
          config.height = GameInit.HEIGHT;
//          config.backgroundFPS = 120;
          config.fullscreen = false;
          config.title = GameInit.TITLE;

		new LwjglApplication(new GameInit(), config);
	}
}
