package com.poli.world;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.ArrayList;
import java.util.List;

import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;
import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

public class ModOreGeneration {

    // Create the list of ores PlacedFeatures that will be linked to generation
    public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();



    public static void registerOres(){
        // Declare vein size
        // this means that every time the ore is generated AT MOST <vein_size> will be generated
        int zurrudium_vein_size = 16; // max 64

        // Declare generation retries
        // this is the number of atempts that our ore will try to be generated in each chunk
        int zurrudium_vein_retries = 5;  // max 256

        // Declare replaceable blocks using a list of TargetBlockStates
        // TargetBlockStates are composed by a RuleTest and a Block
        List<OreConfiguration.TargetBlockState> zurrudium_vein_targets = List.of
                (
                        OreConfiguration.target(STONE_ORE_REPLACEABLES, ZURRUDIUM_ORE.get().defaultBlockState())
                );

        // Create the Ore Configuration
        // OreConfiguration are defined by the TargetBlockState and the VeinSize
        OreConfiguration zurrudium_vein_gen_config = new OreConfiguration(
                zurrudium_vein_targets,
                zurrudium_vein_size);


        // Add the feature to the register and place it into the built-in register
        // We have to add it to the built in register instead of defered-registers
        // Create placement of the vein
        // To do this we use <OreConfiguration>.placed(<Placement_Modifier>)
        // Placement modifiers are like the rule tests.
        // To see the disponible tests go to PlacementModifier class and see implementations

        String feature_name = "zurrudium_vein";
        PlacedFeature zurrudium_vein_gen_placed =
                BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE,
                        new ResourceLocation(feature_name), Feature.ORE.configured(zurrudium_vein_gen_config)).placed(
                        CountPlacement.of(zurrudium_vein_retries),
                        BiomeFilter.biome(),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(200))
                );

        // Add the ore generation feature to the feature list
        OVERWORLD_ORES.add(PlacementUtils.register(feature_name, zurrudium_vein_gen_placed));
    }
}
