package com.poli.setup;

import com.poli.entity.ModEntityType;
import com.poli.entity.custom.models.ZurrudiumZombieModel;
import com.poli.entity.custom.renderer.ZurrudiumZombieRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
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
        event.registerLayerDefinition(ZurrudiumZombieModel.ZURRUDIUM_ZOMBIE_LAYER,
                ZurrudiumZombieModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityType.ZURRUDIUM_ZOMBIE.get(), ZurrudiumZombieRenderer::new);
    }

    public static void init(FMLClientSetupEvent event){

    }
}
