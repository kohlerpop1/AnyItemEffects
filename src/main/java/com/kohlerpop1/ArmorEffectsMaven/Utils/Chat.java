package com.kohlerpop1.ArmorEffectsMaven.Utils;

import org.bukkit.ChatColor;

public class Chat
{
	public static String format(String text, String... params)
	{
		String finalText = color(text);
		for (int i = 0; i < params.length; i+=2)
			finalText = finalText.replace(params[i], params[i+1]);
		return finalText;
	}

	public static String color(String text)
	{
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}

