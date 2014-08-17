package com.mygdx.actors;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.CyberSlasher;
import com.mygdx.items.Equipable;
import com.mygdx.items.Item;

public class Player extends Actor
{
	private Item[] Inventory;
	private Equipable[] pEquipment;
	
	public Player(Vector3 pos)
	{
		super(pos);
	}
}