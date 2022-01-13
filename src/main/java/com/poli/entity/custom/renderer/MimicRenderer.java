package com.poli.entity.custom.renderer;

import com.poli.entity.custom.MimicEntity;
import com.poli.entity.custom.models.MimicModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Endermite;

import static com.poli.entity.custom.models.MimicModel.MIMIC_MODEL_LAYER;

public class MimicRenderer extends MobRenderer<MimicEntity, MimicModel> {
    public MimicRenderer(EntityRendererProvider.Context context) {
        super(context, new MimicModel(context.bakeLayer(MIMIC_MODEL_LAYER)), 0.3F);
    }

    protected float getFlipDegrees(Endermite pLivingEntity) {
        return 180.0F;
    }

    @Override
    public ResourceLocation getTextureLocation(MimicEntity pEntity) {
        return new ResourceLocation("textures/entity/endermite.png");
    }
}
