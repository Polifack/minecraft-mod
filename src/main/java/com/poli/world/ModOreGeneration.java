package com.poli.world;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.ArrayList;
import java.util.List;

import static com.poli.blocks.ModBlocks.MIMIC_BLOCK;
import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;
import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

public class ModOreGeneration {

    // Create the list of ores PlacedFeatures that will be linked to generation
    public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();

    public static void registerOre(OreConfiguration oreConfiguration,int retries, String featureName, int min, int max){
        OVERWORLD_ORES.add(PlacementUtils.register(featureName,
                BuiltinRegistries.register(
                    BuiltinRegistries.CONFIGURED_FEATURE,
                    new ResourceLocation(featureName), Feature.ORE.configured(oreConfiguration)).placed(
                        CountPlacement.of(retries),
                    BiomeFilter.biome(),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max))
        )));
    }

    public static void registerOres(){
        // OreConfiguration are defined by the TargetBlockState and the VeinSize
        OreConfiguration zurrudiumGenConfig = new OreConfiguration(
                List.of(
                        OreConfiguration.target(STONE_ORE_REPLACEABLES, ZURRUDIUM_ORE.get().defaultBlockState())
                ),
                16
        );

        registerOre(zurrudiumGenConfig, 5, "zurrudium_vein", 0, 200);
    }
}
