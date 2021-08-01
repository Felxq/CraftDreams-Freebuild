package de.Felxq.UserShop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;


import de.Felxq.Economy_API.EconomyAPI;
import de.Felxq.Main.Main;

public class SignListenerShop implements Listener {
	
		@EventHandler
		public void onSignMade(SignChangeEvent e) {

			String line1before = e.getLine(1);
			
			if(e.getLine(0).equalsIgnoreCase("[Shop]") && !e.getLine(1).isEmpty()) {
				if(e.getPlayer().hasPermission("CraftDreams.Admin")) {
					if(e.getLine(1).startsWith("shop")) {

						e.setLine(0, "§7[§9Shop§7]");
						e.setLine(1, "");
						e.setLine(2, "§b10000€");
						e.setLine(3, line1before);
					} else {
						e.getPlayer().sendMessage(Main.pr + "Der Shop Name muss mit §bshop §5beginnen!");
					}
				} else {
					e.getPlayer().sendMessage(Main.pr + "Du kannst kein Shop erstellen!");
				}
				
			}
			
			
		}
		
		@EventHandler
		public void onInteractwithSign(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock().getState() instanceof Sign) {
					Sign s = (Sign) e.getClickedBlock().getState();
					if(s.getLine(0).equals("§7[§9Shop§7]")) {
						if(s.getLine(1).equalsIgnoreCase("")) {
							if(s.getLine(2).equalsIgnoreCase("§b10000€")) {
								if(s.getLine(3).startsWith("shop")) {
									
									double having = EconomyAPI.getMoney(p.getUniqueId().toString());
									
									
									if(having >= 10000) {
										EconomyAPI.removeMoney(p.getUniqueId().toString(), 10000);
										p.sendMessage(Main.pr + "Der Shop §b" + s.getLine(3) + " §5gehört nun dir.");
										//try {
											
										//} catch(Exception e1) {
											Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "rg addmember -w " + p.getLocation().getWorld().getName() + " " + s.getLine(3) + " " + p.getName());			
										//}
										
										
                                        s.setLine(0, "§7[§9Shop§7]");
                                        s.setLine(1, "§bBesitzer:");
                                        s.setLine(2, "§3" + p.getName());
                                        s.setLine(3, s.getLine(3));
                                        
                                        s.update();
                                        
										
									} else {
										p.sendMessage(Main.pr + "Du hast nicht genug Geld!");
									}
									
								}
							}
						}
					}
				}
			}
		}
		
		@SuppressWarnings("deprecation")
		@EventHandler
		public void onTryBreakShopSign(BlockBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBlock().getState() instanceof Sign) {
				Sign s = (Sign) e.getBlock().getState();
				
				if(s.getLine(0).equals("§7[§9Shop§7]")) {
					if(s.getLine(1).equals("§bBesitzer:")) {
						if(s.getLine(2).startsWith("§3")) {
							if(s.getLine(3).startsWith("shop")) {
								if(!p.hasPermission("CraftDreams.Admin")) {

									e.setCancelled(true);
									p.sendMessage(Main.pr + "Du kannst dieses Schild nicht zerstören!");
								} else {
									if(p.getItemInHand().getType() == Material.NETHER_STAR) {
										String delshop = s.getLine(3);
										String oldowner = s.getLine(2);
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "rg delete -w " + p.getLocation().getWorld().getName() + " " + delshop);
										p.sendMessage(Main.pr + "Du hast den Shop mit dem Namen §b" + delshop + " §5gelöscht!");
										e.setCancelled(true);
										
                                        s.setLine(0, "§7[§9Shop§7]");
                                        s.setLine(1, "§bEhem.-Besitzer:");
                                        s.setLine(2, "§3" + oldowner);
                                        s.setLine(3, "§c§nFREI");
                                        
                                        s.update();
									} else {
										e.setCancelled(true);
										p.sendMessage(Main.pr + "Du kannst dieses Schild nicht zerstören!");
									}
								}
							}
						}
					}
				}
			}
		}
		
		@SuppressWarnings("deprecation")
		@EventHandler
		public void onTryBreakSellShopSign(BlockBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBlock().getState() instanceof Sign) {
				Sign s = (Sign) e.getBlock().getState();
				
				if(s.getLine(0).equals("§7[§9Shop§7]")) {
					if(s.getLine(1).equals("")) {
						if(s.getLine(2).equals("§b10000€")) {
							if(s.getLine(3).startsWith("shop")) {
								if(!p.hasPermission("CraftDreams.Admin")) {

									e.setCancelled(true);
									p.sendMessage(Main.pr + "Du kannst dieses Schild nicht zerstören!");
								} else {
									if(p.getItemInHand().getType() == Material.NETHER_STAR) {
										String delshop = s.getLine(3);
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "rg delete -w " + p.getLocation().getWorld().getName() + " " + delshop);
										p.sendMessage(Main.pr + "Du hast das Verkaufsschild mit dem Shop §b" + delshop + " §5gelöscht!");
										e.setCancelled(true);
										
                                        s.setLine(0, "§7[§9Shop§7]");
                                        s.setLine(1, "§bLEER");
                                        s.setLine(2, "§cWurde nie");
                                        s.setLine(3, "§c§nVerkauft");
                                        
                                        s.update();
									} else {
										e.setCancelled(true);
										p.sendMessage(Main.pr + "Du kannst dieses Schild nicht zerstören!");
									}
								}
							}
						}
					}
				}
			}
		}

}
