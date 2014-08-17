package com.mygdx.actors;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class Block
{
	static final private float SIZE = 1f;
	
	private Vector3 b_Position;
	private BoundingBox b_Bounds;
	
	public Block(Vector3 position)
	{
		this.b_Position = position;
		
		Vector3 min = position.add(-SIZE/2);
		Vector3 max = position.add(SIZE/2);
		
		this.b_Bounds = new BoundingBox(min, max);
	}
	
	public Vector3 getPosition()
	{
		return this.b_Position;
	}
	
	public BoundingBox getBounds()
	{
		return this.b_Bounds;
	}
	
	public float getSize()
	{
		return SIZE;
	}
}
