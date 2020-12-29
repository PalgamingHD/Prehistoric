package net.prehistoric.screens.Analyzer;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.PropertyDelegate;
import net.prehistoric.Prehistoric;

public class AnalyzerScreenHandler extends AbstractAnalyzerScreenHandler {



    public AnalyzerScreenHandler(int i, PlayerInventory playerInventory) {
        super(Prehistoric.ANALYZER_SCREEN_HANDLER, Prehistoric.FOSSIL_RECIPE_TYPE, RecipeBookCategory.SMOKER, i, playerInventory);
    }

    public AnalyzerScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(Prehistoric.ANALYZER_SCREEN_HANDLER, Prehistoric.FOSSIL_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}