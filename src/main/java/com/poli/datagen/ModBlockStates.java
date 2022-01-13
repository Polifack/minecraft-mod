package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.poli.blocks.ModBlockEntities.MIMIC_BE;
import static com.poli.blocks.ModBlocks.*;
import static com.poli.client.modelload.MimicBlockML.MIMIC_ML;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(DataGenerator gen, ExistingFileHelper fh) {super(gen, ZurrudiumMod.MODID, fh);}

    // register simple blocks that are the same texture by the 6 sides
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ZURRUDIUM_ORE.get());
        simpleBlock(QUICKSAND_BLOCK.get());

        registerMimicBlock();
    }

    // here we have to register states and models for custom blocks that change texture

    private void registerMimicBlock() {
        BlockModelBuilder mimicModel = models().getBuilder(MIMIC_BLOCK.get().getRegistryName().getPath())
                .parent(models().getExistingFile(mcLoc("cube")))
                .customLoader((blockModelBuilder, helper) ->
                        new CustomLoaderBuilder<BlockModelBuilder>(MIMIC_ML, blockModelBuilder, helper) { })
                .end();
        directionalBlock(MIMIC_BLOCK.get(), mimicModel);
    }

}
