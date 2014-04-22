package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Conglomerate extends Block 
{

    public Conglomerate (Material material) 
    {
            super(material);

           
            this.setHardness(3.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("conglomerate");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:conglomerate");
 
            this.setHarvestLevel("pickaxe", 1) ;
}

    
    
}
