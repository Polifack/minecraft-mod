package com.poli.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class ZurrudiumZombieEntity extends Zombie {

    public static double max_health = 10;
    public static double follow_range = 40;
    public static double movement_speed = 0.30;
    public static double attack_damage = 4;
    public static double armor_value = 3;
    public static double attack_knockback = 5;
    public static double armor_toughness = 1;

    public static final int xp_reward = 10;

    public ZurrudiumZombieEntity(EntityType<? extends Zombie> entityType, Level levelIn) {
        super(entityType, levelIn);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, max_health)
                .add(Attributes.FOLLOW_RANGE, follow_range)
                .add(Attributes.MOVEMENT_SPEED, movement_speed)
                .add(Attributes.ATTACK_DAMAGE, attack_damage)
                .add(Attributes.ATTACK_KNOCKBACK, attack_knockback)
                .add(Attributes.ARMOR, armor_value)
                .add(Attributes.ARMOR_TOUGHNESS, armor_toughness)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected int getExperienceReward(Player pPlayer) {
        return xp_reward;
    }

    @Override
    protected void registerGoals() {
        // lower means higher priority
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    // disable baby spawning
    public static boolean getSpawnAsBabyOdds(Random p_34303_) {
        return false;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    // Override from PathfinderMob
    @Override
    public boolean checkSpawnRules(LevelAccessor pLevel, MobSpawnType pSpawnReason){
        if (pSpawnReason==MobSpawnType.NATURAL){
            // check if spawn reasons
            // for example
            // return (ProgressManager.eldritchPortalOpen())
            // System.out.println("Natural spawn");

        }
        return true;
    }
}
