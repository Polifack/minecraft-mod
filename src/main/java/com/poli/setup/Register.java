package com.poli.setup;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.poli.blocks.ModBlockEntities.DR_BLOCK_ENTITIES;
import static com.poli.blocks.ModBlocks.DR_BLOCKS;
import static com.poli.client.ModSoundEvents.DR_SOUND_EVENTS;
import static com.poli.entity.ModEntityType.DR_ENTITY;
//import static com.poli.entity.ModEntityType.RegisterSpawns;
import static com.poli.items.ModItems.DR_ITEMS;

public class Register {

    public static void init(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register deferred registers from items and blocks
        DR_BLOCKS.register(eventBus);
        DR_ITEMS.register(eventBus);
        DR_ENTITY.register(eventBus);
        DR_BLOCK_ENTITIES.register(eventBus);
        DR_SOUND_EVENTS.register(eventBus);

        //RegisterSpawns();
    }
}
