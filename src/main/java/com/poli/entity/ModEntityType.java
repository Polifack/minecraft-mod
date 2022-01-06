package com.poli.entity;

import com.poli.entity.custom.ZurrudiumZombieEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.main.ZurrudiumMod.MODID;

public class ModEntityType {

    // Create the defered register
    public static DeferredRegister<EntityType<?>> DR_ENTITY =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    // Register the entities in the register
    // .sized(x,y) is the mob hitbox
    public static final RegistryObject<EntityType<ZurrudiumZombieEntity>> ZURRUDIUM_ZOMBIE = DR_ENTITY.register(
            "zurrudium_zombie", () -> EntityType.Builder.of(
                    ZurrudiumZombieEntity::new,
                            MobCategory.MONSTER)
            .sized(1.5f, 2f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("zurrudium_zombie"));

}
