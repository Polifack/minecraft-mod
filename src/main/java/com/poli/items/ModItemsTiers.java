package com.poli.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

import static com.poli.items.ModItems.ZURRUDIUM_INGOT;

public class ModItemsTiers
{
    public static final ForgeTier ZURRUDIUM_TIER = new ForgeTier(3, 1500, 8.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL,
            ()-> Ingredient.of(ZURRUDIUM_INGOT.get()));
}
