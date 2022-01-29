package com.poli.blocks;

import com.poli.blocks.custom.MimicBlock;
import com.poli.blocks.custom.QuicksandBlock;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.blocks.ModBlocksProperties.*;
import static com.poli.main.ZurrudiumMod.MODID;

public class ModBlocks
{
    public static final DeferredRegister<Block> DR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> ZURRUDIUM_ORE =
            DR_BLOCKS.register("zurrudium_ore", ()->new Block(ZURRUDIUM_ORE_PROPERTIES));

    public static final RegistryObject<Block> QUICKSAND_BLOCK =
            DR_BLOCKS.register("quicksand_block", ()->new QuicksandBlock(QUICKSAND_BLOCK_PROPERTIES));

    public static final RegistryObject<MimicBlock> MIMIC_BLOCK =
            DR_BLOCKS.register("mimic_block", ()->new MimicBlock(MIMIC_BLOCK_PROPERTIES));
}
