package com.kohlerpop1.ArmorEffectsMaven.Utils;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class EffectItem extends Item
{
	private final List<PotionEffect> effects = new ArrayList<>();

	public EffectItem(ItemStack stack)
	{
		super(stack);
	}

	public EffectItem(Material material)
	{
		super(material);
	}

	public EffectItem(ConfigurationSection section)
	{
		super(section);

		if (section.contains("Effects"))
		{
			for (String line : section.getStringList("Effects"))
			{
				String[] split = line.split("\\|");
				if (split.length == 1)
					addEffect(PotionEffectType.getByName(split[0].toUpperCase()));
				else if (split.length == 2)
					addEffect(PotionEffectType.getByName(split[0].toUpperCase()), Integer.parseInt(split[1]));
				else if (split.length == 3)
					addEffect(PotionEffectType.getByName(split[0].toUpperCase()), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
			}
		}
	}

	public EffectItem addEffect(PotionEffectType type, int lvl, int length)
	{
		effects.add(new PotionEffect(type, length, lvl-1, false, true));
		return this;
	}

	public EffectItem addEffect(PotionEffectType type, int lvl)
	{
		return addEffect(type, lvl, Integer.MAX_VALUE);
	}

	public EffectItem addEffect(PotionEffectType type)
	{
		return addEffect(type, 1);
	}

	public List<PotionEffect> getEffects()
	{
		return effects;
	}
}
