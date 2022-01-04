package com.poli.items.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ModDaggerItem extends SwordItem {

    public ModDaggerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker)
    {
        //??
        //target.hurt(DamageSource.playerAttack((Player) attacker),100.0f);

        // MobEffectInstance(effect, duration, amplification, is_ambient, is_visible, show_icon, (nullable) instance)
        // Note that duration is in TICKS and each 20 ticks = 1 second
        // So, if we put in duration 100 we are applying the effect for 5 seconds
        MobEffectInstance hurt_effect = new MobEffectInstance(MobEffects.POISON, 100);
        target.addEffect(hurt_effect,target);

        // Function that deals with decreasing durability
        // we just need to indicate:
        // hurtAndBreak(duration_decrement, attack_target, on_item_break)

        itemStack.hurtAndBreak(1, target, (e) -> {
            e.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        return true;
    }
}
