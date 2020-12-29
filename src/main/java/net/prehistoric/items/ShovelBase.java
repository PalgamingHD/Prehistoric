package net.prehistoric.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.prehistoric.Prehistoric;

public class ShovelBase extends ShovelItem
{
    public ShovelBase(ToolMaterial material) {
        super(material, 0, -2.0F, new Item.Settings().group(Prehistoric.PREHISTORIC));
    }
}
