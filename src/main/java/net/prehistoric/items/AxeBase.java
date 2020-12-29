package net.prehistoric.items;

import net.minecraft.item.*;
import net.prehistoric.Prehistoric;

public class AxeBase extends AxeItem
{

    public AxeBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 1, -3.0F, new Item.Settings().group(Prehistoric.PREHISTORIC));
    }
}
