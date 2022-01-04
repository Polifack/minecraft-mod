package com.poli.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ModHammerItem extends SwordItem {
    public ModHammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker){

        ServerLevel world = (ServerLevel) attacker.level;
        ServerPlayer player = (ServerPlayer) attacker;

        BlockPos target_position = target.blockPosition();
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, target_position,
            MobSpawnType.TRIGGERED, true, true);

        itemStack.hurtAndBreak(1, target, (e) -> {
            e.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        return true;
    }
}
