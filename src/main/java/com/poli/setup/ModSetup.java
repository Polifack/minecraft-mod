package com.poli.setup;

import com.poli.entity.custom.MimicEntity;
import com.poli.entity.custom.ZurrudiumZombieEntity;
import com.poli.world.ModCustomWorldGeneration;
import com.poli.world.ModEntityGeneration;
import com.poli.world.ModOreGeneration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

import static com.poli.entity.ModEntityType.MIMIC;
import static com.poli.entity.ModEntityType.ZURRUDIUM_ZOMBIE;
import static com.poli.items.ModItems.ZURRUDIUM_INGOT;
import static com.poli.main.ZurrudiumMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    // Creative mode tab wherever our mod items will be shown
    public static final String TAB_NAME = "zurrudium_mod";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ZURRUDIUM_INGOT.get());
        }
    };

    public static void setup() {
        // Link INTERNAL_SERVER needs to the forge event bus
        IEventBus bus = MinecraftForge.EVENT_BUS;

        // Set the listener for the biome registration to our custom generator
        bus.addListener(ModCustomWorldGeneration::onBiomeLoadingEvent);
        bus.addListener(ModEntityGeneration::onEntitySpawn);
    }


    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event){
        event.put(ZURRUDIUM_ZOMBIE.get(), ZurrudiumZombieEntity.createAttributes().build());
        event.put(MIMIC.get(), MimicEntity.createAttributes().build());
    }

    // Function to be called whenever a FMLCommonSetupEvent is detected
    // we must add this to FML ModBus
    public static void init(FMLCommonSetupEvent event){
        // Common Setup Event is the first event to be launched during startup
        // World generation stuff must be hooked here

        // add work to do during the minecraft load
        event.enqueueWork(ModOreGeneration::registerOres);
    }
}
