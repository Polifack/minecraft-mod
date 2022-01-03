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

import static com.poli.blocks.ModBlocks.MOD_ORE_VEIN;
import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

public class ModOreGeneration {

    // Create the list of ores PlacedFeatures that will be linked to generation
    public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();

    public static void registerOres(){
        // Declare vein size
        // this means that every time the ore is generated AT MOST <vein_size> will be generated
        int MOD_ORE_VEIN_SIZE = 16; // max 64

        // Declare generation retries
        // this is the number of atempts that our ore will try to be generated in each chunk
        int MOD_ORE_GEN_RETRIES = 5;  // max 256

        // Declare replaceable blocks using a list of TargetBlockStates
        // TargetBlockStates are composed by a RuleTest and a Block
        OreConfiguration.TargetBlockState MOD_ORE_REPLACE_STONE =
                OreConfiguration.target(STONE_ORE_REPLACEABLES, MOD_ORE_VEIN.get().defaultBlockState());

        List<OreConfiguration.TargetBlockState> MOD_ORE_VEIN_TARGETS = List.of
                (
                        MOD_ORE_REPLACE_STONE
                );

        // Create the Ore Configuration
        // OreConfiguration are defined by the TargetBlockState and the VeinSize
        OreConfiguration MOD_ORE_VEIN_GEN_CONFIG = new OreConfiguration(
                MOD_ORE_VEIN_TARGETS,
                MOD_ORE_VEIN_SIZE);


        // Add the feature to the register and place it into the built-in register
        // We have to add it to the built in register instead of defered-registers
        // Create placement of the vein
        // To do this we use <OreConfiguration>.placed(<Placement_Modifier>)
        // Placement modifiers are like the rule tests.
        // To see the disponible tests go to PlacementModifier class and see implementations

        String feature_name = "mod_ore_vein";
        PlacedFeature MOD_ORE_VEIN_GEN_PLACED =
                BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE,
                        new ResourceLocation(feature_name), Feature.ORE.configured(MOD_ORE_VEIN_GEN_CONFIG)).placed(
                        CountPlacement.of(MOD_ORE_GEN_RETRIES),
                        BiomeFilter.biome(),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(200))
                );

        // Add the ore generation feature to the feature list
        OVERWORLD_ORES.add(PlacementUtils.register(feature_name, MOD_ORE_VEIN_GEN_PLACED));
    }
}
