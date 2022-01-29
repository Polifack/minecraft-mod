package com.poli.client.bakedmodel;

import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.math.Transformation;
import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;
import com.poli.client.modelload.MimicBlockML;
import com.poli.main.ZurrudiumMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.pipeline.BakedQuadBuilder;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

import static com.poli.blocks.custom.blockEntity.MimicBE.IMITATING_BLOCK;

// Baked model -> Model generated on runtime. This allows for custom shape or textures
// For example, if we wanted that "cows" had different textures when spawned we need to make them a baked model
public class MimicBlockBM implements IDynamicBakedModel {

    private final ModelState modelState;
    private final Block defaultBlock = Blocks.DIRT;
    private final Function<Material, TextureAtlasSprite> spriteGetter;
    private List<BakedQuad> quadCache = new ArrayList<>();

    public MimicBlockBM(ModelState modelState,Function<Material, TextureAtlasSprite> spriteGetter) {
        this.modelState = modelState;
        this.spriteGetter = spriteGetter;
        generateDefaultModel();
    }

    // Auxiliary stuff to create quads
    public static Vector3f v(float x, float y, float z) {
        return new Vector3f(x, y, z);
    }
    private static void putVertexUV(BakedQuadBuilder builder, float u, float v, TextureAtlasSprite sprite, int j,
                                    VertexFormatElement e) {
        switch (e.getIndex()) {
            case 0  -> builder.put(j, sprite.getU(u), sprite.getV(v));
            case 2  -> builder.put(j, (short) 0, (short) 0);
            default -> builder.put(j);
        }
    }
    private static void putVertex(BakedQuadBuilder builder, Vector3f normal, Vector4f vector,
                                  float u, float v, TextureAtlasSprite sprite) {

        var elements = builder.getVertexFormat().getElements().asList();
        for (int j = 0 ; j < elements.size() ; j++) {
            var e = elements.get(j);
            switch (e.getUsage()) {
                case POSITION -> builder.put(j, vector.x(), vector.y(), vector.z(), 1.0f);
                case COLOR    -> builder.put(j, 1.0f, 1.0f, 1.0f, 1.0f);
                case UV       -> putVertexUV(builder, u, v, sprite, j, e);
                case NORMAL   -> builder.put(j, normal.x(), normal.y(), normal.z());
                default       -> builder.put(j);
            }
        }
    }
    private void generateDefaultModel(){
        var quads = new ArrayList<BakedQuad>();
        float l = 0;
        float r = 1;
        float p = 13f / 16f; // Relative position of panel

        float bl = 1f/16f;   // Left side of button
        float br = 7f/16f;   // Right side of button

        float h = .5f;       // Half

        Transformation rotation = modelState.getRotation();

        TextureAtlasSprite mainTexture = spriteGetter.apply(MimicBlockML.MIMIC_MATERIAL);

        // The base
        quads.add(createQuad(v(r, p, r), v(r, p, l), v(l, p, l), v(l, p, r), rotation, mainTexture));
        quads.add(createQuad(v(l, l, l), v(r, l, l), v(r, l, r), v(l, l, r), rotation, mainTexture));
        quads.add(createQuad(v(r, p, r), v(r, l, r), v(r, l, l), v(r, p, l), rotation, mainTexture));
        quads.add(createQuad(v(l, p, l), v(l, l, l), v(l, l, r), v(l, p, r), rotation, mainTexture));
        quads.add(createQuad(v(r, p, l), v(r, l, l), v(l, l, l), v(l, p, l), rotation, mainTexture));
        quads.add(createQuad(v(l, p, r), v(l, l, r), v(r, l, r), v(r, p, r), rotation, mainTexture));

        quadCache = quads;
    }


    public static BakedQuad createQuad(Vector3f v1, Vector3f v2, Vector3f v3, Vector3f v4, Transformation rotation, TextureAtlasSprite sprite) {
        Vector3f normal = v3.copy();
        normal.sub(v2);
        Vector3f temp = v1.copy();
        temp.sub(v2);
        normal.cross(temp);
        normal.normalize();

        int tw = sprite.getWidth();
        int th = sprite.getHeight();

        rotation = rotation.blockCenterToCorner();
        rotation.transformNormal(normal);

        Vector4f vv1 = new Vector4f(v1); rotation.transformPosition(vv1);
        Vector4f vv2 = new Vector4f(v2); rotation.transformPosition(vv2);
        Vector4f vv3 = new Vector4f(v3); rotation.transformPosition(vv3);
        Vector4f vv4 = new Vector4f(v4); rotation.transformPosition(vv4);

        var builder = new BakedQuadBuilder(sprite);
        builder.setQuadOrientation(Direction.getNearest(normal.x(), normal.y(), normal.z()));
        putVertex(builder, normal, vv1, 0, 0, sprite);
        putVertex(builder, normal, vv2, 0, th, sprite);
        putVertex(builder, normal, vv3, tw, th, sprite);
        putVertex(builder, normal, vv4, tw, 0, sprite);
        return builder.build();
    }

    // Every time anything changes in MimicModelML this will be called
    // This is called seven times, one for each side of the block
    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand,
                                    @NotNull IModelData extraData) {
        // Check that we are in the solid render layer
        RenderType layer = MinecraftForgeClient.getRenderType();
        if (side!=null || (layer!=null&&!layer.equals(RenderType.solid()))){
            return Collections.emptyList();
        }
        // Get from the extra data the imitating block
        // The imitating block is defined in the block_entity as a model property
        // and is set in the getModelData() function
        BlockState imitatingBlock = extraData.getData(IMITATING_BLOCK);
        ArrayList<BakedQuad> quads = new ArrayList<>();

        if (imitatingBlock != null) {

            if (imitatingBlock.equals(Blocks.GRASS_BLOCK.withPropertiesOf(imitatingBlock))){
                imitatingBlock=Blocks.DIRT.defaultBlockState();
            }

            BakedModel model = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper()
                    .getBlockModel(imitatingBlock);
            try {
                // Get the quads for every side, transform it and add it to the list of quads*-9
                for (Direction s : Direction.values()) {
                    //IModelData extraData =
                    List<BakedQuad> modelQuads = model.getQuads(imitatingBlock, s, rand, extraData);
                    for (BakedQuad bq:modelQuads){
                        System.out.println(bq.getSprite());
                    }
                    quads.addAll(modelQuads);
                }
            } catch (Exception e) {
                ZurrudiumMod.LOGGER.log(Level.ERROR, "A block '" + imitatingBlock.getBlock()
                        .getRegistryName().toString() + "' caused a crash!");
            }
            return quads;
        }
        else {
            return quadCache;
        }
    }


    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public @NotNull TextureAtlasSprite getParticleIcon() {
        return spriteGetter.apply(MimicBlockML.MIMIC_MATERIAL);
    }

    @Override
    public @NotNull ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }
}
