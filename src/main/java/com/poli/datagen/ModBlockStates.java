package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(DataGenerator gen, ExistingFileHelper fh) {super(gen, TutorialMod.MODID, fh);}

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Register.MOD_ORE_OVERWORLD.get());
    }
}
