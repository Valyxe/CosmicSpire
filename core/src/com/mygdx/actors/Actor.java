package com.mygdx.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.mygdx.game.CyberSlasher;

public abstract class Actor
{
	private enum State
	{
		IDLE, WALKING, JUMPING, DYING
	}

	static final private float SPEED = 2f;
	static final private float JUMP_VELOCITY = 1f;
	static final private float SIZE = 0.5f;
	
	private CyberSlasher cGame;
	private Vector3 cCurrent_Position;
	private Vector3 cCurrent_Acceleration;
	private Vector3 cCurrent_Velocity;
	private BoundingBox cCurrent_Bounds;
	private State cCurrent_State;
	private Vector3 cCurrent_Facing;

	private Texture cCurrent_Sprite;
	
	private int cMax_Health = 100;
	private int cCurrent_Health;
	
	public Actor(Vector3 position)
	{
		//this.cGame = game;
		this.cCurrent_Health = this.cMax_Health;
		//this.cCurrent_Sprite = new Texture(texture);
		this.cCurrent_Position = position;
		this.cCurrent_Facing = new Vector3(1.0f, 0.0f, 0.0f);
		
		Vector3 min = position.add(-SIZE/2);
		Vector3 max = position.add(SIZE/2);
		this.cCurrent_Bounds = new BoundingBox(min, max);
	}
	
	public void LoseHealth(int magnitude)
	{
		this.cCurrent_Health -= magnitude;
	}
	
	public void GainHealth(int magnitude)
	{
		this.cCurrent_Health += magnitude;
	}
	
	public Vector3 getPosition()
	{
		return this.cCurrent_Position;
	}
	
	public BoundingBox getBounds()
	{
		return this.cCurrent_Bounds;
	}
	
	public float getSize()
	{
		return SIZE;
	}
	
	public int GetHealth()
	{
		return this.cCurrent_Health;
	}
	
	public Vector3 GetDirection()
	{
		return this.cCurrent_Facing;
	}
}
