package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.poli.blocks.ModBlocks.MOD_ORE_VEIN;
import static com.poli.items.ModItems.*;
import static com.poli.setup.ModSetup.TAB_NAME;

public class ModLanguageProvider extends LanguageProvider {

    String locale = "";

    public ModLanguageProvider(DataGenerator gen, String loc){
        super(gen, TutorialMod.MODID, loc);
        this.locale=loc;
    }

    @Override
    protected void addTranslations() {
        add("itemGroup."+TAB_NAME, "Tutorial Mod");

        // Adds the translations for the locale defined

        if (this.locale.equals("en_us")){
            add(MOD_ORE_VEIN.get(),    "Mod Ore");
            add(MOD_ORE_INGOT.get(),   "Mod Ore Ingot");
            add(MOD_ORE_CHUNK.get(),   "Mod Ore Chunk");
            add(MOD_ORE_SWORD.get(),   "Mod Ore Sword");
            add(MOD_ORE_AXE.get(),     "Mod Ore Axe");
            add(MOD_ORE_SHOVEL.get(),  "Mod Ore Shovel");
            add(MOD_ORE_PICKAXE.get(), "Mod Ore Pickaxe");
            add(MOD_ORE_HOE.get(),     "Mod Ore Hoe");
        }

        if (this.locale.equals("es_es")){
            add(MOD_ORE_VEIN.get(),    "Mineral del Mod");
            add(MOD_ORE_INGOT.get(),   "Lingote de Mineral del Mod");
            add(MOD_ORE_CHUNK.get(),   "Trozo del Mineral del Mod");
            add(MOD_ORE_SWORD.get(),   "Espada del Mineral del Mod");
            add(MOD_ORE_AXE.get(),     "Hacha del Mineral del Mod");
            add(MOD_ORE_SHOVEL.get(),  "Pala del Mineral del Mod");
            add(MOD_ORE_PICKAXE.get(), "Pico del Mineral del Mod");
            add(MOD_ORE_HOE.get(),     "Azada del Mineral del Mod");
        }


    }
}
