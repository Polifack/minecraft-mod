package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import static com.poli.items.ModItems.*;
import static com.poli.items.ModItemsTags.ZURRUDIUM_ITEM;

public class ModItemTags extends ItemTagsProvider {
    ModItemTags(DataGenerator gen, BlockTagsProvider bt, ExistingFileHelper fh){ super(gen, bt, ZurrudiumMod.MODID, fh);}

    @Override
    protected void addTags(){
        // Register the items as a ore or ingot etc to allow filtering in other mods
        tag(Tags.Items.ORES)
                .add(ZURRUDIUM_ORE.get());

        tag(Tags.Items.INGOTS)
                .add(ZURRUDIUM_INGOT.get());


        // Also, register them with a custom tag
        tag(ZURRUDIUM_ITEM)
                .add(ZURRUDIUM_ORE.get())
                .add(ZURRUDIUM_INGOT.get())
                .add(ZURRUDIUM_SWORD.get())
                .add(ZURRUDIUM_AXE.get())
                .add(ZURRUDIUM_SHOVEL.get())
                .add(ZURRUDIUM_HOE.get())
                .add(ZURRUDIUM_PICKAXE.get())
                .add(ZURRUDIUM_HELMET.get())
                .add(ZURRUDIUM_ZOMBIE_SPAWN.get())
                .add(MIMIC_SPAWN.get());
    }
    @Override
    public @NotNull String getName(){return "Tutorial Mod Tags";}
}
