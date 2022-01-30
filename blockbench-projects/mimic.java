// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class MimicEntity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "endermite"), "main");
	private final ModelPart mimic;

	public endermite(ModelPart root) {
		this.mimic = root.getChild("mimic");
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

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mimic.render(poseStack, buffer, packedLight, packedOverlay);
	}
}