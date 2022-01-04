package com.poli.datagen;

import com.poli.main.ZurrudiumMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;

public class ModBlocksTags extends BlockTagsProvider {
    ModBlocksTags(DataGenerator gen, ExistingFileHelper fh){super(gen, ZurrudiumMod.MODID, fh);}

    @Override
    protected void addTags(){
        // Vanilla Minecraft Tagging
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ZURRUDIUM_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ZURRUDIUM_ORE.get());

        // Forge Tagging
        tag(Tags.Blocks.ORES).add(ZURRUDIUM_ORE.get());

        // Custom Tagging
        tag(com.poli.blocks.ModBlocksTags.ZURRUDIUM_ORE).add(ZURRUDIUM_ORE.get());
    }

    @Override
    public @NotNull String getName(){return "Zurrudium Mod Tags";}
}
