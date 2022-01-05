package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.poli.blocks.ModBlocks.QUICKSAND_BLOCK;
import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(DataGenerator gen, ExistingFileHelper fh) {super(gen, ZurrudiumMod.MODID, fh);}

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ZURRUDIUM_ORE.get());
        simpleBlock(QUICKSAND_BLOCK.get());
    }
}
