// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


public class zombie.v1.8 extends EntityModel<Entity> {
	private final ModelRenderer model;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightItem;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftItem;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public zombie.v1.8() {
		textureWidth = 64;
		textureHeight = 64;

		model = new ModelRenderer(this);
		model.setRotationPoint(0.0F, 12.0F, 0.0F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -12.0F, 0.0F);
		model.addChild(body);
		body.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, -6.0F, 16.0F, 12.0F, 8.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(24, 28).addBox(-4.0F, -8.0F, -7.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.setTextureOffset(0, 20).addBox(-4.0F, -8.0F, -7.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		body.addChild(rightArm);
		rightArm.setTextureOffset(48, 0).addBox(-7.0F, -2.0F, -4.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setRotationPoint(-1.0F, 7.0F, 1.0F);
		rightArm.addChild(rightItem);
		

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		body.addChild(leftArm);
		leftArm.setTextureOffset(32, 44).addBox(3.0F, -2.0F, -4.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leftItem = new ModelRenderer(this);
		leftItem.setRotationPoint(1.0F, 7.0F, 1.0F);
		leftArm.addChild(leftItem);
		

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-4.9F, 12.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.setTextureOffset(16, 44).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 36).addBox(0.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		model.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}