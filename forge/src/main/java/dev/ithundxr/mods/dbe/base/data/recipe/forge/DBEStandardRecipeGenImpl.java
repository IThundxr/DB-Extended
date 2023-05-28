package dev.ithundxr.mods.dbe.base.data.recipe.forge;

import dev.ithundxr.mods.dbe.base.data.recipe.DBEStandardRecipeGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DBEStandardRecipeGenImpl extends DBEStandardRecipeGen {
    protected RailwaysStandardRecipeGenImpl(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static RecipeProvider create(DataGenerator gen) {
        DBEStandardRecipeGen provider = new DBEStandardRecipeGenImpl(gen);
        return new RecipeProvider(gen) {
            @Override
            protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
                provider.registerRecipes(consumer);
            }
        };
    }
}