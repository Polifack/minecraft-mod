package com.poli.entity.custom;

import com.poli.blocks.custom.MimicBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import static com.poli.blocks.ModBlocks.MIMIC_BLOCK;
import static com.poli.client.ModSoundEvents.*;

import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class MimicEntity extends Monster {
    public static int max_health = 10;
    public static double follow_range = 40;
    public static double movement_speed = 0.5;
    public static double attack_damage = 4;
    public static double armor_value = 0;
    public static double attack_knockback = 1;
    public static double armor_toughness = 1;

    public static int spawn_height = 60;

    public static final int xp_reward = 10;

    private boolean has_attacked = false;

    public MimicEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
    public static AttributeSupplier.Builder createAttributes() {
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

    public boolean hasAttacked(){
        return has_attacked;
    }
    public void setAttacked(boolean value){
        has_attacked=value;
    }


    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    protected SoundEvent getAmbientSound() {
        return MIMIC_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return MIMIC_DEATH.get();
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {return MIMIC_HURT.get();}

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }
    protected int getExperienceReward(Player pPlayer){return xp_reward;}

    public static boolean checkSpawnHeight(BlockPos pPos, MobSpawnType pReason){
        if (!pReason.equals(MobSpawnType.NATURAL)) return true;
        else return (pPos.getY()<spawn_height);
    }

    public static boolean spawnConditions(EntityType<? extends Monster> pType, ServerLevelAccessor pLevel,
                                                 MobSpawnType pReason, BlockPos pPos, Random pRandom) {
        return pLevel.getDifficulty() != Difficulty.PEACEFUL
                && isDarkEnoughToSpawn(pLevel, pPos, pRandom)
                && checkMobSpawnRules(pType, pLevel, pReason, pPos, pRandom)
                && checkSpawnHeight(pPos, pReason);
    }

    public void tick() {
        this.yBodyRot = this.getYRot();
        super.tick();
    }
    public void setYBodyRot(float pOffset) {
        this.setYRot(pOffset);
        super.setYBodyRot(pOffset);
    }
    protected void registerGoals(){
        this.goalSelector.addGoal(2, new MimicAttackGoal(this, 2.0D,
                true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class,
                true));
        this.goalSelector.addGoal(1, new MimicHideGoal(this, 3.0D));
    }

    static class MimicHideGoal extends Goal{
        @Nullable
        private Direction selectedDirection;
        private boolean doHide;

        protected final MimicEntity mimicMob;
        protected final double speedModifier;
        protected double posX;
        protected double posY;
        protected double posZ;
        protected boolean isRunning;

        public MimicHideGoal(MimicEntity mimicEntity, double pSpeedModifier) {
            this.mimicMob = mimicEntity;
            this.speedModifier = pSpeedModifier;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return (mimicMob.hasAttacked());
        }

        protected void findRandomPosition() {
            //Vec3 vec3 = DefaultRandomPos.getPos(mimicMob, 20, 4);
            LivingEntity targetEntity = mimicMob.level.getNearestPlayer(TargetingConditions.DEFAULT,
                    mimicMob, mimicMob.getX(), mimicMob.getEyeY(), mimicMob.getZ());

            if (targetEntity==null) return;

            Vec3 vec3 = DefaultRandomPos.getPosAway(mimicMob,24, 1, targetEntity.position());

            if (vec3 != null) {
                double d = vec3.distanceToSqr(posX, posY, posZ);

                posX = vec3.x;
                posY = vec3.y;
                posZ = vec3.z;
            }
        }

//        private boolean isValidBlock(Block b){
//          should return whenever the block is a BLOCK that has no state or something like that
//          for example, ladders, doors, etc wont be valid
//        }

        public void tick(){
            if (mimicMob.getNavigation().isDone()){
                // Get level and position where the mimicBlock should spawn

                Level currentLevel = mimicMob.level;
                BlockPos currentBlockPos = mimicMob.blockPosition();

                // Set the mimic hp in the mimicBlock
                // the correct way to do this is
                // PlacementContext pc = new PlacementContext(mimicMob.level, chunk, PlacementFeature.hp)
                // we are changing the mimicblock currenthp value in memory, and that is wrong
                // currently is done by whenever the entity dies we restore the value to max_hp
                // but if two mimics are alive this gets messy

                int mimicCurrentHP=(int) mimicMob.getHealth();

                MimicBlock currentMimicBlock = MIMIC_BLOCK.get();
                currentMimicBlock.setMimicHp(mimicCurrentHP);
                BlockState blockState=currentMimicBlock.getStateForPlacement(null);
                currentLevel.setBlock(currentBlockPos, blockState, 3);

                // Destroy the current mimicEntity
                mimicMob.discard();
            }
        }

        public void start() {
            findRandomPosition();
            mimicMob.getNavigation().moveTo(posX, posY, posZ, speedModifier);
            isRunning = true;
        }
    }

    static class MimicAttackGoal extends Goal {

        Path path;
        MimicEntity mimicMob;
        double speedModifier;
        boolean followingTargetEvenIfNotSeen;


        public MimicAttackGoal(MimicEntity pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
            this.mimicMob = pMob;
            this.speedModifier = pSpeedModifier;
            this.followingTargetEvenIfNotSeen = pFollowingTargetEvenIfNotSeen;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }
        @Override
        public boolean canUse() {
            if (mimicMob.hasAttacked()) return false;
            else{
                // get our attack target
                LivingEntity targetEntity = this.mimicMob.getTarget();
                // check if it exists or if it is alive
                if (targetEntity == null) {
                    return false;
                } else if (!targetEntity.isAlive()) {
                    return false;
                }
                else{
                    this.path = this.mimicMob.getNavigation().createPath(targetEntity, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.getAttackReachSqr(targetEntity) >=
                                this.mimicMob.distanceToSqr(targetEntity.getX(), targetEntity.getY(), targetEntity.getZ());
                    }
                }
            }
        }
        private double getAttackReachSqr(LivingEntity pAttackTarget) {
            return (double)(this.mimicMob.getBbWidth() * 2.0F * this.mimicMob.getBbWidth() * 2.0F + pAttackTarget.getBbWidth());
        }
        public void tick() {
            LivingEntity targetEntity = mimicMob.level.getNearestPlayer(TargetingConditions.DEFAULT,
                    mimicMob, mimicMob.getX(), mimicMob.getEyeY(), mimicMob.getZ());
            if (targetEntity != null) {
                this.mimicMob.getLookControl().setLookAt(targetEntity, 30.0F, 30.0F);
                double distanceToTarget = this.mimicMob.distanceToSqr(targetEntity.getX(), targetEntity.getY(), targetEntity.getZ());
                if ((this.followingTargetEvenIfNotSeen || this.mimicMob.getSensing().hasLineOfSight(targetEntity))){
                    this.mimicMob.getNavigation().moveTo(targetEntity, this.speedModifier);
                }
                this.checkAndPerformAttack(targetEntity, distanceToTarget);
            }
        }
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            double attackRange = this.getAttackReachSqr(pEnemy);
            if (pDistToEnemySqr <= attackRange){
                mimicMob.swing(InteractionHand.MAIN_HAND);
                mimicMob.doHurtTarget(pEnemy);
                mimicMob.setAttacked(true);
            }
        }
    }
}
