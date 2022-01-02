package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.poli.setup.ModSetup.TAB_NAME;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String loc){super(gen, TutorialMod.MODID, loc);}

    @Override
    protected void addTranslations() {
        add("itemGroup."+TAB_NAME, "Tutorial Mod");

        add(Register.MOD_ORE_OVERWORLD.get(), "Mod Ore");
        add(Register.MOD_ORE_INGOT.get(), "Mod Ore Ingot");
        add(Register.MOD_ORE_CHUNK.get(), "Mod Ore Chunk");
    }
}
