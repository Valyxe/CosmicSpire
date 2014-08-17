package com.mygdx.items;

public abstract class Item
{
	private String eName;
	private String eDesc;

	public Item()
	{
		
	}
	
	public String GetName()
	{
		return eName;
	}
	
	public String GetDesc()
	{
		return eDesc;
	}
}
