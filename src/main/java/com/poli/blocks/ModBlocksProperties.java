package com.poli.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ModBlocksProperties {
    public static final BlockBehaviour.Properties MOD_ORE_PROPERTIES =
        BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();
}
