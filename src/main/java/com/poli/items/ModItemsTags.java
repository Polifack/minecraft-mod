package com.poli.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

import static com.poli.main.ZurrudiumMod.MODID;

public class ModItemsTags {
    public static final Tags.IOptionalNamedTag<Item> ZURRUDIUM_ITEM =
            ItemTags.createOptional(new ResourceLocation(MODID,"zurrudium"));
}
