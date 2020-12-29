package net.prehistoric.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.prehistoric.Prehistoric;
import net.prehistoric.screens.ArcheologyWorkbench.AbstractArcheologyWorkbenchBlockEntity;
import net.prehistoric.screens.ArcheologyWorkbench.ArcheologyWorkbenchScreenHandler;

public class ArcheologyWorkbenchBlockEntity extends AbstractArcheologyWorkbenchBlockEntity{
    //Since we already now the BlockEntityType and RecipeType we don't need them in the constructor's parameters
    public ArcheologyWorkbenchBlockEntity()
    {
        super(Prehistoric.ARCHEOLOGY_WORKBENCH_BLOCK_ENTITY, Prehistoric.REPAIR_RECIPE_TYPE);
    }

    @Override
    public Text getContainerName() {
        //you should use a translation key instead but this is easier
        return Text.of("Archeology Workbench");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ArcheologyWorkbenchScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}