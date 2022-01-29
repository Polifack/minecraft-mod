package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ZurrudiumMod.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    // Subscribe to the data gathering event. This event is triggered on load so
    // when minecraft is loading this will be called and return our blocks data
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();

        // For the server (recipes, loot table and tags)
        if (event.includeServer()){
            ModBlocksTags blocksTags = new ModBlocksTags(generator, event.getExistingFileHelper());
            // Add the providers
            generator.addProvider(new ModRecipes(generator));
            generator.addProvider(new ModLootTable(generator));
            generator.addProvider(blocksTags);
            generator.addProvider(new ModItemTags(generator, blocksTags, event.getExistingFileHelper()));
            //generator.addProvider(new ModSounds(generator, event.getExistingFileHelper()));

        }
        // For the client (blocks, models, locale)
        if (event.includeClient()){
            generator.addProvider(new ModBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new ModItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new ModLanguageProvider(generator, "en_us"));
            generator.addProvider(new ModSounds(generator, event.getExistingFileHelper()));
        }
    }
}
