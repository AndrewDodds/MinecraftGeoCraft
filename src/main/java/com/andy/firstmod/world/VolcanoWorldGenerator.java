package com.andy.firstmod.world;

import java.util.Random;

import com.andy.firstmod.blocks.AndyBlockManager;

public class VolcanoWorldGenerator extends AndyBaseSurfaceGenerator {

	public void buildBlocks( Random random) {
		blocks = new short[128][128][128]; // 16 meg(!)
		override = new boolean[128][128][128]; // 16 meg(!)
		
		int offsetX = 48 + random.nextInt(32);
		int offsetZ = 48 + random.nextInt(32);
		
		int vheight = 66 + random.nextInt(50);
		
		double angle = 1.0d/((random.nextDouble()*1.5d) +0.9d);
		
		int width = 1+ random.nextInt(4);
		
		int[] layers = new int[20];
		int[] thick = new int[20];

	
		for(int i=0; i<20; i++) {
			thick[i] = random.nextInt(14)+1;
	    	switch(random.nextInt(6)) {
			case 0: 
				layers[i] = custblocks.getBasalt();
				break;
			case 1: 
				layers[i] = custblocks.getDolerite();
				break;
			case 2: 
				layers[i] = custblocks.getGranite();
				break;
			case 3: 
				layers[i] = custblocks.getRhyolite();
				break;
			case 4: 
				layers[i] = AndyBlockManager.BLOCK_OSBEDIAN; // 49; //Osbedia
				thick[i] = 1;
				break;
			case 5: 
				layers[i] = AndyBlockManager.BLOCK_GOLDORE;
				thick[i] = 1;
				break;
			default: 
				layers[i] = AndyBlockManager.BLOCK_STONE;
				thick[i] = 1;
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
			if(i > 50 && ybreak[i] == 10)
				ybreak[i] = 13; //Gravel
		}
				
		for(int x = 0; x< 128; x++) {
    	  for(int z = 0; z< 128; z++) {
 			for(int y = 0; y< 128; y++) {
			  blocks[x][y][z] = ybreak[y];
			  override[x][y][z] = false;
			}
		  }
		}
		
		for(int y=(vheight-1); y>9; y--) {
			for(int x = offsetX-width; x< offsetX+width; x++) {				
				for(int z = offsetZ-width; z< offsetZ+width; z++) {
					blocks[x][y][z] = AndyBlockManager.BLOCK_LAVA; // Lava tube creation..
					override[x][y][z] = true;

				}	
			}
		}
		
		for(int x = offsetX-width; x< offsetX+width; x++) {				
			for(int z = offsetZ-width; z< offsetZ+width; z++) {
				blocks[x][vheight][z] = -10; // Lava tube creation..
				override[x][vheight][z] = true;
				blocks[x][vheight+1][z] = -10; // Lava tube creation..
				override[x][vheight+1][z] = true;

			}	
		}
		
	//	System.out.println("Done lava tube, starting cone..");
		
		double extent = width+1;
		
		for(int y=vheight; y>60; y--) {
			int lay = 1;
	    	switch(random.nextInt(5)) {
			case 0: 
				lay = custblocks.getBasalt(); 
				break;
			case 1: 
				lay = custblocks.getBasalt(); 
				break;
			case 2: 
				lay = custblocks.getGranite(); 
				break;
			case 3: 
				lay = custblocks.getRhyolite(); 
				break;
			case 4: 
			default:
				lay = custblocks.getGranite(); 
				if(random.nextInt(10) == 1  && y > 80)
					lay = AndyBlockManager.BLOCK_DIAMONDORE; // Diamond ore
				else if(random.nextInt(5) == 1)
					lay = AndyBlockManager.BLOCK_IRONORE; // Iron ore
				break;
	    	}
			for(int x = 0-(int)extent; x<(int)extent; x++)
			{
				for(int z = 0-(int)extent; z<(int)extent; z++) {
					int xp = x+offsetX;
					int zp = z+offsetZ;
					if(xp > -1 && xp < 128 && zp > -1 && zp < 128) {
						
						double dist = (x*x) + (z*z);
						if(dist < (extent*extent))
						{
							override[xp][y][zp] = true;
							
							if(blocks[xp][y][zp] != 10  && blocks[xp][y][zp] != -10) {
								blocks[xp][y][zp] = (short) lay; // Volcano
								
							}
							if(blocks[xp][y][zp] == -10) {
								blocks[xp][y][zp] = 0; // Volcano
								override[xp][y][zp] = true;
								
							}
						}
					}	
				}
		    }
			extent += angle;
			angle += 0.02;
	    }
    }
		
	
	
	public VolcanoWorldGenerator(int mx, int mz, Random random, AndyBlockManager myblocks) {
		super(mx, mz, random, myblocks);
	}


}
