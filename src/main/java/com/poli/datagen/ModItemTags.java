package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import static com.poli.items.ModItems.*;
import static com.poli.items.ModItemsTags.MOD_ORE_ITEM;

public class ModItemTags extends ItemTagsProvider {
    ModItemTags(DataGenerator gen, BlockTagsProvider bt, ExistingFileHelper fh){ super(gen, bt, TutorialMod.MODID, fh);}

    @Override
    protected void addTags(){
        // Register the items as a ore or ingot etc to allow filtering in other mods
        tag(Tags.Items.ORES)
                .add(MOD_ORE_VEIN_ITEM.get());

        tag(Tags.Items.INGOTS)
                .add(MOD_ORE_INGOT.get());

        // Also, register them with a custom tag
        tag(MOD_ORE_ITEM)
                .add(MOD_ORE_VEIN_ITEM.get())
                .add(MOD_ORE_INGOT.get())
                .add(MOD_ORE_SWORD.get())
                .add(MOD_ORE_AXE.get())
                .add(MOD_ORE_SHOVEL.get())
                .add(MOD_ORE_HOE.get())
                .add(MOD_ORE_PICKAXE.get())
                .add(MOD_ORE_HELMET.get());
    }
    @Override
    public @NotNull String getName(){return "Tutorial Mod Tags";}
}
