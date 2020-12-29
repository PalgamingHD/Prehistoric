package net.prehistoric.screens.Analyzer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AnalyzerScreen extends AbstractAnalyzerScreen<AnalyzerScreenHandler>
{

    private static final Identifier BACKGROUND = new Identifier("prehistoric:textures/gui/container/analyzer.png");

    public AnalyzerScreen(AnalyzerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, BACKGROUND);
    }
}