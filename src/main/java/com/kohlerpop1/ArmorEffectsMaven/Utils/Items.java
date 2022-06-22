package com.kohlerpop1.ArmorEffectsMaven.Utils;

import com.kohlerpop1.ArmorEffectsMaven.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class Items
{
	private final PairMap<String, ItemStack> items;

	public Items(Main main)
	{
		items = new PairMap<>();
		if (main.getConfig().contains("Items"))
		{
			ConfigurationSection section = main.getConfig().getConfigurationSection("Items");
			if (section != null)
				for (String id : section.getKeys(false))
					items.put(id, new Item(section.getConfigurationSection(id)).build());
		}
	}

    public PairMap<String, ItemStack> getItems()
    {
        return items;
    }
}
