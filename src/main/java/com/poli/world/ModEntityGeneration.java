package com.poli.world;

import com.poli.entity.ModEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModEntityGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event){
        addEntityToAllBiomes(event.getSpawns(), ModEntityType.ZURRUDIUM_ZOMBIE.get()
                , 40, 1, 2);
    }

    public static void addEntityToAllBiomes(MobSpawnSettingsBuilder spawns, EntityType<?> type,
                                            int weight, int min, int max){
        MobCategory mobCat = type.getCategory();
        List<MobSpawnSettings.SpawnerData> base = spawns.getSpawner(mobCat);
        base.add(new MobSpawnSettings.SpawnerData(type, weight, min, max));
    }
}
