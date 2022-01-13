package com.poli.blocks;

import com.poli.blocks.custom.blockEntity.MimicBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.blocks.ModBlocks.MIMIC_BLOCK;
import static com.poli.main.ZurrudiumMod.MODID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> DR_BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

    public static final RegistryObject<BlockEntityType<MimicBE>> MIMIC_BE =
            DR_BLOCK_ENTITIES.register("mimic_block",
                    () -> BlockEntityType.Builder.of(MimicBE::new, MIMIC_BLOCK.get()).build(null));
}
