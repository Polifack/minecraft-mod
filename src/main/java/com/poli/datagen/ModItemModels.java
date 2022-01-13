package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.poli.blocks.ModBlocks.QUICKSAND_BLOCK;
import static com.poli.items.ModItems.*;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(DataGenerator gen, ExistingFileHelper fh){super(gen, ZurrudiumMod.MODID, fh);}

    @Override
    protected void registerModels(){
        // register the model for the ore
        withExistingParent(ZURRUDIUM_ORE.get()
                .getRegistryName().getPath(), modLoc("block/zurrudium_ore"));

        // register model for quicksand
        withExistingParent(QUICKSAND_BLOCK.get().getRegistryName().getPath(),
                modLoc("block/quicksand_block"));

        // register model for mimic_block
        withExistingParent(MIMIC_BLOCK.get().getRegistryName().getPath(),
                modLoc("block/mimic_block"));

        // Set textures for chunk / ingot
        singleTexture(ZURRUDIUM_RAW.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/zurrudium_raw"));
        singleTexture(ZURRUDIUM_INGOT.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/zurrudium_ingot"));

        // Set textures for armor worn
        singleTexture(ZURRUDIUM_SWORD.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0",modLoc("item/zurrudium_sword"));
        singleTexture(ZURRUDIUM_PICKAXE.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0",modLoc("item/zurrudium_pickaxe"));
        singleTexture(ZURRUDIUM_SHOVEL.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0",modLoc("item/zurrudium_shovel"));
        singleTexture(ZURRUDIUM_HOE.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0",modLoc("item/zurrudium_hoe"));
        singleTexture(ZURRUDIUM_AXE.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0",modLoc("item/zurrudium_axe"));

        // set textures for armor items
        singleTexture(ZURRUDIUM_HELMET.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/zurrudium_helmet"));
        singleTexture(ZURRUDIUM_CHESTPLATE.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/zurrudium_chestplate"));
        singleTexture(ZURRUDIUM_LEGGINGS.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/zurrudium_leggings"));
        singleTexture(ZURRUDIUM_BOOTS.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0",modLoc("item/zurrudium_boots"));

        // custom item
        singleTexture(POISON_DAGGER.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0", modLoc("item/custom/poison_dagger"));
        singleTexture(LIGHTNING_HAMMER.get().getRegistryName().getPath(), mcLoc("item/handheld"),
                "layer0", modLoc("item/custom/lightning_hammer"));

        // spawn eggs
        withExistingParent(ZURRUDIUM_ZOMBIE_SPAWN.get().getRegistryName().getPath(),
                mcLoc("item/template_spawn_egg"));
        withExistingParent(MIMIC_SPAWN.get().getRegistryName().getPath(),
                mcLoc("item/template_spawn_egg"));
    }
}
