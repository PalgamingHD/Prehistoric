package net.prehistoric.items;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.prehistoric.Prehistoric;

public class PickaxeBase extends PickaxeItem
{

    public PickaxeBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 0, -3.0F, new Item.Settings().group(Prehistoric.PREHISTORIC));
    }
}
