package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Basalt extends Block 
{

    public Basalt (Material material) 
    {
            super(material);
            
            this.setHardness(5.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("Basalt");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:basalt");

            this.setHarvestLevel("pickaxe", 1) ;
            
            

    }

    
    
}
