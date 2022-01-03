package com.poli.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

import static com.poli.tutorialmod.TutorialMod.MODID;

public class ModItemsTags {
    public static final Tags.IOptionalNamedTag<Item> MOD_ORE_ITEM =
            ItemTags.createOptional(new ResourceLocation(MODID,"mod_ore"));
}
