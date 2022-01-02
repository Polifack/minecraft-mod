package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(DataGenerator gen, ExistingFileHelper fh){super(gen, TutorialMod.MODID, fh);}

    @Override
    protected void registerModels(){
        withExistingParent(Register.TUTORIAL_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/mod_ore"));
    }
}
