package com.poli.blocks.custom;

import com.poli.blocks.custom.blockEntity.MimicBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class MimicBlock extends Block implements EntityBlock {
    // create custom property for the blockState so it can store the mimic hp
    // note that: property names must be all lowercase
    public final static IntegerProperty MIMIC_HP = IntegerProperty.create("mimic_hp", 0, 100);
    private int mimicCurrentHP = 10;

    public MimicBlock(Properties properties) {

        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        // BlockEntity initialization
        return new MimicBE(pPos, pState);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level worldIn, BlockState state,
                                                                  BlockEntityType<T> type) {
        // Check this is running on server-side
        if (worldIn.isClientSide()) {
            return null;
        }

        return (lvl, pos, blockState, t) -> {
            if (t instanceof MimicBE entity) {
                entity.tickServer(lvl, mimicCurrentHP);
            }
        };
    }



    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult result){
        //Do interaction related stuff

        return InteractionResult.SUCCESS;
    }

    public void setMimicHp(int value){
        mimicCurrentHP=value;
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Initialize the properties for placing the block

        // for example if we want to set default facing_direction we set
        // return this.defaultBlockState().setValue(BlockStateProperties.FACING,
        //        context.getNearestLookingDirection().getOpposite());

        return defaultBlockState()
                .setValue(BlockStateProperties.FACING, Direction.DOWN)
                .setValue(MIMIC_HP, mimicCurrentHP);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        // Set the properties for the block
        // this could be stuff like
        // it is attached to something
        // facing direction
        // is powered
        // is facing a hopper
        // has redstone attached

        builder.add(BlockStateProperties.FACING);
        builder.add(MIMIC_HP);
        super.createBlockStateDefinition(builder);
    }
}
