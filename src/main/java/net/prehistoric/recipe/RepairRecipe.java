package net.prehistoric.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.prehistoric.Prehistoric;

public class RepairRecipe extends AbstractCookingRecipe {
    //Same for the BlockEntity, we don't need some of the parameters in the constructor since we already now the type
    public RepairRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(Prehistoric.REPAIR_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.BLACKSTONE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        //The Serializer will be created later
        return Prehistoric.REPAIR_RECIPE_SERIALIZER;
    }
}
