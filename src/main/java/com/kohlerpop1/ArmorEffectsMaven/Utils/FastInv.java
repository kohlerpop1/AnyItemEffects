package com.kohlerpop1.ArmorEffectsMaven.Utils;

import com.kohlerpop1.ArmorEffectsMaven.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.util.Consumer;

import java.util.function.Predicate;

public class FastInv implements InventoryHolder
{
	public FastInv parent;
	public Inventory inv;
	public final PairMap<Integer, Consumer<InventoryClickEvent>> clicks = new PairMap<>();
	public Consumer<InventoryOpenEvent> open = open -> {};
	public Predicate<InventoryCloseEvent> close = close -> false;

	public FastInv(int rows, String title)
	{
		this(rows, null, title);
	}
	public FastInv(InventoryType type, String title)
	{
		this(0, type, title);
	}
	public FastInv(int rows, InventoryType type, String title)
	{
		if (rows == 0)
			inv = Bukkit.createInventory(this, type, Chat.color(title));
		else
			inv = Bukkit.createInventory(this, rows*9, Chat.color(title));
	}

	public FastInv addItem(Item item)
	{
		return addItem(item, event -> {});
	}

	public FastInv addItem(Item item, Consumer<InventoryClickEvent> handler) {
		return setItem(clicks.size(), item, handler);
	}
	public FastInv setItem(int slot, Item item)
	{
		return setItem(slot, item, event -> {});
	}
	public FastInv setItem(int slot, Item item, Consumer<InventoryClickEvent> handler) {
		return setItems(item, handler, slot);
	}
	public FastInv setItems(Item item, int... slots)
	{
		return setItems(item, event -> {}, slots);
	}
	public FastInv setItems(Item item, Consumer<InventoryClickEvent> handler, int... slots) {
		for (int slot : slots)
		{
			inv.setItem(slot, item.build());
			clicks.put(slot, handler);
		}
		return this;
	}

	public void setOpen(Consumer<InventoryOpenEvent> open)
	{
		this.open = open;
	}

	public void setClose(Predicate<InventoryCloseEvent> close)
	{
		this.close = close;
	}

	public FastInv setParent(FastInv parent)
	{
		this.parent = parent;
		return this;
	}

	@Override
	public Inventory getInventory()
	{
		return inv;
	}

	public void open(Player player)
	{
		player.openInventory(inv);
	}

	public void onClick(InventoryClickEvent event)
	{
		clicks.getOrDefault(event.getSlot(), e -> {}).accept(event);
	}

	public void onOpen(InventoryOpenEvent event)
	{
		open.accept(event);
	}

	public void onClose(InventoryCloseEvent event)
	{
		if (close.test(event))
			Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> open((Player) event.getPlayer()));
	}

	public static class OneInv extends FastInv
	{
		public OneInv(int rows, String title)
		{
			super(rows, title);
		}
	}

	public static class TypeInv extends FastInv
	{
		public TypeInv(InventoryType type, String title)
		{
			super(type, title);
		}
	}

	public static class PageInv extends FastInv
	{
		private int lines = 0;
		private final PairMap<Integer, Item> items = new PairMap<>(9);

		public PageInv(String title)
		{
			super(6, title);
		}

		@Override
		public FastInv setItems(Item item, Consumer<InventoryClickEvent> handler, int... slots)
		{
			for (int slot : slots)
			{
				items.put(slot, item);
				clicks.put(slot, handler);
			}
			return this;
		}

		@Override
		public void open(Player player)
		{
			if (parent != null)
				inv.setItem(45, new Item(Material.OAK_DOOR).setName("&6Go Back").build());
			else if (player.getOpenInventory().getTopInventory().getHolder() instanceof FastInv)
			{
				parent = (FastInv) player.getOpenInventory().getTopInventory().getHolder();
				inv.setItem(45, new Item(Material.OAK_DOOR).setName("&6Go Back").build());
			}

			inv.setItem(48, new Item(Material.EMERALD).setName("&6Scroll Up").build());
			inv.setItem(50, new Item(Material.REDSTONE).setName("&6Scroll Down").build());

			for (int i = 0; i < 45; i++)
				inv.setItem(i, items.getOrDefault(i+lines*9, new Item(Material.AIR)).build());

			player.openInventory(inv);
		}

		@Override
		public void onClick(InventoryClickEvent event)
		{
			event.setCancelled(true);
			if (event.getSlot() < 0) return;
			if (event.getSlot() == 45 && parent != null)
				parent.open((Player) event.getWhoClicked());
			else if (event.getSlot() == 48)
			{
				if (lines > 0)
				{
					lines--;
					open((Player) event.getWhoClicked());
				}
			} else if (event.getSlot() == 50)
			{
				if (items.size() - lines * 9 > 9)
				{
					lines++;
					open((Player) event.getWhoClicked());
				}
			} else if (items.containsKey(event.getSlot()+lines*9))
				clicks.getOrDefault(event.getSlot()+lines*9, e ->{}).accept(event);
		}
	}
}