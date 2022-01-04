package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;
import static com.poli.items.ModItems.*;
import static com.poli.setup.ModSetup.TAB_NAME;

public class ModLanguageProvider extends LanguageProvider {

    String locale = "";

    public ModLanguageProvider(DataGenerator gen, String loc){
        super(gen, ZurrudiumMod.MODID, loc);
        this.locale=loc;
    }

    @Override
    protected void addTranslations() {
        add("itemGroup."+TAB_NAME, "Tutorial Mod");

        // Adds the translations for the locale defined

        if (this.locale.equals("en_us")){
            add(ZURRUDIUM_ORE.get(),    "Zurrudium Ore");
            add(ZURRUDIUM_INGOT.get(),   "Zurrudium Ingot");
            add(ZURRUDIUM_RAW.get(),   "Zurrudium Chunk");
            add(ZURRUDIUM_SWORD.get(),   "Zurrudium Sword");
            add(ZURRUDIUM_AXE.get(),     "Zurrudium Axe");
            add(ZURRUDIUM_SHOVEL.get(),  "Zurrudium Shovel");
            add(ZURRUDIUM_PICKAXE.get(), "Zurrudium Pickaxe");
            add(ZURRUDIUM_HOE.get(),     "Zurrudium Hoe");
            add(ZURRUDIUM_HELMET.get(), "Zurrudium Helmet");
            add(ZURRUDIUM_CHESTPLATE.get(), "Zurrudium Chestplate");
            add(ZURRUDIUM_LEGGINGS.get(), "Zurrudium Leggings");
            add(ZURRUDIUM_BOOTS.get(), "Zurrudium Boots");
            add(POISON_DAGGER.get(), "Poisonous Dagger");
            add(LIGHTNING_HAMMER.get(), "Lightning Hammer");
        }

        if (this.locale.equals("es_es")){
            add(ZURRUDIUM_ORE.get(),    "Mena de Zurrudium");
            add(ZURRUDIUM_INGOT.get(),   "Lingote de Zurrudium");
            add(ZURRUDIUM_RAW.get(),   "Zurrudium en bruto");
            add(ZURRUDIUM_SWORD.get(),   "Espada de Zurrudium");
            add(ZURRUDIUM_AXE.get(),     "Hacha de Zurrudium");
            add(ZURRUDIUM_SHOVEL.get(),  "Pala de Zurrudium");
            add(ZURRUDIUM_PICKAXE.get(), "Pico de Zurrudium");
            add(ZURRUDIUM_HOE.get(),     "Azada de Zurrudium");
            add(ZURRUDIUM_HELMET.get(), "Casco de Zurrudium");
            add(ZURRUDIUM_CHESTPLATE.get(), "Pechera de Zurrudium");
            add(ZURRUDIUM_LEGGINGS.get(), "Pantalones de Zurrudium");
            add(ZURRUDIUM_BOOTS.get(), "Botas de Zurrudium");
            add(POISON_DAGGER.get(), "Daga venenosa");
            add(LIGHTNING_HAMMER.get(), "Martillo del Rayo");
        }


    }
}
