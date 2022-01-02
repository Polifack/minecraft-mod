package com.poli.datagen;

import com.poli.setup.Register;
import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModBlocksTags extends BlockTagsProvider {
    ModBlocksTags(DataGenerator gen, ExistingFileHelper fh){super(gen, TutorialMod.MODID, fh);}

    @Override
    protected void addTags(){
        // Vanilla Minecraft Tagging
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Register.TUTORIAL_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(Register.TUTORIAL_ORE.get());

        // Forge Tagging
        tag(Tags.Blocks.ORES).add(Register.TUTORIAL_ORE.get());
    }

    @Override
    public @NotNull String getName(){return "Tutorial Mod Tags";}
}
