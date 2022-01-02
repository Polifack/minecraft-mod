package com.poli.datagen;

import com.poli.setup.Register;
import net.minecraft.data.DataGenerator;

public class ModLootTable extends BaseLootTableProvider {
    public ModLootTable(DataGenerator _gen) {
        super(_gen);
    }

    @Override
    public void addTables(){
        // Loot tables allow for a block to drop an item when broken
        // to register the ore we use an auxiliary function declared in BaseLootTableProvider
        // that allows us to declare silk touch
        lootTables.put(Register.MOD_ORE_VEIN.get(), createSilkTouchTable("mod_ore_overworld",
                Register.MOD_ORE_VEIN.get(), Register.MOD_ORE_CHUNK.get(), 1, 5));
    }
}
