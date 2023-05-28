package dev.ithundxr.mods.dbe.base.data.recipe;

import dev.ithundxr.mods.dbe.DBE;
import dev.ithundxr.mods.dbe.multiloader.CommonTags;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class DBERecipeProvider extends RecipeProvider {

    protected final List<GeneratedRecipe> all = new ArrayList<>();

    public DBERecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public void registerRecipes(@NotNull Consumer<FinishedRecipe> p_200404_1_) {
        all.forEach(c -> c.register(p_200404_1_));
        DBE.LOGGER.info(getName() + " registered " + all.size() + " recipe" + (all.size() == 1 ? "" : "s"));
    }

    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    @FunctionalInterface
    public interface GeneratedRecipe {
        void register(Consumer<FinishedRecipe> consumer);
    }

    @SuppressWarnings("SameReturnValue")
    public static class Ingredients {
        public static TagKey<Item> string() {
            return CommonTags.STRING.tag;
        }

        public static TagKey<Item> fence() {
            return TagKey.<Item>create(Registry.ITEM_REGISTRY, new ResourceLocation("minecraft:fences"));
        }

        public static ItemLike campfire() {
            return Blocks.CAMPFIRE;
        }

        public static ItemLike redstone() {
            return Items.REDSTONE;
        }
    }
}
