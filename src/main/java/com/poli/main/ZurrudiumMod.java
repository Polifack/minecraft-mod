package com.poli.main;

import com.poli.setup.ClientSetup;
import com.poli.setup.ModSetup;
import com.poli.setup.Register;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("zurrudium_mod")
public class ZurrudiumMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "zurrudium_mod";

    public ZurrudiumMod() {
        // Set Internal Server event hooks
        ModSetup.setup();

        // Set defered registers start
        Register.init();

        // Get the Starting ModBus
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the Internal Server Events to the Startup Modbus
        modbus.addListener(ModSetup::init);


        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, ()->()->modbus.addListener(ClientSetup::init));
    }
}
