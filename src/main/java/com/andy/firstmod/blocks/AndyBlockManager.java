package com.andy.firstmod.blocks;

import com.andy.firstmod.AndyMod;

import net.minecraft.block.Block;

public class AndyBlockManager {

	public static final int BLOCK_WATER = 8;
	public static final int BLOCK_LAVA = 10;
	public static final int BLOCK_SAND = 12;
	public static final int BLOCK_COAL = 173;
	public static final int BLOCK_SANDSTONE = 24;
	public static final int BLOCK_IRONORE = 15;
	public static final int BLOCK_GOLDORE = 14;
	public static final int BLOCK_DIAMONDORE = 56;
	public static final int BLOCK_OSBEDIAN = 49;
	public static final int BLOCK_STONE = 1;
	public static final int BLOCK_DIRT = 2;
	public static final int BLOCK_DIRTGRASS = 3;
	public static final int BLOCK_TNT = 46; // TNT
	
	
	private Block[] allMyBlocks;
	public short[] allMyBlockIDs;
	
	public AndyBlockManager() {
		allMyBlocks = new Block[10];
		allMyBlockIDs = new short[10];

		allMyBlocks[0] = AndyMod.basalt;
		allMyBlocks[1] = AndyMod.conglomerate;
		allMyBlocks[2] = AndyMod.dolerite;
		allMyBlocks[3] = AndyMod.gneiss;  
		allMyBlocks[4] = AndyMod.granite;
		allMyBlocks[5] = AndyMod.limestone; 
		allMyBlocks[6] = AndyMod.rhyolite;
		allMyBlocks[7] = AndyMod.shale; 
		allMyBlocks[8] = AndyMod.siltstone;
		allMyBlocks[9] = AndyMod.slate;

		for (int i=0; i<10; i++) {
			allMyBlockIDs[i] = (short) Block.getIdFromBlock(allMyBlocks[i]) ;
		}
 
	}
	
	public int getBasalt() {return allMyBlockIDs[0]; }
	
	public int getConglomerate() {return allMyBlockIDs[1]; }
	
	public int getDolerite() {return allMyBlockIDs[2]; }
	
	public int getGniess() {return allMyBlockIDs[3]; }
	
	public int getGranite() {return allMyBlockIDs[4]; }
	
	public int getLineStone() {return allMyBlockIDs[5]; }
	
	public int getRhyolite() {return allMyBlockIDs[6]; }
	
	public int getShale() {return allMyBlockIDs[7]; }
	
	public int getSiltstone() {return allMyBlockIDs[8]; }
	
	public int getSlate() {return allMyBlockIDs[9]; }
	
}
