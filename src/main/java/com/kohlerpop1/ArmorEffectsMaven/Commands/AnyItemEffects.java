package com.kohlerpop1.ArmorEffectsMaven.Commands;

import com.kohlerpop1.ArmorEffectsMaven.Main;
import com.kohlerpop1.ArmorEffectsMaven.Utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class AnyItemEffects implements CommandExecutor
{
	private final Main main;

	public AnyItemEffects(Main main)
	{
	    this.main = main;
	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
    {
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (args.length == 0)
				p.performCommand("ae help");
			else
			{
				switch (args[0].toLowerCase())
				{
					case "help":
						if (p.isOp() || p.hasPermission("ArmorEffect.*") || p.hasPermission("ArmorEffects.Use"))
						{
							p.sendMessage(Chat.color("&8<>&7------------- &bAnyItemEffects &7-------------&8<>"));
							p.sendMessage(" ");
							p.sendMessage(Chat.color("&bHelp &8- &7Display these messages!"));
							p.sendMessage(Chat.color("&bReload &8- &7Reload the settings!"));
							p.sendMessage(Chat.color("&bItems &8- &7View AnyItemEffects items!"));
							p.sendMessage(Chat.color("&bGUI &8- &7View AnyItemEffects Creation GUI!"));
							p.sendMessage(Chat.color("&bNew &8- &7Start Item Creation Process!"));
							p.sendMessage(Chat.color("&bGive &8- &7Give Item To Player!"));
							p.sendMessage(" ");
							p.sendMessage(Chat.color("&8>  &7Use &b/ai [argument]&7!"));
							p.sendMessage(" ");
							p.sendMessage(Chat.color("&8<>&7----------------------------------------&8<>"));
						} else
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.NoPermission")));
						break;

					case "reload":
						if (p.isOp() || p.hasPermission("ArmorEffect.*") || p.hasPermission("ArmorEffects.Reload"))
						{
							main.reloadConfig();
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.PluginReloaded")));
						} else
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.NoPermission")));
						break;

					case "items":
						if (p.isOp() || p.hasPermission("ArmorEffect.*") || p.hasPermission("ArmorEffects.Items"))
						{
//							List<ItemStack> items = getItems();
//							int size = ((items.size()-1)/9)+1;
//							Inventory inv = Bukkit.createInventory(null, size, Chat.color("&b&lAnyItemsEffects Items"));
//							for (ItemStack stack : items)
//							{
//								inv.addItem(stack);
//							}
//							return inv;
						}
						else
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.NoPermission")));
						break;

					case "give":
						if (p.isOp() || p.hasPermission("ArmorEffect.*") || p.hasPermission("ArmorEffects.Give"))
						{
							Player other = Bukkit.getPlayer(args[1]);
							if (other != null)
							{
								if (args.length >= 2)
								{
									int amount = args.length >= 3 ? Integer.parseInt(args[2]) : 1;
									if (args.length == 4)
									{
//										if (!Items.getItem(args[3]).getType().equals(Material.AIR))
//										{
//											Player receiver = Bukkit.getPlayer(args[1]);
//											ItemStack stack = Items.getItem(args[3]);
//											stack.setAmount(amount);
//											receiver.getInventory().addItem(stack);
//											p.sendMessage(Chat.color("&eInfo: &7You gave &a"+receiver.getName()+" "+ "&e"+amount+" &7of your selected item!"));
//											receiver.sendMessage(Chat.color("&eInfo: &7You have received a gift from AnyItemEffects Plugin!"));
//										} else
//											p.sendMessage(Chat.color("&4Error: &cUnique ID not recognized. Please try again!"));
									} else
									{
//										List<ItemStack> items = Items.getItems();
//										int size = ((items.size() - 1) / 9) + 1;
//										Inventory inv = Bukkit.createInventory(null, size, Chat.color("&b&lAnyItemsEffects Items - " + other.getName() + " | " + amount));
//										for (ItemStack stack : items)
//											inv.addItem(stack);
//										p.openInventory(inv);
									}
								} else
									p.sendMessage(Chat.color("&4Error: &eUsage: /ai give <player> [Amount] [ItemID]"));
							} else
								p.sendMessage(Chat.color("&4Error: &cThat player cannot be found!"));
						} else
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.NoPermission")));
						break;

					case "gui":
						if (p.isOp() || p.hasPermission("ArmorEffects.*") || p.hasPermission("ArmorEffects.Create"))
						{
							if (p.getInventory().getItemInMainHand() != null && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR))
							{
//								Inventory inv = Bukkit.createInventory(null, 27, Chat.color("&bAnyItemEffects"));
//								for (int i = 0; i < inv.getSize(); i++)
//								{
//									inv.setItem(i, Item.create(Material.STAINED_GLASS_PANE, 1, " "));
//								}
//								inv.setItem(1, Item.create(Material.PAPER, 1, "&eSet Unique ID for the Item!", " ;&7Click to Select!"));
//								inv.setItem(3, Item.create(Material.BOOK, 1, "&eSet Name for the Item!", " ;&7Click to Select!"));
//								inv.setItem(11, Item.create(Material.BOOKSHELF, 1, "&eSet Lore for the Item!", " ;&7Click to Select!"));
//								inv.setItem(19, Item.create(Material.FEATHER, 1, "&eAdd Effects to the Item!", " ;&7Click to Select!"));
//								inv.setItem(21, Item.create(Material.ENCHANTED_BOOK, 1, "&eAdd Enchants to the Item!", " ;&7Click to Select!"));
//								inv.setItem(15, Item.create(Material.NETHER_STAR, 1, "&eFinish the Item!", " ;&4WARNING: &cThis will save your info;&cand finish the creation process!; ;&7Click to Select!"));
//								p.openInventory(inv);
							}
							else
								p.sendMessage(Chat.color("&4Error: &cYou must have an item in your hand!"));
						} else
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.NoPermission")));
						break;

					case "new":
						if (p.isOp() || p.hasPermission("ArmorEffects.*") || p.hasPermission("ArmorEffects.Create"))
						{
							if (p.getInventory().getItemInMainHand() != null && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR))
							{
								p.closeInventory();
								p.sendMessage(Chat.color("&eInfo: &7You are now setting the Unique ID for your item!"));
								p.sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
								p.setMetadata("SettingUniqueID", new FixedMetadataValue(main, true));
								p.setMetadata("Continue", new FixedMetadataValue(main, true));
							}
							else
								p.sendMessage(Chat.color("&4Error: &cYou must have an item in your hand!"));
						} else
							p.sendMessage(Chat.color(main.getConfig().getString("Messages.NoPermission")));
						break;
				}
			}
		} else
			sender.sendMessage(Chat.color(main.getConfig().getString("Messages.NotPlayer")));
        return true;
    }
}
