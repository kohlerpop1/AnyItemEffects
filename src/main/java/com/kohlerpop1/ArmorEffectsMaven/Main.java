package com.kohlerpop1.ArmorEffectsMaven;

import com.kohlerpop1.ArmorEffectsMaven.Commands.AnyItemEffects;
import com.kohlerpop1.ArmorEffectsMaven.Events.*;
import com.kohlerpop1.ArmorEffectsMaven.Utils.ArmorListener;
import com.kohlerpop1.ArmorEffectsMaven.Utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	private Items items;

    @Override
    public void onEnable()
    {
	    Bukkit.getPluginCommand("ae").setExecutor(new AnyItemEffects(this));

	    getLogger().info(" Commands Initiated!");

	    Bukkit.getPluginManager().registerEvents(new ArmorListener(), this);
	    Bukkit.getPluginManager().registerEvents(new Events(), this);

        getLogger().info("Loading Files...");

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	    items = new Items(this);

	    getLogger().info("Files Loaded!");

	    getLogger().info("AnyItemEffects Enabled!");
    }

	@Override
    public void onDisable()
    {
	    getLogger().info("is now disabled.");
    }

	public Items getItems()
	{
		return items;
	}
}
