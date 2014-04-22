package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Gneiss extends Block 
{

    public Gneiss (Material material) 
    {
            super(material);
            this.setHardness(12.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("gneiss");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:gneiss");
 
            this.setHarvestLevel("pickaxe", 1) ;
   }

    
    
}
