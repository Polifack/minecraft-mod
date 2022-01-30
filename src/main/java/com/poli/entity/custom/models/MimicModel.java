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
    public static final ModelLayerLocation MIMIC_MODEL_LAYER =
            new ModelLayerLocation(new ResourceLocation(MODID,"mimic_model"), "root");
    private final ModelPart mimic;

    public MimicModel(ModelPart root) {
        this.mimic = root.getChild("mimic");
    }

    private static String createSegmentName(int pIndex) {
        return "segment" + pIndex;
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mimic =
                partdefinition.addOrReplaceChild(
                        "mimic",
                        CubeListBuilder.create()
                                .texOffs(0, 9)
                                .addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 21.0F, 2.5F));

        PartDefinition head =
                mimic.addOrReplaceChild(
                        "head",
                        CubeListBuilder.create()
                                .texOffs(12, 9)
                                .addBox(-2.0F, -2.0F, -4.4F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 0.0F, -2.5F));

        PartDefinition chest =
                mimic.addOrReplaceChild(
                        "chest",
                        CubeListBuilder.create()
                                .texOffs(0, 0)
                                .addBox(-3.0F, -4.0F, -2.4F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 0.0F, -2.5F));

        PartDefinition tail =
                mimic.addOrReplaceChild(
                        "tail",
                        CubeListBuilder.create()
                                .texOffs(0, 0)
                                .addBox(-0.5F, 0.0F, 5.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 0.0F, -2.5F));

        PartDefinition leg_1 =
                mimic.addOrReplaceChild(
                        "leg_1",
                        CubeListBuilder.create()
                                .texOffs(17, 0)
                                .addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(0, 15)
                                .addBox(-3.0F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(-3.0F, -1.0F, -2.5F));

        PartDefinition leg_2 =
                mimic.addOrReplaceChild(
                        "leg_2",
                        CubeListBuilder.create()
                                .texOffs(16, 14)
                                .addBox(6.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(10, 14)
                                .addBox(8.0F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(-3.0F, -1.0F, -2.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public ModelPart root() {
        return this.mimic;
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setupAnim(MimicEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        /*
        for(int i = 0; i < this.bodyParts.length; ++i) {
            this.bodyParts[i].yRot = Mth.cos(pAgeInTicks * 0.9F + (float)i * 0.15F * (float)Math.PI) * (float)Math.PI * 0.01F * (float)(1 + Math.abs(i - 2));
            this.bodyParts[i].x = Mth.sin(pAgeInTicks * 0.9F + (float)i * 0.15F * (float)Math.PI) * (float)Math.PI * 0.1F * (float)Math.abs(i - 2);
        }
        */
    }
}


