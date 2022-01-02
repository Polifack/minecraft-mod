package com.poli.datagen;

import com.poli.setup.Register;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
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

        // Recipe for smelt ore and get ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Register.MOD_ORE_ITEM),
                Register.MOD_ORE_INGOT.get(), 1, 100)
                .unlockedBy("has_ore",has(Register.MOD_ORE_ITEM))
                .save(consumer, "modoreingot1");

        // Recipe for smelt chunk and get ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Register.MOD_ORE_CHUNK.get()),
                        Register.MOD_ORE_INGOT.get(), 0, 75)
                .unlockedBy("has_chunk",has(Register.MOD_ORE_CHUNK.get()))
                .save(consumer, "modoreingot2");
    }
}
