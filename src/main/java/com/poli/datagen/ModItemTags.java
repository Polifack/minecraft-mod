package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModItemTags extends ItemTagsProvider {
    ModItemTags(DataGenerator gen, BlockTagsProvider bt, ExistingFileHelper fh){ super(gen, bt, TutorialMod.MODID, fh);}

    @Override
    protected void addTags(){
        // Register the items as a ore or ingot etc to allow filtering in other mods
        tag(Tags.Items.ORES)
                .add(Register.MOD_ORE_OVERWORLD_ITEM.get());

        tag(Tags.Items.INGOTS)
                .add(Register.MOD_ORE_INGOT.get());

        // Also, register them with a custom tag
        tag(Register.MOD_ORE_ITEM)
                .add(Register.MOD_ORE_OVERWORLD_ITEM.get())
                .add(Register.MOD_ORE_INGOT.get());
    }
    @Override
    public @NotNull String getName(){return "Tutorial Mod Tags";}
}
