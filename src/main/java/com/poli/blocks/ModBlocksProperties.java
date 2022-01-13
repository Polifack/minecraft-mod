package com.poli.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ModBlocksProperties {
    public static final BlockBehaviour.Properties ZURRUDIUM_ORE_PROPERTIES =
        BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();


    public static final BlockBehaviour.Properties QUICKSAND_BLOCK_PROPERTIES =
            BlockBehaviour.Properties.of(Material.SAND).strength(3f).requiresCorrectToolForDrops();


    public static final BlockBehaviour.Properties MIMIC_BLOCK_PROPERTIES =
            BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(5f);
}
