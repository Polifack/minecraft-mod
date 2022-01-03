package com.poli.items;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.blocks.ModBlocks.MOD_ORE_VEIN;
import static com.poli.items.ModItemsProperties.ITEM_PROPERTIES;
import static com.poli.items.ModItemsTiers.ORE_MOD_TIER;
import static com.poli.tutorialmod.TutorialMod.MODID;

public class ModItems {
    // Auxiliar function to get items from blocks
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block){
        return DR_ITEMS.register(block.getId().getPath(), ()->new BlockItem(block.get(),ITEM_PROPERTIES));
    }

    // Initialization of the Deferred Register
    public static final DeferredRegister<Item> DR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Items
    public static final RegistryObject<Item> MOD_ORE_CHUNK =
            DR_ITEMS.register("mod_ore_chunk", ()->new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MOD_ORE_INGOT =
            DR_ITEMS.register("mod_ore_ingot", ()->new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MOD_ORE_VEIN_ITEM = fromBlock(MOD_ORE_VEIN);
    public static final RegistryObject<Item> MOD_ORE_SWORD =
            DR_ITEMS.register("mod_ore_sword",
                    ()->new SwordItem(ORE_MOD_TIER, 3,-2.4f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> MOD_ORE_AXE =
            DR_ITEMS.register("mod_ore_axe",
                    ()->new AxeItem(ORE_MOD_TIER, 5,-3f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> MOD_ORE_SHOVEL =
            DR_ITEMS.register("mod_ore_shovel",
                    ()->new ShovelItem(ORE_MOD_TIER, 1.5f,-3f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> MOD_ORE_PICKAXE =
            DR_ITEMS.register("mod_ore_pickaxe",
                    ()->new PickaxeItem(ORE_MOD_TIER, 1,-2.8f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> MOD_ORE_HOE =
            DR_ITEMS.register("mod_ore_hoe",
                    ()->new HoeItem(ORE_MOD_TIER, -3,0f, (ITEM_PROPERTIES)));

}
