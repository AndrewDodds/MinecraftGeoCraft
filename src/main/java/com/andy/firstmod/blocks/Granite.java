package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Granite extends Block 
{

    public Granite (Material material) 
    {
        super(material);
        this.setHardness(12.0f);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("granite");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName("andymod:granite");

        this.setHarvestLevel("pickaxe", 1) ;
        
    }

    
    
}
