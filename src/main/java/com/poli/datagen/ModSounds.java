package com.poli.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import static com.poli.client.ModSoundEvents.*;
import static com.poli.main.ZurrudiumMod.MODID;
import static net.minecraftforge.common.data.SoundDefinition.*;

public class ModSounds extends SoundDefinitionsProvider {

    //datagen class for sounds

    protected ModSounds(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, MODID, helper);
    }

    @Override
    public void registerSounds() {
        // remark: /sounds/ is already implicit
        add(MIMIC_HURT.get(), definition().with(sound(
                new ResourceLocation(MODID, "mobs/mimic/mimic_hurt"),
                SoundType.SOUND)));

        add(MIMIC_DEATH.get(), definition().with(sound(
                new ResourceLocation(MODID, "mobs/mimic/mimic_death"),
                SoundType.SOUND)));

        add(MIMIC_AMBIENT.get(), definition().with(sound(
                new ResourceLocation(MODID, "mobs/mimic/mimic_ambient"),
                SoundType.SOUND)));
    }
}
