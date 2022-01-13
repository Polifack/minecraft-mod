package com.poli.entity.custom.models;

import com.poli.entity.custom.ZurrudiumZombieEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import static com.poli.main.ZurrudiumMod.MODID;

public class ZurrudiumZombieModel extends HumanoidModel<ZurrudiumZombieEntity> {

    /*
    Using generated class from workbench
    this is forge 1.6
	Should I do a translator class?

	// xxx.setrotationpoint(a,b,c) = partpose.offset(a,b+heightscale,c)
	// xxx.settextureoffset(x,y) = .create().texoffs(x,y)
	// .addbox(ox,oy,oz, dx, dy, dz, ??, ??) = .addbox(ox,oy,oz,dx,dy,dz,cube_deformation)
     */

    public static MeshDefinition createMesh(CubeDeformation cubeDeformation, float heightScaling) {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("body",
                CubeListBuilder
                        .create()
                        .texOffs(0, 0)
                        .addBox(-8.0F, 0.0F, -6.0F,
                                16.0F, 12.0F, 8.0F, cubeDeformation),
                PartPose
                        .offset(0.0F, 0.0F + heightScaling, 0.0F));

        partdefinition.addOrReplaceChild("hat",
                CubeListBuilder
                        .create()
                        .texOffs(0, 20)
                        .addBox(-4.0F, -8.0F, -7.0F,
                                8.0F, 8.0F, 8.0F, cubeDeformation),
                PartPose.offset(0.0F, 0.0F + heightScaling, 0.0F));

        partdefinition.addOrReplaceChild("head",
                CubeListBuilder
                        .create()
                        .texOffs(24, 28)
                        .addBox(-4.0F, -8.0F, -7.0F,
                                8.0F, 8.0F, 8.0F, cubeDeformation),
                PartPose.offset(0.0F, 0.0F + heightScaling, 0.0F));

        partdefinition.addOrReplaceChild("right_arm",
                CubeListBuilder
                        .create()
                        .texOffs(48, 0)
                        .addBox(-7.0F, -2.0F, -4.0F,
                                4.0F, 12.0F, 4.0F, cubeDeformation),
                PartPose.offset(-5.0F, 2.0F + heightScaling, 0.0F));

        partdefinition.addOrReplaceChild("left_arm",
                CubeListBuilder
                        .create()
                        .texOffs(32, 44)
                        .addBox(3.0F, -2.0F, -4.0F,
                                4.0F, 12.0F, 4.0F, cubeDeformation),
                PartPose.offset(5.0F, 2.0F + heightScaling, 0.0F));

        partdefinition.addOrReplaceChild("right_leg",
                CubeListBuilder
                        .create()
                        .texOffs(16, 44)
                        .addBox(-1.0F, 0.0F, -4.0F,
                                4.0F, 12.0F, 4.0F, cubeDeformation),
                PartPose.offset(-4.9F, 12.0F + heightScaling, 0.0F));

        partdefinition.addOrReplaceChild("left_leg",
                CubeListBuilder
                        .create()
                        .texOffs(0, 36)
                        .addBox(0.0F, 0.0F, -4.0F,
                                4.0F, 12.0F, 4.0F, cubeDeformation),
                PartPose.offset(1.9F, 12.0F + heightScaling, 0.0F));
        return meshdefinition;
    }

    public static LayerDefinition createBodyLayer(){
        MeshDefinition md = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(md, 64, 64);
    }

    public static ModelLayerLocation ZURRUDIUM_ZOMBIE_LAYER =
            new ModelLayerLocation(new ResourceLocation(MODID,"zurrudium_zombie"), "body");

    public ZurrudiumZombieModel(ModelPart part) {
        super(part);
    }
}
