package com.poli.datagen;

import com.poli.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import static com.poli.blocks.ModBlocks.MOD_ORE_VEIN;
import static com.poli.blocks.ModBlocksTags.MOD_ORE;

public class ModBlocksTags extends BlockTagsProvider {
    ModBlocksTags(DataGenerator gen, ExistingFileHelper fh){super(gen, TutorialMod.MODID, fh);}

    @Override
    protected void addTags(){
        // Vanilla Minecraft Tagging
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(MOD_ORE_VEIN.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(MOD_ORE_VEIN.get());

        // Forge Tagging
        tag(Tags.Blocks.ORES).add(MOD_ORE_VEIN.get());

        // Custom Tagging
        tag(MOD_ORE).add(MOD_ORE_VEIN.get());
    }

    @Override
    public @NotNull String getName(){return "Tutorial Mod Tags";}
}
