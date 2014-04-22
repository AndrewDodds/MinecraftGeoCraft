package com.andy.firstmod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class Rhyolite extends Block 
{

    public Rhyolite (Material material) 
    {
        super(material);
        this.setHardness(10.0f);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("Rhyolite");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName("andymod:rhyolite");

     }

    
    
}
