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
        // register the model for the ore
        // we use withExistingParent because we are inheriting from other object
        withExistingParent(Register.MOD_ORE_VEIN_ITEM.get()
                .getRegistryName().getPath(), modLoc("block/mod_ore_vein"));

        // register the model for the chunk and ingot
        // se use singleTexture because the block will be a simple image
        // singleTexture( <item_name in registry>, <parent location, usually a minecraft item>,
        //                  <texture key?>, <mod_location>)

        singleTexture(Register.MOD_ORE_CHUNK.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/mod_ore_chunk"));
        singleTexture(Register.MOD_ORE_INGOT.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/mod_ore_ingot"));
        singleTexture(Register.MOD_ORE_SWORD.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_sword"));
    }
}
