package com.poli.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.blocks.ModBlocksProperties.MOD_ORE_PROPERTIES;
import static com.poli.tutorialmod.TutorialMod.MODID;

public class ModBlocks
{    public static final DeferredRegister<Block> DR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> MOD_ORE_VEIN =
            DR_BLOCKS.register("mod_ore_vein", ()->new Block(MOD_ORE_PROPERTIES));
}
