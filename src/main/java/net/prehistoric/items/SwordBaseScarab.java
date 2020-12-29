package net.prehistoric.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.prehistoric.Prehistoric;

public class SwordBaseScarab extends SwordItem
{

    public SwordBaseScarab(ToolMaterial toolMaterial) {
        super(toolMaterial, 2, -2.0F, new Item.Settings().group(Prehistoric.PREHISTORIC));
    }
}
