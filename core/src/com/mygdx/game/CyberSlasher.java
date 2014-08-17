package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.screens.GameScreen;

public class CyberSlasher extends Game
{
	
	@Override
	public void create ()
	{
		setScreen(new GameScreen());
	}
}
