package com.poli.entity.custom.models;

import com.poli.entity.custom.MimicEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.poli.main.ZurrudiumMod.MODID;

public class MimicModel extends HierarchicalModel<MimicEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation MIMIC_MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(MODID, "mimic_model"), "main");
    private final ModelPart root;

    public MimicModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public ModelPart root() {
        return this.root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(11, 19).addBox(1.0F, -2.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(3.0F, -2.5F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 1).addBox(1.0F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 19).addBox(0.0F, -2.5F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(2.0F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-1.0F, -0.5F, 2.5F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -1.5F, -0.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(9, 10).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.5F, -1.5F));

        PartDefinition back = root.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back_left = back.addOrReplaceChild("back_left", CubeListBuilder.create()
                .texOffs(12, 0).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 10).addBox(1.5F, -0.5F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 14).addBox(0.5F, -0.5F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 16).addBox(2.5F, 0.5F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.5F, 2.5F));

        PartDefinition back_right = back.addOrReplaceChild("back_right", CubeListBuilder.create()
                .texOffs(14, 6).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 2).addBox(-2.5F, -0.5F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-2.5F, -0.5F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, 0.5F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -2.5F, 2.5F));

        PartDefinition front = root.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition front_right = front.addOrReplaceChild("front_right", CubeListBuilder.create()
                .texOffs(4, 14).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-1.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(17, 3).addBox(-2.5F, -0.5F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 16).addBox(-2.5F, 0.5F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -2.5F, -2.0F));

        PartDefinition front_left = front.addOrReplaceChild("front_left", CubeListBuilder.create()
                .texOffs(15, 8).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 14).addBox(0.0F, -0.5F, -1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 17).addBox(1.0F, 0.5F, -3.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 16).addBox(1.0F, -0.5F, -2.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.5F, -2.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


    /**
     * Sets this entity's model rotation angles
     */
    public void setupAnim(MimicEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}


