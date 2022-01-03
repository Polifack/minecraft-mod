package com.poli.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.poli.tutorialmod.TutorialMod.MODID;

public class Register {

    // Auxiliary function to register an item from a block
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block){
        return DR_ITEMS.register(block.getId().getPath(), ()->new BlockItem(block.get(),ITEM_PROPERTIES));
    }

    // Create the deferred registers
    public static final DeferredRegister<Block> DR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> DR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Get block properties
    public static final BlockBehaviour.Properties ORE_PROPERTIES =
            BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();

    // Get the item properties
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    // Create the ore block and an item for that block
    public static final RegistryObject<Block> MOD_ORE_VEIN =
            DR_BLOCKS.register("mod_ore_vein", ()->new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MOD_ORE_VEIN_ITEM = fromBlock(MOD_ORE_VEIN);

    // Create the chunk and ingot that the block will drop
    public static final RegistryObject<Item> MOD_ORE_CHUNK =
            DR_ITEMS.register("mod_ore_chunk", ()->new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MOD_ORE_INGOT =
            DR_ITEMS.register("mod_ore_ingot", ()->new Item(ITEM_PROPERTIES));

    // Create the Mod Ore Tier
    // Here should be all changes that apply to all weapons
    // copy the diamond tier
    // lv=3, uses=1500, speed=8.0F, dmg=3.0F, enchant=10

    public static final ForgeTier ORE_MOD_TIER = new ForgeTier(3, 1500, 8.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL,
            ()-> Ingredient.of(MOD_ORE_INGOT.get()));

    // Create the Mod Ore Armor Material

    // Create some tools
    // base = {bonus=1, speed_modifier=4}
    // item.bonus = item.bonus + tier.bonus + base.bonus
    // item.atk_speed = item.atk_speed + base.atk_speed
    // SwordItem(tier, attack_mod, speed_mod, properties)
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

    // Create a tag for the items in our mod
    public static final Tags.IOptionalNamedTag<Block> MOD_ORE =
            BlockTags.createOptional(new ResourceLocation(MODID,"mod_ore"));
    public static final Tags.IOptionalNamedTag<Item> MOD_ORE_ITEM =
            ItemTags.createOptional(new ResourceLocation(MODID,"mod_ore"));

    public static void init(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DR_BLOCKS.register(eventBus);
        DR_ITEMS.register(eventBus);
    }
}
