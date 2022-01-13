package com.poli.client.modelload;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.poli.client.bakedmodel.MimicBlockBM;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.geometry.IModelGeometry;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static com.poli.main.ZurrudiumMod.MODID;


// Class that allow in the client to display the correct block for the mimicBlock

// Main ModelLoader class
public class MimicBlockML implements IModelLoader<MimicBlockML.MimicBlockMG> {
        public static final ResourceLocation MIMIC_ML = new ResourceLocation(MODID, "mimic_loader");
    public static final Material MATERIAL_SIDE = ForgeHooksClient.getBlockMaterial(
            new ResourceLocation(MODID, "block/mimic_block")); ;

    @Override
    public MimicBlockMG read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new MimicBlockMG();
    }

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {

    }


    // Auxiliary ModelGeometry Class
    public static class MimicBlockMG implements IModelGeometry<MimicBlockMG>{

        @Override
        public BakedModel bake(IModelConfiguration owner, ModelBakery bakery,
                               Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform,
                               ItemOverrides overrides, ResourceLocation modelLocation) {

            return new MimicBlockBM(modelTransform,spriteGetter);
        }

        @Override
        public Collection<Material> getTextures(IModelConfiguration owner,
                                                Function<ResourceLocation, UnbakedModel> modelGetter,
                                                Set<Pair<String, String>> missingTextureErrors) {

            return List.of(MATERIAL_SIDE);
        }
    }
}
