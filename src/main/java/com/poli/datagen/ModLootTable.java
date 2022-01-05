package com.poli.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.LootTable;

import static com.poli.blocks.ModBlocks.QUICKSAND_BLOCK;
import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;
import static com.poli.items.ModItems.ZURRUDIUM_RAW;

public class ModLootTable extends BaseLootTableProvider {
    public ModLootTable(DataGenerator _gen) {
        super(_gen);
    }

    @Override
    public void addTables(){
        lootTables.put(ZURRUDIUM_ORE.get(), createSilkTouchTable("mod_ore_overworld",
                ZURRUDIUM_ORE.get(), ZURRUDIUM_RAW.get(), 1, 5));
        lootTables.put(QUICKSAND_BLOCK.get(), createBasicTable("quicksand_block", QUICKSAND_BLOCK.get()));
    }
}
