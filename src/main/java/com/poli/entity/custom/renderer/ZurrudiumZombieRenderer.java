package com.poli.entity.custom.renderer;

import com.poli.entity.custom.ZurrudiumZombieEntity;
import com.poli.entity.custom.models.ZurrudiumZombieModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.poli.main.ZurrudiumMod.MODID;

public class ZurrudiumZombieRenderer extends HumanoidMobRenderer<ZurrudiumZombieEntity, ZurrudiumZombieModel> {
    public ZurrudiumZombieRenderer(EntityRendererProvider.Context context){
        super(context,
                new ZurrudiumZombieModel(context.bakeLayer(ZurrudiumZombieModel.ZURRUDIUM_ZOMBIE_LAYER)),1f);

    }

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(MODID, "textures/entity/zurrudium_zombie.png");


    @Override
    public @NotNull ResourceLocation getTextureLocation (ZurrudiumZombieEntity entity){return TEXTURE;}

}
