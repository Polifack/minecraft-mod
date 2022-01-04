package com.poli.items;

import com.poli.blocks.ModBlocks;
import com.poli.items.custom.ModDaggerItem;
import com.poli.items.custom.ModHammerItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.items.ModArmorMaterials.ZURRUDIUM_ARMOR_MATERIAL;
import static com.poli.items.ModItemsProperties.ITEM_PROPERTIES;
import static com.poli.items.ModItemsTiers.ZURRUDIUM_TIER;
import static com.poli.main.ZurrudiumMod.MODID;

public class ModItems {
    // Auxiliar function to get items from blocks
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block){
        return DR_ITEMS.register(block.getId().getPath(), ()->new BlockItem(block.get(),ITEM_PROPERTIES));
    }

    // Initialization of the Deferred Register
    public static final DeferredRegister<Item> DR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    ////////////////////////////////////////////////////

    // Items
    public static final RegistryObject<Item> ZURRUDIUM_RAW =
            DR_ITEMS.register("zurrudium_raw", ()->new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> ZURRUDIUM_INGOT =
            DR_ITEMS.register("zurrudium_ingot", ()->new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> ZURRUDIUM_ORE = fromBlock(ModBlocks.ZURRUDIUM_ORE);

    // Tools
    public static final RegistryObject<Item> ZURRUDIUM_SWORD =
            DR_ITEMS.register("zurrudium_sword",
                    ()->new SwordItem(ZURRUDIUM_TIER, 3,-2.4f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> ZURRUDIUM_AXE =
            DR_ITEMS.register("zurrudium_axe",
                    ()->new AxeItem(ZURRUDIUM_TIER, 5,-3f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> ZURRUDIUM_SHOVEL =
            DR_ITEMS.register("zurrudium_shovel",
                    ()->new ShovelItem(ZURRUDIUM_TIER, 1.5f,-3f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> ZURRUDIUM_PICKAXE =
            DR_ITEMS.register("zurrudium_pickaxe",
                    ()->new PickaxeItem(ZURRUDIUM_TIER, 1,-2.8f, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> ZURRUDIUM_HOE =
            DR_ITEMS.register("zurrudium_hoe",
                    ()->new HoeItem(ZURRUDIUM_TIER, -3,0f, (ITEM_PROPERTIES)));

    // Armor
    public static final RegistryObject<Item> ZURRUDIUM_HELMET =
            DR_ITEMS.register("zurrudium_helmet",
                    ()->new ArmorItem(ZURRUDIUM_ARMOR_MATERIAL, EquipmentSlot.HEAD, ITEM_PROPERTIES));
    public static final RegistryObject<Item> ZURRUDIUM_LEGGINGS =
            DR_ITEMS.register("zurrudium_leggings",
                    ()->new ArmorItem(ZURRUDIUM_ARMOR_MATERIAL, EquipmentSlot.LEGS, ITEM_PROPERTIES));
    public static final RegistryObject<Item> ZURRUDIUM_CHESTPLATE =
            DR_ITEMS.register("zurrudium_chestplate",
                    ()->new ArmorItem(ZURRUDIUM_ARMOR_MATERIAL, EquipmentSlot.CHEST, ITEM_PROPERTIES));
    public static final RegistryObject<Item> ZURRUDIUM_BOOTS =
            DR_ITEMS.register("zurrudium_boots",
                    ()->new ArmorItem(ZURRUDIUM_ARMOR_MATERIAL, EquipmentSlot.FEET, ITEM_PROPERTIES));

    // Custom tools
    public static final RegistryObject<Item> POISON_DAGGER =
            DR_ITEMS.register("poison_dagger",
                    ()->new ModDaggerItem(ZURRUDIUM_TIER, -3,4, (ITEM_PROPERTIES)));

    public static final RegistryObject<Item> LIGHTNING_HAMMER =
            DR_ITEMS.register("lightning_hammer",
                    ()->new ModHammerItem(ZURRUDIUM_TIER, 2, -3,ITEM_PROPERTIES));
}
