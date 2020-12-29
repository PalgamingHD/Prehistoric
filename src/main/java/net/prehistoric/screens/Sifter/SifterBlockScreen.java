package net.prehistoric.screens.Sifter;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SifterBlockScreen extends AbstractSifterScreen<SifterBlockScreenHandler>
{

    private static final Identifier BACKGROUND = new Identifier("prehistoric:textures/gui/container/sifter_gui.png");

    public SifterBlockScreen(SifterBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, BACKGROUND);
    }
}