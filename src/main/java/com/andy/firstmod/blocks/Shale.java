package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Shale extends Block 
{

    public Shale (Material material) 
    {
            super(material);

            this.setHardness(4.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("shale");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:shale");
}

    
    
}
