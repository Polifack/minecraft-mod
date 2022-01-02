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
        tag(Tags.Items.ORES).add(Register.TUTORIAL_ORE_ITEM.get());
    }
    @Override
    public @NotNull String getName(){return "Tutorial Mod Tags";}
}
