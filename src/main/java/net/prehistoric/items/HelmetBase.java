package net.prehistoric.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.prehistoric.Prehistoric;

public class HelmetBase extends ArmorItem {
    public HelmetBase(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot.HEAD, new Item.Settings().group(Prehistoric.PREHISTORIC));
    }
}
