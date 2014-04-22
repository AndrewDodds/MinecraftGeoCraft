package com.andy.firstmod.world;

import java.util.HashMap;
import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

public class AndySurfaceGeneratorFactory {
 
	public static final int WORLDTYPE_BATHOLITH = 0;
	public static final int WORLDTYPE_FOLDED  = 1;
	public static final int WORLDTYPE_LAYERED = 2;
	public static final int WORLDTYPE_VOLCANO = 3;
	
	private HashMap<String, AndyBaseSurfaceGenerator> worldBits;

	public AndySurfaceGeneratorFactory(){
		worldBits = new HashMap<String, AndyBaseSurfaceGenerator>();
	}
	 
	public AndyBaseSurfaceGenerator getSurfaceGenerator(int xPos, int zPos, Random r, AndyBlockManager myblocks) {
		
		int mx = xPos/128;
		int mz = zPos/128;
		
		if (xPos < 0) mx -=1;
		if (zPos < 0) mz -=1;
		
		String hash = new String("X"+mx+"s"+mz+"Z");

		//System.out.println("Get generator for hash: "+hash);

		if(worldBits.containsKey(hash))
			return worldBits.get(hash);
		
		int rockType = r.nextInt(4);
		
	//	rockType = WORLDTYPE_BATHOLITH;
		
		AndyBaseSurfaceGenerator absg = null;
		
		switch(rockType)
		{
		  case WORLDTYPE_BATHOLITH:
			  absg = new BatholithWorldGenerator(mx, mz, r, myblocks);
			  break;
		  case WORLDTYPE_FOLDED:
			  absg = new FoldedWorldGenerator(mx, mz, r, myblocks);
			  break;
		  case WORLDTYPE_LAYERED:
			  absg = new LayeredWorldGenerator(mx, mz, r, myblocks);
			  break;
		  case WORLDTYPE_VOLCANO:
			  absg = new VolcanoWorldGenerator(mx, mz, r, myblocks);
			  break;
		  
		  default:
			  absg = new BatholithWorldGenerator(mx, mz, r, myblocks);
			  break;
			  
			
		}
		worldBits.put(hash, absg);
		
		return absg;
		
	}
}
