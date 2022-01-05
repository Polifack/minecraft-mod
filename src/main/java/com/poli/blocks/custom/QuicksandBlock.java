package com.poli.blocks.custom;

import java.util.Optional;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// Quicksand is copy of powder snow
public class QuicksandBlock extends Block {

    private static final float HORIZONTAL_PARTICLE_MOMENTUM_FACTOR = 0.083333336F;
    private static final float IN_BLOCK_HORIZONTAL_SPEED_MULTIPLIER = 0.9F;
    private static final float IN_BLOCK_VERTICAL_SPEED_MULTIPLIER = 1.5F;
    private static final float NUM_BLOCKS_TO_FALL_INTO_BLOCK = 2.5F;

    // making maxY 0.9 avoids player to climb to other blocks
    private static final VoxelShape FALLING_COLLISION_SHAPE =
            Shapes.box(0.0D, 0.0D, 0.0D, 1.0D, (double)0.9F, 1.0D);

    private static final double MINIMUM_FALL_DISTANCE_FOR_SOUND = 4.0D;
    private static final double MINIMUM_FALL_DISTANCE_FOR_BIG_SOUND = 7.0D;

    public QuicksandBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    // Overrides deprecated method. Not sure if needed
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
        return pAdjacentBlockState.is(this) ? true : super.skipRendering(pState, pAdjacentBlockState, pDirection);
    }

    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return Shapes.empty();
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {

        // check if entity is a mob
        if (!(pEntity instanceof LivingEntity) || pEntity.getFeetBlockState().is(this)) {

            // stuck entity in block with a motion multiplier vector
            pEntity.makeStuckInBlock(
                    pState,
                    new Vec3((double)0.5F, 0.5F, (double)0.5F));

            // particle effect in client
            if (pLevel.isClientSide) {
                Random random = pLevel.getRandom();
                boolean flag = pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ();
                if (flag && random.nextBoolean()) {
                    pLevel.addParticle(
                            ParticleTypes.SNOWFLAKE,
                            pEntity.getX(),
                            pPos.getY() + 1,
                            pEntity.getZ(),
                            Mth.randomBetween(random, -1.0F, 1.0F) * 0.083333336F,
                            0.05F,
                            Mth.randomBetween(random, -1.0F, 1.0F) * 0.083333336F);
                }
            }
        }

        //pEntity.setIsInPowderSnow(true);
    }

    // Called whenever entity falls in this block
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float fallDistance) {
        // if the entity falling is a living thing falling from height bigger than 4 blocks just play sound
        // no damage calculation
        if (fallDistance > 4.0 && entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            LivingEntity.Fallsounds entityFallSounds = livingEntity.getFallSounds();
            SoundEvent soundevent = fallDistance < 7.0 ? entityFallSounds.small() : entityFallSounds.big();
            entity.playSound(soundevent, 1.0F, 1.0F);
        }
    }

    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pContext instanceof EntityCollisionContext) {
            EntityCollisionContext entitycollisioncontext = (EntityCollisionContext)pContext;
            Entity entity = entitycollisioncontext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F) {
                    return FALLING_COLLISION_SHAPE;
                }

                boolean flag = entity instanceof FallingBlockEntity;
                if (flag || canEntityWalkOnQuicksand(entity) && pContext.isAbove(Shapes.block(), pPos, false) && !pContext.isDescending()) {
                    return super.getCollisionShape(pState, pLevel, pPos, pContext);
                }
            }
        }

        return Shapes.empty();
    }

    public VoxelShape getVisualShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.empty();
    }

    public static boolean canEntityWalkOnQuicksand(Entity pEntity) {
        //if (pEntity.getType().is(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS)) {
        //    return true;
        //} else {
            return pEntity instanceof LivingEntity ? ((LivingEntity)pEntity).getItemBySlot(EquipmentSlot.FEET).is(Items.LEATHER_BOOTS) : false;
        //}
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return true;
    }
}