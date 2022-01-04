package com.poli.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.blocks.ModBlocksProperties.ZURRUDIUM_ORE_PROPERTIES;
import static com.poli.main.ZurrudiumMod.MODID;

public class ModBlocks
{    public static final DeferredRegister<Block> DR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> ZURRUDIUM_ORE =
            DR_BLOCKS.register("zurrudium_ore", ()->new Block(ZURRUDIUM_ORE_PROPERTIES));
}
