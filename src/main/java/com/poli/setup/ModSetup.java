package com.poli.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

public class ModSetup {

    // Creative mode tab wherever our mod items will be shown
    public static final String TAB_NAME = "modTutorial";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    // Function to be called whenever a FMLCommonSetupEvent is detected
    // we must add this to FML ModBus

    public static void init(FMLCommonSetupEvent event){

    }
}
