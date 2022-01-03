package com.poli.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import static com.poli.world.ModOreGeneration.OVERWORLD_ORES;


public class ModCustomWorldGeneration {

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {

        // This is launched during world generation. Event contains data such as
        // dimension, biome_size, weather...

        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            // nether generation
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
            // end generation
        } else {
            // overworld generation
            //event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OVERWORLD_MOD_ORE);
            for (PlacedFeature pf:OVERWORLD_ORES) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, pf);
            }
        }
    }
}
