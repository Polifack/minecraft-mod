package com.poli.client.bakedmodel;

import com.mojang.math.Transformation;
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
import net.minecraft.client.resources.model.WeightedBakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.client.model.QuadTransformer;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static com.poli.blocks.custom.blockEntity.MimicBE.IMITATING_BLOCK;

// Baked model -> Model generated on runtime. This allows for custom shape or textures
// For example, if we wanted that "cows" had different textures when spawned we need to make them a baked model
public class MimicBlockBM implements IDynamicBakedModel {

    private final ModelState modelState;
    private final Block defaultBlock = Blocks.DIRT;
    private final Function<Material, TextureAtlasSprite> spriteGetter;

    public MimicBlockBM(ModelState modelState,Function<Material, TextureAtlasSprite> spriteGetter) {
        this.modelState = modelState;
        this.spriteGetter = spriteGetter;
    }

    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand,
                                    @NotNull IModelData extraData) {

        RenderType layer = MinecraftForgeClient.getRenderType();
        var quads = new ArrayList<BakedQuad>();
        BlockState imitatingBlock = extraData.getData(IMITATING_BLOCK);
        if (imitatingBlock != null) {
            System.out.println("Imitating block="+imitatingBlock);
            System.out.println("Imitating block Block="+imitatingBlock.getBlock());
            System.out.println("Imitating block Block DefaultState="+imitatingBlock.getBlock().defaultBlockState());
            System.out.println("Layer="+layer);
            System.out.println("CanRenderInLayer="+ItemBlockRenderTypes.canRenderInLayer(imitatingBlock, layer));
            if (layer == null || ItemBlockRenderTypes.canRenderInLayer(imitatingBlock, layer)) {
                BakedModel model = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper()
                        .getBlockModel(imitatingBlock);
                System.out.println("Model="+model);
                try {
                    // Get the quads for every side, transform it and add it to the list of quads
                    for (Direction s : Direction.values()) {

                        List<BakedQuad> modelQuads = model.getQuads(imitatingBlock, s, rand, EmptyModelData.INSTANCE);
                        System.out.println("Model quads="+modelQuads);
                        if (modelQuads==null){
                            model = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper()
                                    .getBlockModel(Blocks.DIRT.defaultBlockState());

                        }
                        quads.addAll(modelQuads);
                    }
                } catch (Exception e) {
                    ZurrudiumMod.LOGGER.log(Level.ERROR, "A block '" + imitatingBlock.getBlock()
                            .getRegistryName().toString() + "' caused a crash!");
                }
            }
        }

        return quads;
    }


    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return spriteGetter.apply(MimicBlockML.MATERIAL_SIDE);
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }
}
