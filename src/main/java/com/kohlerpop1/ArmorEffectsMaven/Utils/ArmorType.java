package com.kohlerpop1.ArmorEffectsMaven.Utils;

import org.bukkit.inventory.ItemStack;

/**
 * @Author Borlea
 * @Github https://github.com/borlea/
 * @Website http://codingforcookies.com/
 * @Since Jul 30, 2015 6:46:16 PM
 */
public enum ArmorType
{
    HELMET(5),
	CHESTPLATE(6),
	LEGGINGS(7),
	BOOTS(8),
	OTHER(-1);

    private final int slot;

    ArmorType(int slot){
        this.slot = slot;
    }

    public static ArmorType getType(ItemStack item)
    {
	    if (item != null)
	    {
		    String type = item.getType().name().toLowerCase();
		    if (type.contains("helmet"))
			    return HELMET;
			if (type.contains("chestplate"))
				return CHESTPLATE;
			if (type.contains("leggings"))
			    return LEGGINGS;
		    if (type.contains("boots"))
			    return BOOTS;
	    }
	    return OTHER;
    }

    public int getSlot(){
        return slot;
    }
}