package com.poli.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.main.ZurrudiumMod.MODID;

public class ModSoundEvents {
    // load sound events in the deferred register. sounds must already be generated by ModSounds and data gen

    public static final DeferredRegister<SoundEvent> DR_SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> MIMIC_HURT =
            DR_SOUND_EVENTS.register(
                    "mimic_hurt",
                    ()->new SoundEvent(new ResourceLocation(MODID, "mimic_hurt")));

    public static final RegistryObject<SoundEvent> MIMIC_DEATH =
            DR_SOUND_EVENTS.register(
                    "mimic_death",
                    ()->new SoundEvent(new ResourceLocation(MODID, "mimic_death")));

    public static final RegistryObject<SoundEvent> MIMIC_AMBIENT =
            DR_SOUND_EVENTS.register(
                    "mimic_ambient",
                    ()->new SoundEvent(new ResourceLocation(MODID, "mimic_ambient")));

}
