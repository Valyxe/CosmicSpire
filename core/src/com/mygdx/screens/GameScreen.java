package com.mygdx.screens;

import com.badlogic.gdx.Screen;
import com.mygdx.model.World;
import com.mygdx.view.WorldRenderer;

public class GameScreen implements Screen
{
	private World world;
	private WorldRenderer renderer;
	
	@Override
	public void render(float delta)
	{
		renderer.render();
	}

	@Override
	public void resize(int width, int height)
	{
		
	}

	@Override
	public void show()
	{
		world = new World();
		renderer = new WorldRenderer(world);
	}

	@Override
	public void hide()
	{
		
	}

	@Override
	public void pause()
	{
		
	}

	@Override
	public void resume()
	{
		
	}

	@Override
	public void dispose()
	{
		renderer.dispose();
	}
}
