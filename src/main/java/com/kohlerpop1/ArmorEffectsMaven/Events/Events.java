package com.kohlerpop1.ArmorEffectsMaven.Events;

import com.kohlerpop1.ArmorEffectsMaven.Main;
import org.bukkit.event.Listener;

public class Events implements Listener
{
	private final Main main = Main.getPlugin(Main.class);

//	@EventHandler
//	public void ArmorEquipEvent(ArmorEquipEvent event)
//	{
//		if (event.getNewPiece() != null)
//		{
//			FileConfiguration config = main.getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = event.getNewPiece();
//					if (stack.getType().equals(Material.valueOf(config.getString(path + ".Material")))
//							&& stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore"))))
//							continue;
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String effect = y.split(";")[0];
//							int level = Integer.parseInt(y.split(";")[1]) - 1;
//							int time = 999999999;
//							if (!y.split(";")[2].equals("0"))
//							{
//								time = Integer.parseInt(y.split(";")[2]) * 20;
//							}
//							event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), time, level));
//						}
//					}
//				}
//			}
//		}
//
//		if (event.getOldPiece() != null)
//		{
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = event.getOldPiece();
//					if (stack.getType().equals(Material.valueOf(config.getString(path + ".Material")))
//							&& stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore"))))
//						{continue;}
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String[] effect = y.split(";");
//							event.getPlayer().removePotionEffect(PotionEffectType.getByName(effect[0]));
//						}
//					}
//				}
//			}
//		}
//	}
//
//
//	@EventHandler
//	public void onHit(EntityDamageByEntityEvent event)
//	{
//		if (event.getDamager() instanceof Player && event.getEntity() instanceof Player)
//		{
//			Player p = (Player) event.getDamager();
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = p.getItemInHand();
//					if (isArmor(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore"))))
//							continue;
//						for (String y : config.getStringList(path + ".Effects"))
//						{
//							String[] effect = y.split(";");
//							if (Arrays.asList("SLOW", "HARM", "SLOW_DIGGING", "CONFUSION", "BLINDNESS", "HUNGER", "WEAKNESS", "POISON", "WITHER", "LEVITATION", "UNLUCK").contains(effect[0]))
//								((Player) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect[0]), Integer.parseInt(effect[1]), Integer.parseInt(effect[2])));
//						}
//					}
//				}
//			}
//		}
//	}
//
//
//	@EventHandler
//	public void InventoryClickEvent(InventoryClickEvent event)
//	{
//		if (event.getClickedInventory() == null) return;
//		String title = event.getView().getTitle();
//		if (title.equals("Inventory") || title.equals("Crafting") || event.getClickedInventory() instanceof PlayerInventory) return;
//
//		if (title.equals(Chat.color("&b&lAnyItemsEffects Items")))
//		{
//			if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR)
//			{
//				event.setCancelled(true);
//				Player p = (Player) event.getWhoClicked();
//				if (p.hasPermission("ArmorEffects.Items"))
//				{
//					p.getInventory().addItem(event.getCurrentItem());
//				}
//			}
//		} else if (title.contains(Chat.color("&b&lAnyItemsEffects Items - ")))
//		{
//			if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR)
//			{
//				event.setCancelled(true);
//				Player receiver = Bukkit.getPlayer(title.split("- ")[0].split("-")[0]);
//				int amount = Integer.parseInt(title.split("- ")[0].split("-")[1]);
//				Player p = (Player) event.getWhoClicked();
//				ItemStack stack = event.getCurrentItem();
//				if (p.hasPermission("ArmorEffects.Give"))
//				{
//					stack.setAmount(amount);
//					receiver.getInventory().addItem(stack);
//					p.sendMessage(Chat.color("&eInfo: &7You gave &a"+receiver.getName()+" "+ "&e"+amount+" &7of your selected item!"));
//					p.closeInventory();
//					receiver.sendMessage(Chat.color("&eInfo: &7You have received a gift from AnyItemEffects Plugin!"));
//				}
//			}
//		} else if (title.equals(Chat.color("&bAnyItemEffects")))
//		{
//			if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR)
//			{
//				event.setCancelled(true);
//				Player p = (Player) event.getWhoClicked();
//				if (event.getCurrentItem().getType().equals(Material.PAPER))
//				{
//					p.closeInventory();
//					p.sendMessage(Chat.color("&eInfo: &7You are now setting the Unique ID for your item!"));
//					p.sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					p.setMetadata("SettingUniqueID", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else if (event.getCurrentItem().getType().equals(Material.BOOK))
//				{
//					p.closeInventory();
//					p.sendMessage(Chat.color("&eInfo: &7You are now setting the Name for your item!"));
//					p.sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					p.setMetadata("SettingName", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else if (event.getCurrentItem().getType().equals(Material.BOOKSHELF))
//				{
//					p.closeInventory();
//					p.sendMessage(Chat.color("&eInfo: &7You are now setting the Lore for your item!"));
//					p.sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					p.setMetadata("SettingLore", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else if (event.getCurrentItem().getType().equals(Material.FEATHER))
//				{
//					p.closeInventory();
//					p.sendMessage(Chat.color("&eInfo: &7You are now adding Effects to your item!"));
//					p.sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					p.setMetadata("AddingEffects", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else if (event.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK))
//				{
//					p.closeInventory();
//					p.sendMessage(Chat.color("&eInfo: &7You are now adding Enchants to your item!"));
//					p.sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					p.setMetadata("AddingEnchants", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else if (event.getCurrentItem().getType().equals(Material.NETHER_STAR))
//				{
//					saveItem(p);
//				}
//			}
//		}
//	}
//
//	private void saveItem(Player p)
//	{
//		File settings1 = new File(Main.getPlugin(Main.class).getDataFolder(), "config.yml");
//		FileConfiguration config = YamlConfiguration.loadConfiguration(settings1);
//		String id;
//		if (PlayerTalkEvent.UniqueID.containsKey(p))
//		{
//			id = PlayerTalkEvent.UniqueID.get(p);
//		} else {
//			p.sendMessage(Chat.color("&4Error: &cYou must set a UniqueID before saving!"));
//			return;
//		}
//		String name;
//		if (PlayerTalkEvent.Name.containsKey(p))
//		{
//			name = PlayerTalkEvent.Name.get(p);
//		} else {
//			p.sendMessage(Chat.color("&4Error: &cYou must set a Name before saving!"));
//			return;
//		}
//		String lore = PlayerTalkEvent.Lore.getOrDefault(p, null);
//		List<String> effects;
//		if (PlayerTalkEvent.Effects.containsKey(p))
//		{
//			effects = PlayerTalkEvent.Effects.get(p);
//		} else {
//			p.sendMessage(Chat.color("&4Error: &cYou must set at least 1 Effect before saving!"));
//			return;
//		}
//		List<String> enchants = PlayerTalkEvent.Enchants.getOrDefault(p, null);
//		if (!config.contains("Items." + id))
//		{
//			if (p.getInventory().getItem(p.getInventory().getHeldItemSlot()) != null && !p.getInventory().getItem(p.getInventory().getHeldItemSlot()).getType().equals(Material.AIR))
//			{
//				String mat = String.valueOf(p.getInventory().getItem(p.getInventory().getHeldItemSlot()).getType());
//				config.set("Items." + id + ".Enabled", true);
//				config.set("Items." + id + ".Material", mat);
//				config.set("Items." + id + ".Name", name);
//				config.set("Items." + id + ".Lore", lore);
//				config.set("Items." + id + ".Effects", effects);
//				config.set("Items." + id + ".Enchants", enchants);
//				Save.YML(config, settings1);
//				Main.getPlugin(Main.class).reloadConfig();
//				p.sendMessage(Chat.color("&eInfo: &aItem Creation Success"));
//				PlayerTalkEvent.UniqueID.remove(p);
//				PlayerTalkEvent.Name.remove(p);
//				PlayerTalkEvent.Lore.remove(p);
//				PlayerTalkEvent.Effects.remove(p);
//				PlayerTalkEvent.Enchants.remove(p);
//				p.removeMetadata("Continue", Main.getPlugin(Main.class));
//				p.closeInventory();
//				p.getInventory().setItem(p.getInventory().getHeldItemSlot(), Items.getItem(id));
//				PlayerItemHeldEvent event = new PlayerItemHeldEvent(p,4, p.getInventory().getHeldItemSlot());
//				Bukkit.getPluginManager().callEvent(event);
//			} else {
//				p.sendMessage(Chat.color("&4Error: &cYou must have an item in your hand!"));
//			}
//		} else
//		{
//			p.sendMessage(Chat.color("&4Error: &cAn item already exists with that ID. Please try a new ID."));
//		}
//	}
//
//	@EventHandler
//	public void PlayerDropItemEvent(PlayerDropItemEvent event)
//	{
//		FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//		for (String s : config.getConfigurationSection("Items").getKeys(false))
//		{
//			String path = "Items." + s;
//			if (config.getBoolean(path + ".Enabled"))
//			{
//				ItemStack stack = event.getItemDrop().getItemStack();
//				if (new ItemHold().checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//				{
//					if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//					List<String> effects = config.getStringList(path + ".Effects");
//					for (String y : effects)
//					{
//						String[] effect = y.split(";");
//						event.getPlayer().removePotionEffect(PotionEffectType.getByName(effect[0]));
//					}
//				}
//			}
//		}
//	}
//
//	@EventHandler
//	public void PlayerHoldItem(PlayerItemHeldEvent event)
//	{
//		if (event.getPlayer().getInventory().getItemInHand() != null)
//		{
//			Player p = event.getPlayer();
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = p.getInventory().getItem(event.getNewSlot());
//					if (checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String effect = y.split(";")[0];
//							int level = Integer.parseInt(y.split(";")[1]) - 1;
//							int time = 999999999;
//							if (!y.split(";")[2].equals("0"))
//							{
//								time = Integer.parseInt(y.split(";")[2]) * 20;
//							}
//							if (Arrays.asList("SPEED", "FAST_DIGGING", "INCREASE_DAMAGE", "HEAL", "JUMP", "REGENERATION", "DAMAGE_RESISTANCE",
//									"FIRE_RESISTANCE", "WATER_BREATHING", "INVISIBILITY", "NIGHT_VISION", "HEALTH_BOOST", "ABSORPTION", "SATURATION", "GLOWING",
//									"LUCK", "SLOW_FALLING", "CONDUIT_POWER", "DOLPHINS_GRACE").contains(effect))
//								event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), time, level));
//						}
//					}
//				}
//			}
//		}
//
//		if (event.getPlayer().getInventory().getItem(event.getPreviousSlot()) != null)
//		{
//			Player p = event.getPlayer();
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = p.getInventory().getItem(event.getPreviousSlot());
//					if (checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String[] effect = y.split(";");
//							event.getPlayer().removePotionEffect(PotionEffectType.getByName(effect[0]));
//						}
//					}
//				}
//			}
//		}
//	}
//
//	@EventHandler
//	public void PlayerHoldItem(InventoryClickEvent event)
//	{
//		if (event.getClickedInventory() != null)
//		{
//			Player p = (Player) event.getWhoClicked();
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//
//			if (event.getCursor().getType().equals(Material.AIR) && event.getCurrentItem() != null)
//			{
//				for (String s : config.getConfigurationSection("Items").getKeys(false))
//				{
//					String path = "Items." + s;
//					if (config.getBoolean(path + ".Enabled"))
//					{
//						ItemStack stack = event.getCurrentItem();
//						if (new ItemHold().checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//						{
//							if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore"))))
//							{continue;}
//							List<String> effects = config.getStringList(path + ".Effects");
//							for (String y : effects)
//							{
//								String[] effect = y.split(";");
//								p.removePotionEffect(PotionEffectType.getByName(effect[0]));
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//
//	@EventHandler
//	public void ItemPickup(PlayerPickupItemEvent event)
//	{
//		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () ->
//		{
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = event.getItem().getItemStack();
//					if (new ItemHold().checkStack(stack) && event.getPlayer().getInventory().getItem(event.getPlayer().getInventory().getHeldItemSlot()) != null
//							&& event.getPlayer().getInventory().getItem(event.getPlayer().getInventory().getHeldItemSlot()).equals(stack)
//							&& stack.getType().equals(Material.valueOf(config.getString(path + ".Material")))
//							&& stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String effect = y.split(";")[0];
//							int level = Integer.parseInt(y.split(";")[1]) - 1;
//							int time = 999999999;
//							if (!y.split(";")[2].equals("0"))
//							{
//								time = Integer.parseInt(y.split(";")[2]) * 20;
//							}
//							if (Arrays.asList("SPEED", "FAST_DIGGING", "INCREASE_DAMAGE", "HEAL", "JUMP", "REGENERATION", "DAMAGE_RESISTANCE",
//									"FIRE_RESISTANCE", "WATER_BREATHING", "INVISIBILITY", "NIGHT_VISION", "HEALTH_BOOST", "ABSORPTION", "SATURATION", "GLOWING",
//									"LUCK", "SLOW_FALLING", "CONDUIT_POWER", "DOLPHINS_GRACE").contains(effect))
//								event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), time, level));
//						}
//					}
//				}
//			}
//		}, 1);
//	}
//
//	@EventHandler
//	public void PlaceItemEvent(BlockPlaceEvent event)
//	{
//		Player p = event.getPlayer();
//		FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//		for (String s : config.getConfigurationSection("Items").getKeys(false))
//		{
//			String path = "Items." + s;
//			if (config.getBoolean(path + ".Enabled"))
//			{
//				ItemStack stack = event.getItemInHand();
//				if (new ItemHold().checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//				{
//					if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//					List<String> effects = config.getStringList(path + ".Effects");
//					for (String y : effects)
//					{
//						String[] effect = y.split(";");
//						p.removePotionEffect(PotionEffectType.getByName(effect[0]));
//					}
//				}
//			}
//		}
//	}
//
//
//	public static HashMap<Player, String> UniqueID = new HashMap<>();
//	public static HashMap<Player, String> Name = new HashMap<>();
//	public static HashMap<Player, String> Lore = new HashMap<>();
//	public static HashMap<Player, List<String>> Effects = new HashMap<>();
//	public static HashMap<Player, List<String>> Enchants = new HashMap<>();
//
//	@EventHandler
//	public void PlayerChatEvents(PlayerChatEvent event)
//	{
//		if (event.getPlayer().hasMetadata("SettingUniqueID"))
//		{
//			event.setCancelled(true);
//			if (!event.getMessage().equalsIgnoreCase("cancel"))
//			{
//				UniqueID.put(event.getPlayer(), event.getMessage());
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aUniqueID Set To: &r" + event.getMessage()));
//				event.getPlayer().removeMetadata("SettingUniqueID", Main.getPlugin(Main.class));
//				if (event.getPlayer().hasMetadata("Continue"))
//				{
//					event.getPlayer().closeInventory();
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7You are now setting the Name for your item!"));
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					event.getPlayer().setMetadata("SettingName", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else
//				{
//					event.getPlayer().openInventory(Items.getGUIInv());
//				}
//			} else {
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aUniqueID Cancelled!"));
//				event.getPlayer().removeMetadata("SettingUniqueID", Main.getPlugin(Main.class));
//				event.getPlayer().openInventory(Items.getGUIInv());
//			}
//		} else if (event.getPlayer().hasMetadata("SettingName"))
//		{
//			event.setCancelled(true);
//			if (!event.getMessage().equalsIgnoreCase("cancel"))
//			{
//				Name.put(event.getPlayer(), event.getMessage());
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aName Set To: &r" + event.getMessage()));
//				event.getPlayer().removeMetadata("SettingName", Main.getPlugin(Main.class));
//				if (event.getPlayer().hasMetadata("Continue"))
//				{
//					event.getPlayer().closeInventory();
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7You are now setting the Lore for your item!"));
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					event.getPlayer().setMetadata("SettingLore", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else
//				{
//					event.getPlayer().openInventory(Items.getGUIInv());
//				}
//			} else {
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aName Cancelled!"));
//				event.getPlayer().removeMetadata("SettingName", Main.getPlugin(Main.class));
//				event.getPlayer().openInventory(Items.getGUIInv());
//			}
//		} else if (event.getPlayer().hasMetadata("SettingLore"))
//		{
//			event.setCancelled(true);
//			if (!event.getMessage().equalsIgnoreCase("cancel"))
//			{
//				Lore.put(event.getPlayer(), event.getMessage());
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aLore Set To: &r" + event.getMessage()));
//				event.getPlayer().removeMetadata("SettingLore", Main.getPlugin(Main.class));
//				if (event.getPlayer().hasMetadata("Continue"))
//				{
//					event.getPlayer().closeInventory();
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7You are now adding Effects to your item!"));
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					event.getPlayer().setMetadata("AddingEffects", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else
//				{
//					event.getPlayer().openInventory(Items.getGUIInv());
//				}
//			} else {
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aLore Cancelled!"));
//				event.getPlayer().removeMetadata("SettingLore", Main.getPlugin(Main.class));
//				event.getPlayer().openInventory(Items.getGUIInv());
//			}
//		} else if (event.getPlayer().hasMetadata("AddingEffects"))
//		{
//			event.setCancelled(true);
//			if (!event.getMessage().equalsIgnoreCase("cancel"))
//			{
//				List<String> list;
//				if (Effects.containsKey(event.getPlayer()))
//				{ list = Effects.get(event.getPlayer());
//				} else
//				{ list = new ArrayList<>();
//				}
//				list.add(event.getMessage());
//				Effects.put(event.getPlayer(), list);
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aEffect Added: &r" + event.getMessage()));
//				event.getPlayer().removeMetadata("AddingEffects", Main.getPlugin(Main.class));
//				if (event.getPlayer().hasMetadata("Continue"))
//				{
//					event.getPlayer().closeInventory();
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7You are now adding Enchants to your item!"));
//					event.getPlayer().sendMessage(Chat.color("&eInfo: &7Please type it in chat!"));
//					event.getPlayer().setMetadata("AddingEnchants", new FixedMetadataValue(Main.getPlugin(Main.class), true));
//				} else
//				{
//					new Items();
//					event.getPlayer().openInventory(Items.getGUIInv());
//				}
//			} else {
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aEffect Cancelled!"));
//				event.getPlayer().removeMetadata("AddingEffects", Main.getPlugin(Main.class));
//				new Items();
//				event.getPlayer().openInventory(Items.getGUIInv());
//			}
//		} else if (event.getPlayer().hasMetadata("AddingEnchants"))
//		{
//			event.setCancelled(true);
//			if (!event.getMessage().equalsIgnoreCase("cancel"))
//			{
//				List<String> list;
//				if (Enchants.containsKey(event.getPlayer()))
//				{ list = Enchants.get(event.getPlayer());
//				} else
//				{ list = new ArrayList<>();
//				}
//				list.add(event.getMessage());
//				Enchants.put(event.getPlayer(), list);
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aEnchant Added: &r" + event.getMessage()));
//			} else {
//				event.getPlayer().sendMessage(Chat.color("&eInfo: &aEnchant Cancelled!"));
//			}
//			event.getPlayer().removeMetadata("AddingEnchants", Main.getPlugin(Main.class));
//			event.getPlayer().openInventory(Items.getGUIInv());
//		}
//	}
//
//
//	@EventHandler
//	public void SwitchHand(PlayerSwapHandItemsEvent event)
//	{
//		if (event.getMainHandItem() != null)
//		{
//
//		}
//		if (event.getPlayer().getInventory().getItem(event.getPlayer().getInventory().getHeldItemSlot()) != null)
//		{
//			Player p = event.getPlayer();
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = p.getInventory().getItem(p.getInventory().getHeldItemSlot());
//					if (new ItemHold().checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String effect = y.split(";")[0];
//							int level = Integer.parseInt(y.split(";")[1]) - 1;
//							int time = 999999999;
//							if (!y.split(";")[2].equals("0"))
//							{
//								time = Integer.parseInt(y.split(";")[2]) * 20;
//							}
//							if (Arrays.asList("SPEED", "FAST_DIGGING", "INCREASE_DAMAGE", "HEAL", "JUMP", "REGENERATION", "DAMAGE_RESISTANCE",
//									"FIRE_RESISTANCE", "WATER_BREATHING", "INVISIBILITY", "NIGHT_VISION", "HEALTH_BOOST", "ABSORPTION", "SATURATION", "GLOWING",
//									"LUCK", "SLOW_FALLING", "CONDUIT_POWER", "DOLPHINS_GRACE").contains(effect))
//								event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), time, level));
//						}
//					}
//				}
//			}
//		}
//
//		if (event.getPlayer().getInventory().getItem(event.getPlayer().getInventory().getHeldItemSlot()) != null)
//		{
//			Player p = event.getPlayer();
//			FileConfiguration config = Main.getPlugin(Main.class).getConfig();
//			for (String s : config.getConfigurationSection("Items").getKeys(false))
//			{
//				String path = "Items." + s;
//				if (config.getBoolean(path + ".Enabled"))
//				{
//					ItemStack stack = p.getInventory().getItemInMainHand();
//					if (new ItemHold().checkStack(stack) && stack.getType().equals(Material.valueOf(config.getString(path + ".Material"))) && stack.getItemMeta().getDisplayName().equals(Chat.color(config.getString(path + ".Name"))))
//					{
//						if (config.contains(path + ".Lore") && !stack.getItemMeta().getLore().equals(Item.getLore(config.getString(path + ".Lore")))) continue;
//						List<String> effects = config.getStringList(path + ".Effects");
//						for (String y : effects)
//						{
//							String[] effect = y.split(";");
//							event.getPlayer().removePotionEffect(PotionEffectType.getByName(effect[0]));
//						}
//					}
//				}
//			}
//		}
//	}
//
//	public boolean isArmor(ItemStack stack)
//	{
//		if (stack != null)
//		{
//			for (String string : Arrays.asList("helmet", "chestplate", "leggings", "boots"))
//				if (stack.getType().toString().toLowerCase().contains(string))
//					return true;
//		}
//		return false;
//	}
}
