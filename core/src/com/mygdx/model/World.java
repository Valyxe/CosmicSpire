package com.mygdx.model;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.Block;
import com.mygdx.actors.Player;

public class World
{
	private Array<Block> w_Blocks = new Array<Block>();
	private Player w_Player;
	private Environment w_Environment;
	
	public Array<Block> getBlocks()
	{
		return w_Blocks;
	}
	
	public Player getPlayer()
	{
		return w_Player;
	}
	
	public Environment getEnvironment()
	{
		return w_Environment;
	}
	
	public World()
	{
		createDemoWorld();
	}
	
	public void createDemoWorld()
	{
		w_Environment = new Environment();
		w_Environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1.0f));
		w_Environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, 1.0f, -0.8f, -0.2f));
		
		w_Player = new Player(new Vector3(7.0f, 2.0f, 0.0f));
		for(float i = 0.0f; i < 10.0f; i++)
		{
			w_Blocks.add(new Block(new Vector3(i, 0.0f, 0.0f)));
			w_Blocks.add(new Block(new Vector3(i, 6.0f, 0.0f)));
			if (i > 2)
			{
				w_Blocks.add(new Block(new Vector3(i, 1.0f, 0.0f)));
			}
		}
		w_Blocks.add(new Block(new Vector3(9.0f, 2.0f, 0.0f)));
		w_Blocks.add(new Block(new Vector3(9.0f, 3.0f, 0.0f)));
		w_Blocks.add(new Block(new Vector3(9.0f, 4.0f, 0.0f)));
		w_Blocks.add(new Block(new Vector3(9.0f, 5.0f, 0.0f)));
	
		w_Blocks.add(new Block(new Vector3(6.0f, 3.0f, 0.0f)));
		w_Blocks.add(new Block(new Vector3(6.0f, 4.0f, 0.0f)));
		w_Blocks.add(new Block(new Vector3(6.0f, 5.0f, 0.0f)));
	}
}
