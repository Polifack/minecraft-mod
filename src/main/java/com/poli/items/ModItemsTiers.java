package com.poli.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

import static com.poli.items.ModItems.MOD_ORE_INGOT;

public class ModItemsTiers
{
    public static final ForgeTier ORE_MOD_TIER = new ForgeTier(3, 1500, 8.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL,
            ()-> Ingredient.of(MOD_ORE_INGOT.get()));
}
