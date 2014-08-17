package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.mygdx.game.CyberSlasher;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		new LwjglApplication(new CyberSlasher(), "Cyber Slasher", 480, 320);
	}
}
