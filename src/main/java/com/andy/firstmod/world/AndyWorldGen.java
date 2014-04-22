package com.andy.firstmod.world;


import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;


public class AndyWorldGen implements IWorldGenerator{

private AndySurfaceGeneratorFactory asfg;
private AndyBlockManager abm;

@Override
public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
{

  if(asfg == null)
	  asfg = new AndySurfaceGeneratorFactory();
	
  if(abm == null)
	  abm = new AndyBlockManager();
		
  switch(world.provider.dimensionId)
  {
		 case 1:
			 generateNether(world, random, chunkX * 16, chunkZ * 16);
		 case 0:
			 generateSurface(world, random, chunkX * 16, chunkZ * 16);
		 case -1:
			 generateEnd(world, random, chunkX * 16, chunkZ * 16);
  }
}


/*private Block[] myBlocks() {
	// My current block set
	Block[] retVal = new Block[10];
	
	retVal[0] = AndyMod.basalt;
	retVal[1] = AndyMod.conglomerate;
	retVal[2] = AndyMod.dolerite;
	retVal[3] = AndyMod.gneiss;  
	retVal[4] = AndyMod.granite;
	retVal[5] = AndyMod.limestone; 
	retVal[6] = AndyMod.rhyolite;
	retVal[7] = AndyMod.shale; 
	retVal[8] = AndyMod.siltstone;
	retVal[9] = AndyMod.slate;

	return retVal;
}*/



private void generateSurface(World world, Random random, int chunkX, int chunkZ)
{

	
	AndyBaseSurfaceGenerator absg = asfg.getSurfaceGenerator(chunkX,  chunkZ, random, abm);
	
	if(absg != null)
	{
		absg.generateSurface(world, random, chunkX, chunkZ);
		return;
	}

// 1st go at generation..	
/*	int r = random.nextInt(10);
	
	Block toPlace = myBlocks()[r];
	
		
	int bid = Block.getIdFromBlock(toPlace);
	
	//if(toPlace == null)
	toPlace = Block.getBlockById(bid);
	
	//if (random.nextInt(7) == 5)
	{
	        // Loops 64 times, this could create up to 64 TNT
    	for( int x = chunkX - 8; x < chunkX + 8; x++)
    	{
        	for( int z = chunkZ - 8; z < chunkZ + 8; z++)
        	{	
         		int elevation = ((x/4) + (z/3)) % 100;
 	                
                Block current = world.getBlock(x, elevation, z);
                int blockID = Block.getIdFromBlock(current);
                
                // Checks that there is nothing in the current location and there is grass beneath.
                if(blockID == 0)
                if(toPlace != null)
                {
                	try {
                        world.setBlock(x, elevation, z, toPlace);
                	}
                	catch (Exception e) {
                		System.out.println("Error : "+e.getMessage());
                	}
                }
		    }    
	    }
	}       */
	
}

private void generateEnd(World world, Random random, int chunkX, int chunkZ){

}


private void generateNether(World world, Random random, int chunkX, int chunkZ){


}
}
	