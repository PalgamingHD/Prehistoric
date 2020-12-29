package net.prehistoric.recipe;


import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.prehistoric.Prehistoric;

public class SandRecipe extends AbstractCookingRecipe {
    public SandRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(Prehistoric.SAND_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.BLACKSTONE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Prehistoric.SAND_RECIPE_SERIALIZER;
    }
}
