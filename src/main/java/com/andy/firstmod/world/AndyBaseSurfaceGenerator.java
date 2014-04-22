package com.andy.firstmod.world;

import java.util.HashSet;
import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class AndyBaseSurfaceGenerator {

	
	
	protected int mapX;
	protected int mapZ;
	
	private int counter;
	
	protected short[][][] blocks;
	protected boolean[][][] override;
	boolean blocksInitalised = false;
	
	protected AndyBlockManager custblocks;
	private HashSet<String> done;
	
	private boolean isDebug = false;
	
	public abstract void buildBlocks( Random random);
	
	public AndyBaseSurfaceGenerator(int mx, int mz, Random random, AndyBlockManager myblocks) {
		mapX = mx;
		mapZ = mz;
		
		custblocks = myblocks;
		
		buildBlocks(random);
		blocksInitalised = true;

	   	System.out.println("New WorldGenerator mx:"+mx+" mz:"+mz);
	    
		done = new HashSet<String>();
		
		counter = 0;
	}
	
	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		String hash = "Cx: "+chunkX+" Cz:"+chunkZ;
				
		if(!blocksInitalised) {
		   	System.out.println("RECREATE WorldGenerator "+hash);
		   	buildBlocks(random);
		   	blocksInitalised = true;
		   	counter = 16;
		}
		
		if(done.contains(hash)) {
		   	System.out.println("************************ World Gen - Seen this before "+hash);
			return;
			
		}
		else {
		   //	System.out.println("World Gen - "+hash+" Count : "+counter++);
			done.add(hash);
		}
		
		int tx = chunkX%128;
		int tz = chunkZ%128;
		
		if(tx < 0) tx +=128;
		if(tz < 0) tz +=128;
			
		for(int x=tx; x<tx+16; x++) {
			for(int z=tz; z<tz+16; z++) {
				for(int y=10; y<128; y++) {
					if(blocks[x][y][z] != 0) {
						
						double p = 1.0d;
						if(x < 5 || x > 124 || z < 5 || z> 124) // Terrain boundaries - currently randomise, is there a better way.
							  p = random.nextDouble();

						if(x < 1 ||  z < 1) // Seems that we are index 1 based - avoid recursive collapse..
							  p = 0.0d;
						
						if(p > 0.5d) {
							Block current = world.getBlock(chunkX+(x-tx), y, chunkZ+(z-tz));
				            int blockID = Block.getIdFromBlock(current);
				            
				            boolean canOverride = false;
				            if(blockID == 1) canOverride = true;  // We are replacing Stone, that's pretty much the point of the mod!
				            
				            if((blockID == 2 || blockID == 3  ) && (y < 64 || isDebug)) canOverride = true; // At the seaside we replace Dirt and Grass. Or if debugging so we can see the rocks
				            
				            if(override != null && override[x][y][z]) canOverride = true; // OR we have bespoke override in place (used by volcanoes)
				            // Checks that there is nothing in the current location and there is grass beneath.
				            if(canOverride) // Stone
				            {
				            	Block toPlace = null;
				            	try {		            		
					            	toPlace = Block.getBlockById(blocks[x][y][z]); // Find the rock to place..
				            	}	
					            catch (Exception e) {
					            	System.out.println("Get Block Error at : x:"+x+" y:"+y+" z:"+z+" error:"+e.getMessage());
					            	System.out.println("blocksInitalised: "+blocksInitalised);
					            	System.out.println("Value: "+blocks[x][y][z]);
					            }
		
		                        if(toPlace != null)
		                        {
		                        	try {  // Stick it in..		            		
		                        		world.setBlock(chunkX+(x-tx), y, chunkZ+(z-tz), toPlace);
					            	}
		                        	catch (Exception e) {
		                        		System.out.println("set BLock Error at : x:"+chunkX+(x-tx)+" y:"+y+" z:"+chunkZ+(z-tz)+" error:"+e.getMessage());
					              	}  
		                        }
				            }    
			            }   
		            }   
	            }    
			}
        }    

		if(counter >60 ) {
		   	System.out.println("DISPOSE WorldGenerator "+hash+" NOT, Counter:"+counter);
		   	
			//blocks = new int[1][1][1];
			//blocksInitalised = false;
		}
	}
	
}
