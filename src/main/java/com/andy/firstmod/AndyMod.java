package com.andy.firstmod;

import com.andy.firstmod.blocks.*;
import com.andy.firstmod.world.AndyWorldGen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
//import net.minecraft.item.Item;
//import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = AndyMod.MODID, version = AndyMod.VERSION)
public class AndyMod {
    public static final String MODID = "andymod";
    public static final String VERSION = "1.0";

   // public static Item genericIngot;
    // public static Block genericOre;

    public static Block andyBlock1;
 
    public static Block basalt;
    public static Block conglomerate;
    public static Block  dolerite;
    public static Block gneiss;
    public static Block granite;
    public static Block limestone;
    public static Block rhyolite;
    public static Block shale;
    public static Block siltstone;
    public static Block slate;

    @Instance(value="andymod")
    public static AndyMod instance;

    @SidedProxy(clientSide="com.andy.firstmod.client.ClientProxy",
            serverSide="com.andy.firstmod.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {   	 
    	andyBlock1 = new AndyBlock1(Material.ground)
    	      .setHardness(0.5F).setStepSound(Block.soundTypeGravel).setBlockName("andyBlock1").setCreativeTab(CreativeTabs.tabBlock)
    	      .setBlockTextureName("andymod:andyblock");
    	 
    	andyBlock1.setHarvestLevel("andyBlock1",0) ;
    	
        basalt = new Basalt(Material.ground); 
        conglomerate = new Conglomerate(Material.ground);
        dolerite = new Dolerite(Material.ground);
        gneiss = new Gneiss(Material.ground);
        granite = new Granite(Material.ground);
        limestone = new Limestone(Material.ground);
        rhyolite = new Rhyolite(Material.ground);
        shale = new Shale(Material.ground);
        siltstone = new Siltstone(Material.ground);
        slate = new Slate(Material.ground);
 
    	
        GameRegistry.registerBlock(andyBlock1, "andyBlock1");

        GameRegistry.registerBlock(basalt, "basalt");
        GameRegistry.registerBlock(conglomerate, "conglomerate");
        GameRegistry.registerBlock( dolerite, " dolerite");
        GameRegistry.registerBlock(gneiss, "gneiss");
        GameRegistry.registerBlock(granite, "granite");
        GameRegistry.registerBlock(limestone, "limestone");
        GameRegistry.registerBlock(rhyolite, "rhyolite");
        GameRegistry.registerBlock(shale, "shale");
        GameRegistry.registerBlock(siltstone, "siltstone");
        GameRegistry.registerBlock(slate, "slate");
        
        GameRegistry.registerWorldGenerator(new AndyWorldGen(), 1000);

        	//genericOre = new GenericOre(Material.rock);
          // MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);
   	
// MinecraftForge.setBlockHarvestLevel(genericOre, "pickaxe", 3);
           // GameRegistry.registerBlock(genericOre, "genericOre");
            
         //   proxy.registerRenderers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
    
    
}

// See Basic items tutorial for Generic Ingot



