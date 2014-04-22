package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Slate extends Block 
{

    public Slate (Material material) 
    {
            super(material);
            this.setHardness(6.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("slate");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:slate");
    }

    
    
}
