package com.andy.firstmod.world;

import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

public class FoldedWorldGenerator extends AndyBaseSurfaceGenerator {

	public void buildBlocks( Random random) {
		blocks = new short[128][128][128]; // 16 meg(!)
		
		double angle = random.nextDouble() * 0.9d;
		
		double afactor = ((random.nextDouble() * 10.0d)+1.0d) /(angle+0.1);
		
		
		int[] layers = new int[20];
		int[] thick = new int[20];

	
		for(int i=0; i<20; i++) {
			thick[i] = random.nextInt(14)+1;
	    	switch(random.nextInt(8)) {
			case 0: 
				layers[i] = custblocks.getConglomerate();
				break;
			case 1: 
				layers[i] = custblocks.getLineStone();
				break;
			case 2: 
				layers[i] = custblocks.getShale();
				break;
			case 3: 
				layers[i] = custblocks.getSiltstone();
				break;
			case 4: 
				layers[i] = AndyBlockManager.BLOCK_WATER;
				thick[i] = 1;
				break;
			case 5: 
				layers[i] = AndyBlockManager.BLOCK_SANDSTONE;
				break;
			case 6: 
				layers[i] = AndyBlockManager.BLOCK_SAND;
				break;
			case 7: 
				layers[i] = custblocks.getBasalt();
				break;
			default: 
				layers[i] = AndyBlockManager.BLOCK_STONE; //Stone
				break;
			}
		}
		
		short[] ybreak = new short[128];
		int sum = thick[0];
		int layer = 0;
		for(int i=0; i<128; i++) {
			if(i==sum && layer < 19) {
				layer++;
				sum += thick[layer];
			}
			ybreak[i] = (short) layers[layer];
		}
				
		for(int x = 0; x< 128; x++) {
    	  for(int z = 0; z< 128; z++) {
    		double dist = ((x+(z*angle))*afactor) / 100.0d;
    		
    		int elevation = (int)(Math.sin(dist) * 10.0d);
			for(int y = 0; y< 128; y++) {
			  int e = elevation + y;
			  if(e > 127) e-=128;
			  if(e < 0) e+=128;
			  blocks[x][e][z] = ybreak[y]; //layers[y/13];
			}
		  }
		}
		
	}
	
	public FoldedWorldGenerator(int mx, int mz, Random random, AndyBlockManager myblocks) {
		super(mx, mz, random, myblocks);
	}
	

}
