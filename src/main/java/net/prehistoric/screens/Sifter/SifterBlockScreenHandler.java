package net.prehistoric.screens.Sifter;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.PropertyDelegate;
import net.prehistoric.Prehistoric;

public class SifterBlockScreenHandler extends AbstractSifterScreenHandler {



    public SifterBlockScreenHandler(int i, PlayerInventory playerInventory) {
        super(Prehistoric.SIFTER_BLOCK_SCREEN_HANDLER, Prehistoric.SAND_RECIPE_TYPE, RecipeBookCategory.SMOKER, i, playerInventory);
    }

    public SifterBlockScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(Prehistoric.SIFTER_BLOCK_SCREEN_HANDLER, Prehistoric.SAND_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}