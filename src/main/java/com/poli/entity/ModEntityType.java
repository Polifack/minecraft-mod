package com.poli.entity;

import com.poli.entity.custom.MimicEntity;
import com.poli.entity.custom.ZurrudiumZombieEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.main.ZurrudiumMod.MODID;

public class ModEntityType {

    // Create the defered register
    public static final DeferredRegister<EntityType<?>> DR_ENTITY =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    // Register the entities in the register
    // .sized(x,y) is the mob hitbox
    public static final RegistryObject<EntityType<ZurrudiumZombieEntity>> ZURRUDIUM_ZOMBIE = DR_ENTITY.register(
            "zurrudium_zombie", () -> EntityType.Builder.of(
                    ZurrudiumZombieEntity::new, MobCategory.MONSTER)
                    .sized(1.5f, 2f)
                    .clientTrackingRange(8)
                    .setShouldReceiveVelocityUpdates(false)
                    .build("zurrudium_zombie"));

    public static final EntityType<MimicEntity> MIMIC_ENTITY =EntityType.Builder.of(
                    MimicEntity::new, MobCategory.MONSTER)
            .sized(1f, 1f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("mimic");

    public static final RegistryObject<EntityType<MimicEntity>> MIMIC = DR_ENTITY.register(
            "mimic", () -> MIMIC_ENTITY);

}
