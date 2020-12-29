package net.prehistoric.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.prehistoric.Prehistoric;
import net.prehistoric.screens.Sifter.AbstractSifterBlockEntity;
import net.prehistoric.screens.Sifter.SifterBlockScreenHandler;

public class SifterBlockEntity extends AbstractSifterBlockEntity {
    public SifterBlockEntity() {
        super(Prehistoric.SIFTER_BLOCK_ENTITY, Prehistoric.SAND_RECIPE_TYPE);
    }

    @Override
    public Text getContainerName() {
        return Text.of("Sifter");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new SifterBlockScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

}