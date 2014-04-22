package com.andy.firstmod.world;

import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

public class LayeredWorldGenerator extends AndyBaseSurfaceGenerator {

	public void buildBlocks( Random random) {
		blocks = new short[128][128][128]; // 16 meg(!)

		int dipX =  random.nextInt(7) + 1;
		int dipZ =  random.nextInt(7) + 1;
		
		int[] layers = new int[10];
		int[] thick = new int[10];
	
		for(int i=0; i<10; i++) {
			thick[i] = random.nextInt(26)+1;
			
	    	switch(random.nextInt(6)) {
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
				layers[i] = AndyBlockManager.BLOCK_COAL;
				thick[i] = random.nextInt(2)+1;
				break;
			case 5: 
				layers[i] = custblocks.getSlate();
				break;
			default: 
				layers[i] = AndyBlockManager.BLOCK_STONE;
				break;
			}
		}
		
		short[] ybreak = new short[128];

		int sum = thick[0];
		int layer = 0;
		for(int i=0; i<128; i++) {
			if(i==sum && layer < 9) {
				layer++;
				sum += thick[layer];
			}
			ybreak[i] = (short) layers[layer];
		}
				
		for(int x = 0; x< 128; x++) {
    	  for(int z = 0; z< 128; z++) {
    		int elevation = ((x/dipX) + (z/dipZ)) % 128;
			for(int y = 0; y< 128; y++) {
			  int e = elevation + y;
			  if(e > 127) e-=128;
			  blocks[x][e][z] = ybreak[y]; 
			//  override
			}
		  }
		}
		
	}
	
	public LayeredWorldGenerator(int mx, int mz, Random random, AndyBlockManager myblocks) {
		super(mx, mz, random, myblocks);
	}

}
