package com.kohlerpop1.ArmorEffectsMaven.Utils;

import com.kohlerpop1.ArmorEffectsMaven.Main;
import com.kohlerpop1.ArmorEffectsMaven.Utils.Custom.ArmorBreakEvent;
import com.kohlerpop1.ArmorEffectsMaven.Utils.Custom.ArmorUnEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ArmorListener implements Listener
{
	private final Main main = Main.getPlugin(Main.class);

    @EventHandler(ignoreCancelled = true)
    public final void onInventoryClick(InventoryClickEvent event)
    {
		if (event.getClickedInventory() != null)
		{
			ItemStack[] before = event.getWhoClicked().getEquipment().getArmorContents();
			Bukkit.broadcastMessage(Arrays.toString(before));
			Bukkit.getScheduler().runTaskLater(main, ()->
			{
				ItemStack[] after = event.getWhoClicked().getEquipment().getArmorContents();
				Bukkit.broadcastMessage(Arrays.toString(after));
				if (before != after)
					Bukkit.broadcastMessage("Edit");
			}, 1);
//			boolean shift = event.getClick().equals(ClickType.SHIFT_LEFT) || event.getClick().equals(ClickType.SHIFT_RIGHT);
//			boolean num = event.getClick().equals(ClickType.NUMBER_KEY);
//			if (event.getSlotType() == SlotType.ARMOR || event.getSlotType() == SlotType.QUICKBAR || event.getSlotType() == SlotType.CONTAINER)
//			{
//				if (event.getClickedInventory().getType().equals(InventoryType.CRAFTING) || event.getClickedInventory().getType().equals(InventoryType.PLAYER))
//				{
//					if (shift)
//					{
//						ArmorType aType = ArmorType.getType(event.getCurrentItem());
//						if (aType != null)
//						{
//							boolean equipping = event.getRawSlot() != aType.getSlot();
//							boolean helm = aType.equals(ArmorType.HELMET) && equipping == isEmpty(event.getWhoClicked().getInventory().getHelmet());
//							boolean chest = aType.equals(ArmorType.CHESTPLATE) && equipping == isEmpty(event.getWhoClicked().getInventory().getChestplate());
//							boolean legs = aType.equals(ArmorType.LEGGINGS) && equipping == isEmpty(event.getWhoClicked().getInventory().getLeggings());
//							boolean boots = aType.equals(ArmorType.BOOTS) && equipping == isEmpty(event.getWhoClicked().getInventory().getBoots());
//							if (helm || chest || legs || boots)
//							{
//								ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent((Player) event.getWhoClicked(), aType, equipping ? null : event.getCurrentItem(), equipping ? event.getCurrentItem() : null);
//								Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
//								if (armorEquipEvent.isCancelled())
//									event.setCancelled(true);
//							}
//						}
//					} else
//					{
//						ArmorType aType = ArmorType.getType(event.getCursor());
//						ItemStack newArmorPiece = event.getCursor();
//						ItemStack oldArmorPiece = event.getCurrentItem();
//						if (num)
//						{
//							if (event.getClickedInventory().getType().equals(InventoryType.PLAYER))
//							{
//								ItemStack hotbarItem = event.getClickedInventory().getItem(event.getHotbarButton());
//								if (!isEmpty(hotbarItem))
//								{
//									aType = ArmorType.getType(hotbarItem);
//									newArmorPiece = hotbarItem;
//									oldArmorPiece = event.getClickedInventory().getItem(event.getSlot());
//								} else
//									aType = ArmorType.getType(!isEmpty(event.getCurrentItem()) ? event.getCurrentItem() : event.getCursor());
//							}
//						} else
//						{
//							if (isEmpty(event.getCursor()) && !isEmpty(event.getCurrentItem()))
//								aType = ArmorType.getType(event.getCurrentItem());
//						}
//
//						if (aType != null && event.getRawSlot() == aType.getSlot())
//						{
//							ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent((Player) event.getWhoClicked(), aType, oldArmorPiece, newArmorPiece);
//							Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
//							if (armorEquipEvent.isCancelled())
//								event.setCancelled(true);
//						}
//					}
//				}
//			}
		}
    }

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event)
    {
	    if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
	    {
		    ItemStack[] before = event.getPlayer().getEquipment().getArmorContents();
			Bukkit.broadcastMessage(Arrays.toString(before));
		    Bukkit.getScheduler().runTaskLater(main, ()->
		    {
			    ItemStack[] after = event.getPlayer().getEquipment().getArmorContents();
			    Bukkit.broadcastMessage(Arrays.toString(after));
			    if (before != after)
				    Bukkit.broadcastMessage("Edit");
		    }, 1);
//		    if (event.getClickedBlock() == null)
//		    {
//			    ArmorType type = ArmorType.getType(event.getItem());
//			    if (type != null)
//			    {
//					boolean helm = type.equals(ArmorType.HELMET) && isEmpty(event.getPlayer().getInventory().getHelmet());
//					boolean chest = type.equals(ArmorType.CHESTPLATE) && isEmpty(event.getPlayer().getInventory().getChestplate());
//					boolean legs = type.equals(ArmorType.LEGGINGS) && isEmpty(event.getPlayer().getInventory().getLeggings());
//					boolean boots = type.equals(ArmorType.BOOTS) && isEmpty(event.getPlayer().getInventory().getBoots());
//				    if (helm || chest || legs || boots)
//					{
//					    ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(event.getPlayer(), type, null, event.getItem());
//					    Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
//					    if (armorEquipEvent.isCancelled())
//						    event.setCancelled(true);
//				    }
//			    }
//		    }
	    }
    }

    @EventHandler
    public void itemBreakEvent(PlayerItemBreakEvent event)
    {
        ArmorType type = ArmorType.getType(event.getBrokenItem());
        if(type != ArmorType.OTHER)
		{
            ArmorBreakEvent eventBreak = new ArmorBreakEvent(event.getPlayer(), type, event.getBrokenItem());
            Bukkit.getServer().getPluginManager().callEvent(eventBreak);
            if(eventBreak.isCancelled())
			{
                ItemStack item = event.getBrokenItem().clone();
                item.setAmount(1);
                item.setDurability((short) (item.getDurability() - 1));
                if(type.equals(ArmorType.HELMET))
	                event.getPlayer().getInventory().setHelmet(item);
                else if(type.equals(ArmorType.CHESTPLATE))
	                event.getPlayer().getInventory().setChestplate(item);
                else if(type.equals(ArmorType.LEGGINGS))
	                event.getPlayer().getInventory().setLeggings(item);
                else if(type.equals(ArmorType.BOOTS))
	                event.getPlayer().getInventory().setBoots(item);
            }
        }
    }

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event)
    {
	    for (ItemStack item : event.getEntity().getEquipment().getArmorContents())
	    {
		    ArmorType type = ArmorType.getType(item);
		    if (type != ArmorType.OTHER)
			    Bukkit.getServer().getPluginManager().callEvent(new ArmorUnEquipEvent(event.getEntity(), type, item,null));
	    }
    }
}