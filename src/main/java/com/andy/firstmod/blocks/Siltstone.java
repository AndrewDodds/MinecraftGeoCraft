package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Siltstone extends Block 
{

    public Siltstone (Material material) 
    {
            super(material);
            
            this.setHardness(6.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("siltstone");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:siltstone"); 
    }

    
    
}
