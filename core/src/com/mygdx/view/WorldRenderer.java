package com.mygdx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.Block;
import com.mygdx.actors.Player;
import com.mygdx.model.World;

public class WorldRenderer
{
	private World wr_World;
	private OrthographicCamera wr_Cam;
	
	private AssetManager wr_Assets;
	private ModelBatch wr_Batch;
	private Array<ModelInstance> wr_ModelInstances;
	private static final String blockModel = "Models/TestBlock.g3db";
	private boolean loading;
	
	public WorldRenderer(World world)
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
		Gdx.gl.glDepthMask(true);
		Gdx.gl.glDepthFunc(GL20.GL_LESS);
		
		wr_World = world;
		wr_Batch = new ModelBatch();
		wr_ModelInstances = new Array<ModelInstance>();
		
		wr_Cam = new OrthographicCamera(10.0f, 7.0f);
		wr_Cam.position.set(5.0f, 3.5f, 0.0f);
		wr_Cam.direction.set(-1.0f, -1.0f, -1.0f);
		wr_Cam.near = 10.0f;
		wr_Cam.far = -10.0f;
		wr_Cam.update();
		
		wr_Assets = new AssetManager();
		wr_Assets.load(blockModel, Model.class);
		loading = true;
	}
	
	private void doneLoading()
	{
		
		
		Array<Block> blocks = wr_World.getBlocks();
		for(int i = 0; i < blocks.size; i++)
		{
			Model model = wr_Assets.get(blockModel, Model.class);
			Material material = model.getMaterial("Material");
			material.set(ColorAttribute.createDiffuse(Color.RED));
			material.set(new BlendingAttribute(1.0f));
			
			Block block = blocks.get(i);
			String id = model.nodes.get(0).id;
			ModelInstance instance = new ModelInstance(model);
			Node node = instance.getNode(id);
			
			instance.transform.set(node.globalTransform);
			
			float size = block.getSize();
			float x = block.getPosition().x;
			float y = block.getPosition().y;
			float z = block.getPosition().z;
			
			node.translation.set(x, y, z);
			node.scale.set(size, size, size);
			node.rotation.idt();
			instance.calculateTransforms();
			
			wr_ModelInstances.add(instance);
		}
		
		Model model = wr_Assets.get(blockModel, Model.class);
		Material material = model.getMaterial("Material");
		material.set(ColorAttribute.createDiffuse(Color.GREEN));
		material.set(new BlendingAttribute(1.0f));
		
		Player player = wr_World.getPlayer();
		String id = model.nodes.get(0).id;
		ModelInstance instance = new ModelInstance(model);
		Node node = instance.getNode(id);
		
		instance.transform.set(node.globalTransform);
		
		float size = player.getSize();
		float x = player.getPosition().x;
		float y = player.getPosition().y;
		float z = player.getPosition().z;
		
		node.translation.set(x, y, z);
		node.scale.set(size, size, size);
		node.rotation.idt();			
		instance.calculateTransforms();
		
		wr_ModelInstances.add(instance);
		
		loading = false;
	}
	
	public void render()
	{	
		if(loading && wr_Assets.update())
			doneLoading();
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		wr_Batch.begin(wr_Cam);
			wr_Batch.render(wr_ModelInstances, wr_World.getEnvironment());
		wr_Batch.end();
	}
	
	public void dispose()
	{
		wr_Batch.dispose();
		wr_ModelInstances.clear();
		wr_Assets.dispose();
	}
}