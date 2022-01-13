// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


public class spider.v1.8 extends EntityModel<Entity> {
	private final ModelRenderer body0;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;

	public spider.v1.8() {
		textureWidth = 64;
		textureHeight = 64;

		body0 = new ModelRenderer(this);
		body0.setRotationPoint(0.0F, 15.0F, 0.0F);
		body0.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-4.0F, 0.0F, 5.0F);
		body0.addChild(leg0);
		setRotationAngle(leg0, 0.0F, 0.0F, -0.5236F);
		leg0.setTextureOffset(18, 0).addBox(-5.0F, -1.0F, -4.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(4.0F, 0.0F, 2.0F);
		body0.addChild(leg1);
		setRotationAngle(leg1, 0.0F, 0.0F, 0.5236F);
		leg1.setTextureOffset(0, 17).addBox(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(4.0F, 0.0F, 1.0F);
		body0.addChild(leg2);
		setRotationAngle(leg2, 0.0F, 0.0F, 0.5236F);
		leg2.setTextureOffset(0, 13).addBox(-3.0F, -1.0F, -4.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-4.0F, 0.0F, -1.0F);
		body0.addChild(leg3);
		setRotationAngle(leg3, 0.0F, 0.0F, -0.5236F);
		leg3.setTextureOffset(0, 9).addBox(-5.0F, -1.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body0.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}