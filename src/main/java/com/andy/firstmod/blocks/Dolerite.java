package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Dolerite extends Block 
{

    public Dolerite (Material material) 
    {
            super(material);
            
            this.setHardness(7.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("dolerite");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:dolerite");
 
            this.setHarvestLevel("pickaxe", 1) ;
    }

    
    
}
