package com.poli.blocks.custom.blockEntity;

import com.poli.entity.custom.MimicEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;
import net.minecraftforge.common.extensions.IForgeBlockEntity;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import java.util.Objects;

import static com.poli.blocks.ModBlockEntities.MIMIC_BE;
import static com.poli.entity.ModEntityType.MIMIC;

public class MimicBE extends BlockEntity implements IForgeBlockEntity {

    public static ModelProperty<BlockState> IMITATING_BLOCK = new ModelProperty<>();

    private final Vec3 blockWorldPosition;
    private final BlockPos worldPosition;

    private BlockState imitatingBlock;


    // Block initialization
    public MimicBE(BlockPos pWorldPosition, BlockState pBlockState) {
        super(MIMIC_BE.get(), pWorldPosition, pBlockState);

        blockWorldPosition=new Vec3(pWorldPosition.getX(), pWorldPosition.getY(), pWorldPosition.getZ());
        worldPosition=pWorldPosition;
    }

    public BlockState getNeighbour(Level worldIn, BlockPos pPos) {
        BlockState bs = worldIn.getBlockState(pPos.below());
        return bs;
    }

    // The getUpdateTag()/handleUpdateTag() pair is called whenever the client receives a new chunk
    // it hasn't seen before. i.e. the chunk is loaded

    @Override
    public @NotNull CompoundTag getUpdateTag() {

        // GetUpdateTag -> Save function
        // this is called whenever we create a ClientBoundBlockEntityDataPacket

        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {

        // GetUpdateTag -> Load function

        if (tag != null) {
            load(tag);
        }
    }

    // The getUpdatePacket()/onDataPacket() pair is used when a block update happens on the client
    // (a blockState change or an explicit notification of a block update from the server)

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {

        // getUpdatePacket -> Save the update packet

        if (level!=null && (imitatingBlock == null)) {
            // If we have level and no imitatingBlock then get imitatingBlock
            imitatingBlock=getNeighbour(level, worldPosition);
            System.out.println(imitatingBlock);
        }

        // create a new packet based on this class
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {

        // onDataPacket -> Load a data packet
        // Retrieve imitating block from tag

        imitatingBlock=NbtUtils.readBlockState(pkt.getTag().getCompound("imitatingBlock"));
        ModelDataManager.requestModelDataRefresh(this);
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    // Load and save current imitating block
    // To load and save block states we use tags. Tags are loaded by
    // onDataPacket and onUpdateTag functions

    @Override
    protected void saveAdditional(CompoundTag tag) {
        // Save the imitating block in a tag
        tag.put("imitatingBlock", NbtUtils.writeBlockState(imitatingBlock));
        //tag.put("mimicEntityHealth", NbtUtils. mimicEntityHealth)
    }
    @Override
    public void load(CompoundTag tag) {
        // Load the imitating block from tag
        super.load(tag);
        imitatingBlock = NbtUtils.readBlockState(tag.getCompound("imitatingBlock"));
    }

    @Override
    public IModelData getModelData(){
        // Retrieve the model data.
        // This is called from the ModelDataManager
        IModelData imitatingBlockModelData = new ModelDataMap.Builder()
                .withInitial(IMITATING_BLOCK, imitatingBlock)
                .build();
        return imitatingBlockModelData;
    }


    @Override
    public void requestModelDataUpdate() {
        // Request to the model manager the update of the model data

        if (level != null && level.isClientSide) {
            // Check that the model request is done in the client level
            // during block load level = server
            // during normal gameplay level = client

            ModelDataManager.requestModelDataRefresh(this);
        }
    }

    public void tickClient(Level pLevel, BlockPos pPos){
        //
    }

    public void tickServer(Level worldIn, int mimicCurrentHP){
        // Tick behaviour of the block
        float trackDistance = 2f;
        boolean isNearPlayer = worldIn.hasNearbyAlivePlayer(blockWorldPosition.x, blockWorldPosition.y,
                blockWorldPosition.z, trackDistance);
        if (!isNearPlayer) return;
        try
        {
            // get spawn world position and spawn mimic
            BlockPos spawnPos = worldPosition.above();
            MimicEntity generatedMimic = (MimicEntity) MIMIC.get().spawn((ServerLevel)worldIn,
                    null,
                    null,
                    spawnPos,
                    MobSpawnType.TRIGGERED,
                    false,
                    false);

            // set hp
            generatedMimic.setHealth(mimicCurrentHP);
            worldIn.destroyBlock(worldPosition,false);
        }
        catch (NullPointerException e){
            //System.out.println("Nearby Player found, but no target position");
        }
    }

}
