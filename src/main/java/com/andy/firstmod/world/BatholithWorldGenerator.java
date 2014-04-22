package com.andy.firstmod.world;

import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

public class BatholithWorldGenerator extends AndyBaseSurfaceGenerator {

	public void buildBlocks( Random random) {
		blocks = new short[128][128][128]; // 16 meg(!)
		override = new boolean[128][128][128]; // 16 meg(!)
		
		int offsetX = 48 + random.nextInt(32);
		int offsetZ = 48 + random.nextInt(32);
		
		
		int[] layers = new int[128];

	
		for(int i=0; i<128; i++) {
			int r = random.nextInt(13);
			if(r < 10)
			  layers[i] = custblocks.allMyBlockIDs[r];
			if(r ==10)
			  layers[i] = AndyBlockManager.BLOCK_COAL;	
			if(r == 11)
				  layers[i] = AndyBlockManager.BLOCK_SANDSTONE;	
			if(r == 12)
				  layers[i] = AndyBlockManager.BLOCK_SAND;
		}
		
		for(int x = 0; x< 128; x++) {
    	  for(int z = 0; z< 128; z++) {
 			for(int y = 0; y< 128; y++) {
			  blocks[x][y][z] = (short) layers[y];
			}
		  }
		}
		
		double angle = 3.0d + (random.nextDouble()*2.0d);
		double dist = angle;
		for(int y=70; y>9; y--) {
			for(int x = 0; x< 128; x++) {	
				double dx = (x-offsetX);
				for(int z = 0; z< 129; z++) {
					double dz = (z-offsetZ);

					double dist2 = (dx*dx) + (dz*dz);
					if(dist2 < (dist*dist)) {

						blocks[x][y][z] = (short) custblocks.getGranite(); //Granite
						override[x][y][z] = true;
						
						if(random.nextInt(7) == 3) {
							int r2 = random.nextInt(6);
							if(r2 < 3 || y > 60) {
								blocks[x][y][z] = AndyBlockManager.BLOCK_IRONORE;
							}
							else if (r2 < 4) {
								blocks[x][y][z] = AndyBlockManager.BLOCK_GOLDORE;
							}
							else if (r2 < 5) {
								blocks[x][y][z] = AndyBlockManager.BLOCK_TNT; 
							}
							else {
								blocks[x][y][z] = AndyBlockManager.BLOCK_DIAMONDORE;							
							}
						}
					}
				}	
			}
			dist += angle;
			angle *= 0.75d;
		}
		
		angle = 3.0d + (random.nextDouble()*2.0d);
		dist = angle;
		for(int y=60; y>9; y--) {
			for(int x = 0; x< 128; x++) {	
				double dx = (x-offsetX);
				for(int z = 0; z< 129; z++) {
					double dz = (z-offsetZ);

					double dist2 = (dx*dx) + (dz*dz);
					if(dist2 < (dist*dist)) {

						blocks[x][y][z] = AndyBlockManager.BLOCK_LAVA; //Lava
						}
				}	
			}
			dist += angle;
			angle *= 0.75d;
		}
		
		angle = 3.0d + (random.nextDouble()*2.0d);
		dist = angle;
		for(int y=50; y>9; y--) {
			for(int x = 0; x< 128; x++) {	
				double dx = (x-offsetX);
				for(int z = 0; z< 129; z++) {
					double dz = (z-offsetZ);

					double dist2 = (dx*dx) + (dz*dz);
					if(dist2 < (dist*dist)) {

						blocks[x][y][z] =  AndyBlockManager.BLOCK_OSBEDIAN;
						}
				}	
			}
			dist += angle;
			angle *= 0.75d;
		}
		
    }
		
	
	
	public BatholithWorldGenerator(int mx, int mz, Random random, AndyBlockManager myblocks) {
		super(mx, mz, random, myblocks); // TBD
	}
	
	
}
