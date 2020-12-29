package net.prehistoric.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.prehistoric.Prehistoric;

public class SwordBase extends SwordItem
{

    public SwordBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 2, -2.0F, new Item.Settings().group(Prehistoric.PREHISTORIC));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        System.out.println(attacker.getArmorItems());
        return super.postHit(stack, target, attacker);
    }
}
