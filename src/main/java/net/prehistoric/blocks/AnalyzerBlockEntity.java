package net.prehistoric.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.prehistoric.Prehistoric;
import net.prehistoric.screens.Analyzer.AbstractAnalyzerBlockEntity;
import net.prehistoric.screens.Analyzer.AnalyzerScreenHandler;

public class AnalyzerBlockEntity extends AbstractAnalyzerBlockEntity
{
    public AnalyzerBlockEntity() {
        super(Prehistoric.ANALYZER_BLOCK_ENTITY, Prehistoric.FOSSIL_RECIPE_TYPE);
    }

    @Override
    public Text getContainerName() {
        return Text.of("Analyzer");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new AnalyzerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
