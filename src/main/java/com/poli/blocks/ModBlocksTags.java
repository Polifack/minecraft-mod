package com.poli.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import static com.poli.main.ZurrudiumMod.MODID;

public class ModBlocksTags {
    public static final Tags.IOptionalNamedTag<Block> ZURRUDIUM_BLOCKS =
            BlockTags.createOptional(new ResourceLocation(MODID,"zurrudium_mod"));
}
