package com.poli.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import static com.poli.items.ModItems.ZURRUDIUM_INGOT;

public class ModArmorMaterials {
    public static ArmorMaterial ZURRUDIUM_ARMOR_MATERIAL = new ModArmorMaterialBase(10, new int[]{950, 1400, 1800, 1000},
            new int[]{3,6,8,3},1f,.1f,"zurrudium", SoundEvents.ARMOR_EQUIP_GENERIC,
            ()->Ingredient.of(ZURRUDIUM_INGOT.get()));
}
