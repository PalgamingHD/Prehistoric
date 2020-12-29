package net.prehistoric.screens.ArcheologyWorkbench;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArcheologyWorkbenchScreen extends AbstractArcheologyWorkbenchScreen<ArcheologyWorkbenchScreenHandler> {
    //You can replace the background with whatever you like, just remember there will always be the recipe book button
    private static final Identifier BACKGROUND = new Identifier("prehistoric:textures/gui/container/workbench.png");

    public ArcheologyWorkbenchScreen(ArcheologyWorkbenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, BACKGROUND);
    }
}