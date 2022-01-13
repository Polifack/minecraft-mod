package com.poli.setup;

import com.poli.client.modelload.MimicBlockML;
import com.poli.entity.ModEntityType;
import com.poli.entity.custom.models.MimicModel;
import com.poli.entity.custom.models.ZurrudiumZombieModel;
import com.poli.entity.custom.renderer.MimicRenderer;
import com.poli.entity.custom.renderer.ZurrudiumZombieRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.poli.main.ZurrudiumMod.MODID;


@Mod.EventBusSubscriber(modid = MODID, value= Dist.CLIENT, bus=Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    // Function to be called whenever a FMLClientSetupEvent is detected
    // we must add this to FML ModBus

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        // Model creation
        event.registerLayerDefinition(ZurrudiumZombieModel.ZURRUDIUM_ZOMBIE_LAYER,
                ZurrudiumZombieModel::createBodyLayer);
        event.registerLayerDefinition(MimicModel.MIMIC_MODEL_LAYER,MimicModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        // Renderers creation
        event.registerEntityRenderer(ModEntityType.ZURRUDIUM_ZOMBIE.get(), ZurrudiumZombieRenderer::new);
        event.registerEntityRenderer(ModEntityType.MIMIC.get(), MimicRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterModels(ModelRegistryEvent event){
        ModelLoaderRegistry.registerLoader(MimicBlockML.MIMIC_ML, new MimicBlockML());
    }


    public static void init(FMLClientSetupEvent event){

    }
}
