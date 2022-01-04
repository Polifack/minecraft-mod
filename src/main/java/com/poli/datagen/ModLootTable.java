package com.poli.datagen;

import net.minecraft.data.DataGenerator;

import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;
import static com.poli.items.ModItems.ZURRUDIUM_RAW;

public class ModLootTable extends BaseLootTableProvider {
    public ModLootTable(DataGenerator _gen) {
        super(_gen);
    }

    @Override
    public void addTables(){
        // Loot tables allow for a block to drop an item when broken
        // to register the ore we use an auxiliary function declared in BaseLootTableProvider
        // that allows us to declare silk touch
        lootTables.put(ZURRUDIUM_ORE.get(), createSilkTouchTable("mod_ore_overworld",
                ZURRUDIUM_ORE.get(), ZURRUDIUM_RAW.get(), 1, 5));
    }
}
