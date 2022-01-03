package com.poli.datagen;

import com.poli.setup.Register;
import net.minecraft.data.DataGenerator;

import static com.poli.blocks.ModBlocks.MOD_ORE_VEIN;
import static com.poli.items.ModItems.MOD_ORE_CHUNK;

public class ModLootTable extends BaseLootTableProvider {
    public ModLootTable(DataGenerator _gen) {
        super(_gen);
    }

    @Override
    public void addTables(){
        // Loot tables allow for a block to drop an item when broken
        // to register the ore we use an auxiliary function declared in BaseLootTableProvider
        // that allows us to declare silk touch
        lootTables.put(MOD_ORE_VEIN.get(), createSilkTouchTable("mod_ore_overworld",
                MOD_ORE_VEIN.get(), MOD_ORE_CHUNK.get(), 1, 5));
    }
}
