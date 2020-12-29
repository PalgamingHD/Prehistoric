package net.prehistoric.screens.ArcheologyWorkbench;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.PropertyDelegate;
import net.prehistoric.Prehistoric;

public class ArcheologyWorkbenchScreenHandler extends AbstractArcheologyWorkbenchScreenHandler{
    public ArcheologyWorkbenchScreenHandler(int i, PlayerInventory playerInventory) {
        super(Prehistoric.ARCHEOLOGY_WORKBENCH_SCREEN_HANDLER, Prehistoric.REPAIR_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public ArcheologyWorkbenchScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(Prehistoric.ARCHEOLOGY_WORKBENCH_SCREEN_HANDLER, Prehistoric.REPAIR_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}