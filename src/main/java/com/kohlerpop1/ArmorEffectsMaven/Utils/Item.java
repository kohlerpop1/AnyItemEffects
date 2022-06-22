package com.kohlerpop1.ArmorEffectsMaven.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Item
{
	private final ItemStack stack;
	private final ItemMeta meta;

	public Item(ItemStack stack)
	{
		this.stack = stack;
		this.meta = stack.hasItemMeta() ? stack.getItemMeta() : Bukkit.getServer().getItemFactory().getItemMeta(stack.getType());
	}

	public Item(Material material)
	{
		this(new ItemStack(material));
	}

	public Item(ConfigurationSection section)
	{
		this(section.contains("Material") ? Material.getMaterial(section.getString("Material")) : Material.STONE);

		if (section.contains("Name"))
			setName(section.getString("Name"));

		if (section.contains("Lore"))
		{
			if (section.get("Lore") instanceof String)
				setLore(section.getString("lore"));
			else
				setLore(section.getStringList("Lore"));
		}

		if (section.contains("Enchants"))
			for (String line : section.getStringList("Enchants"))
			{
				String[] split = line.split("\\|");
				addEnch(Enchantment.getByName(split[0].toUpperCase()), Integer.parseInt(split[1]));
			}

		if (section.contains("Flags"))
			for (String line : section.getStringList("Flags"))
				addFlag(ItemFlag.valueOf(line.toUpperCase()));
	}

	public Item setType(Material material)
	{
		stack.setType(material);
		return this;
	}

	public Item setName(String name)
	{
		meta.setDisplayName(Chat.color(name));
		return this;
	}

	public Item setAmount(int amount)
	{
		stack.setAmount(amount);
		return this;
	}

	public Item setLore(String... lore)
	{
		if(lore.length > 0)
			return setLore(Arrays.asList(lore));
		return this;
	}

	public Item setLore(List<String> lore)
	{
		if(!lore.isEmpty())
			meta.setLore(lore.stream().map(Chat::color).collect(Collectors.toList()));
		return this;
	}

	public Item setLore(int line, String lore)
	{
		if(line >= 0 && !lore.isEmpty())
			meta.getLore().set(line, Chat.color(lore));
		return this;
	}

	public Item addLore(String lore)
	{
		if(!lore.isEmpty())
			meta.getLore().add(Chat.color(lore));
		return this;
	}

	public Item addEnch(Enchantment enchantment, int level)
	{
		meta.addEnchant(enchantment, level, true);
		return this;
	}

	public Item remEnch(Enchantment enchantment)
	{
		meta.removeEnchant(enchantment);
		return this;
	}

	public Item addFlag(ItemFlag flag)
	{
		meta.addItemFlags(flag);
		return this;
	}

	public Item remFlag(ItemFlag flag)
	{
		meta.removeItemFlags(flag);
		return this;
	}

	public ItemStack build()
	{
		stack.setItemMeta(meta);
		return stack;
	}
}