package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Limestone extends Block 
{

    public Limestone (Material material) 
    {
            super(material);
            this.setHardness(4.0f);
            this.setStepSound(Block.soundTypeStone);
            this.setBlockName("limestone");
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockTextureName("andymod:limestone");

            this.setHarvestLevel("pickaxe", 1) ;
   }

    
    
}
