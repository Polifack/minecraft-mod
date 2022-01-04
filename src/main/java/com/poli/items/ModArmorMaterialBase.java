package com.poli.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import static com.poli.main.ZurrudiumMod.MODID;

public class ModArmorMaterialBase implements ArmorMaterial {
    private final int enchantability;
    private final int [] durability, damage_reduction;
    private final float knockback_resistance, toughness;
    private final String name;
    private final SoundEvent equip_sound;
    private final Supplier<Ingredient> repair_material;

    public ModArmorMaterialBase(int enchantability, int[] durability, int[] damage_reduction,
                                float knockback_resistance, float toughness, String name,
                                SoundEvent equip_sound, Supplier<Ingredient> repair_material){
        this.enchantability=enchantability;
        this.durability=durability;
        this.damage_reduction=damage_reduction;
        this.knockback_resistance=knockback_resistance;
        this.toughness=toughness;
        this.name=name;
        this.equip_sound=equip_sound;
        this.repair_material=repair_material;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return durability[pSlot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return damage_reduction[pSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equip_sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repair_material.get();
    }

    @Override
    public String getName() {
        return MODID+":"+this.name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockback_resistance;
    }

}
