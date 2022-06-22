package com.kohlerpop1.ArmorEffectsMaven.Utils.Custom;

import com.kohlerpop1.ArmorEffectsMaven.Utils.ArmorType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public final class ArmorBreakEvent extends PlayerEvent implements Cancellable
{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancel = false;
	private final ArmorType type;
	private final ItemStack item;

	public ArmorBreakEvent(Player player, ArmorType type, ItemStack item)
	{
		super(player);
		this.type = type;
		this.item = item;
	}

	public static HandlerList getHandlerList(){
		return handlers;
	}

	@Override
	public HandlerList getHandlers(){
		return handlers;
	}

	public void setCancelled(boolean cancel){
		this.cancel = cancel;
	}

	public boolean isCancelled(){
		return cancel;
	}

	public ArmorType getType(){
		return type;
	}

	public ItemStack getItem(){
		return item;
	}
}