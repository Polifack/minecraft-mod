package com.poli.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.poli.blocks.ModBlocks.ZURRUDIUM_ORE;
import static com.poli.items.ModItems.*;

public class ModRecipes extends RecipeProvider {
    public ModRecipes(DataGenerator gen){super(gen);}

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){
        // Create the recipes for the items in our mod

        // Create a smelting recipe for items with the mod_ore_item tag
        // smelting syntax:
        // smelting(<ingredients>, <result>, <experience>, <smelt_time>)
        // recipe unlock syntax:
        // unlockedBy(<condition>).save(consumer, <recipe_name>)
        // shaped syntax:
        // shaped(<result>).pattern().pattern().pattern().define().unlockedBy().save()

        // Recipe for smelt ore and get ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ZURRUDIUM_ORE.get()),
                        ZURRUDIUM_INGOT.get(), 1, 100)
                .unlockedBy("has_ore",has(ZURRUDIUM_ORE.get()))
                .save(consumer, "mod_ore_ingot_from_vein");

        // Recipe for smelt chunk and get ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ZURRUDIUM_RAW.get()),
                        ZURRUDIUM_INGOT.get(), 0, 75)
                .unlockedBy("has_chunk",has(ZURRUDIUM_RAW.get()))
                .save(consumer, "mod_ore_ingot_from_chunk");

        // Recipe for Tools
        ShapedRecipeBuilder.shaped(ZURRUDIUM_SWORD.get())
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_sword");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_AXE.get())
                .pattern(" xx")
                .pattern(" #x")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_axe_right");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_AXE.get())
                .pattern("xx ")
                .pattern("x# ")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_axe_left");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_PICKAXE.get())
                .pattern("xxx")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_pickaxe");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_SHOVEL.get())
                .pattern(" x ")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_shovel");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_HOE.get())
                .pattern("xx ")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_hoe_left");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_HOE.get())
                .pattern(" xx")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', ZURRUDIUM_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_hoe_right");

        // Recipe for armor
        ShapedRecipeBuilder.shaped(ZURRUDIUM_HELMET.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("   ")
                .define('x', ZURRUDIUM_INGOT.get())
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_helmet");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_CHESTPLATE.get())
                .pattern("x x")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', ZURRUDIUM_INGOT.get())
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_chestplate");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_LEGGINGS.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("x x")
                .define('x', ZURRUDIUM_INGOT.get())
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_leggings");
        ShapedRecipeBuilder.shaped(ZURRUDIUM_BOOTS.get())
                .pattern("   ")
                .pattern("x x")
                .pattern("x x")
                .define('x', ZURRUDIUM_INGOT.get())
                .unlockedBy("has_ore",has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_ore_boots");
        ShapedRecipeBuilder.shaped(POISON_DAGGER.get())
                .pattern(" x ")
                .pattern("exi")
                .pattern(" s ")
                .define('x',Items.IRON_NUGGET)
                .define('e',Items.SPIDER_EYE)
                .define('i', ZURRUDIUM_INGOT.get())
                .define('s', Items.STICK)
                .unlockedBy("has_ore", has(ZURRUDIUM_INGOT.get()))
                .unlockedBy("has_eye",has(Items.SPIDER_EYE))
                .unlockedBy("has_nugget", has(Items.IRON_NUGGET))
                .save(consumer, "mod_poison_dagger");
        ShapedRecipeBuilder.shaped(LIGHTNING_HAMMER.get())
                .pattern("ixi")
                .pattern("ixi")
                .pattern(" s ")
                .define('x',Items.IRON_INGOT)
                .define('i', ZURRUDIUM_INGOT.get())
                .define('s', Items.STICK)
                .unlockedBy("has_ore", has(ZURRUDIUM_INGOT.get()))
                .save(consumer, "mod_lighnting_hammer");


    }
}
