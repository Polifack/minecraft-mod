package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.poli.items.ModItems.*;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(DataGenerator gen, ExistingFileHelper fh){super(gen, TutorialMod.MODID, fh);}

    @Override
    protected void registerModels(){
        // register the model for the ore
        // we use withExistingParent because we are inheriting from other object
        withExistingParent(MOD_ORE_VEIN_ITEM.get()
                .getRegistryName().getPath(), modLoc("block/mod_ore_vein"));

        // register the model for the chunk and ingot
        // se use singleTexture because the block will be a simple image
        // singleTexture( <item_name in registryitem>, <parent location, usually a minecraft item>,
        //                  <texture key?>, <mod_location>)

        // Set textures for chunk / ingot
        singleTexture(MOD_ORE_CHUNK.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/mod_ore_chunk"));
        singleTexture(MOD_ORE_INGOT.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/mod_ore_ingot"));

        // Set textures for armor worn
        // withExistingParent(MOD_ORE_HELMET.get().getRegistryName().getPath(),modLoc("models/armor"));

        // Set textures for tools
        singleTexture(MOD_ORE_SWORD.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_sword"));
        singleTexture(MOD_ORE_PICKAXE.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_pickaxe"));
        singleTexture(MOD_ORE_SHOVEL.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_shovel"));
        singleTexture(MOD_ORE_HOE.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_hoe"));
        singleTexture(MOD_ORE_AXE.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_axe"));

        // set textures for armor items
        singleTexture(MOD_ORE_HELMET.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_helmet"));
        singleTexture(MOD_ORE_CHESTPLATE.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_chestplate"));
        singleTexture(MOD_ORE_LEGGINGS.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_leggings"));
        singleTexture(MOD_ORE_BOOTS.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/mod_ore_boots"));

    }
}
