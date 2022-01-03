package com.poli.datagen;

import com.poli.setup.Register;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

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
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Register.MOD_ORE_VEIN.get()),
                        Register.MOD_ORE_INGOT.get(), 1, 100)
                .unlockedBy("has_ore",has(Register.MOD_ORE_VEIN.get()))
                .save(consumer, "mod_ore_ingot_from_vein");

        // Recipe for smelt chunk and get ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Register.MOD_ORE_CHUNK.get()),
                        Register.MOD_ORE_INGOT.get(), 0, 75)
                .unlockedBy("has_chunk",has(Register.MOD_ORE_CHUNK.get()))
                .save(consumer, "mod_ore_ingot_from_chunk");

        // Recipe for Tools
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_SWORD.get())
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_sword");
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_AXE.get())
                .pattern(" xx")
                .pattern(" #x")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_axe_right");
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_AXE.get())
                .pattern("xx ")
                .pattern("x# ")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_axe_left");
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_PICKAXE.get())
                .pattern("xxx")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_pickaxe");
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_SHOVEL.get())
                .pattern(" x ")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_shovel");
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_HOE.get())
                .pattern("xx ")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_hoe_left");
        ShapedRecipeBuilder.shaped(Register.MOD_ORE_HOE.get())
                .pattern(" xx")
                .pattern(" # ")
                .pattern(" # ")
                .define('x', Register.MOD_ORE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy("has_ore",has(Register.MOD_ORE_INGOT.get()))
                .save(consumer, "mod_ore_hoe_right");
    }
}
