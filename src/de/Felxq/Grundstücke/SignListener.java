package de.Felxq.Grundstücke;

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

public class SignListener implements Listener {
	
		@EventHandler
		public void onSignMade(SignChangeEvent e) {

			String line1before = e.getLine(1);
			
			if(e.getLine(0).equalsIgnoreCase("[Grundstück]") && !e.getLine(1).isEmpty()) {
				if(e.getPlayer().hasPermission("CraftDreams.Admin")) {
					if(e.getLine(1).startsWith("gs")) {

						e.setLine(0, "§7[§9Grundstück§7]");
						e.setLine(1, "");
						e.setLine(2, "§b150€");
						e.setLine(3, line1before);
					} else {
						e.getPlayer().sendMessage(Main.pr + "Der Grundstücks Name muss mit §bgs §5beginnen!");
					}
				} else {
					e.getPlayer().sendMessage(Main.pr + "Du kannst kein Grundstück erstellen!");
				}
				
			}
			
			
		}
		
		@EventHandler
		public void onInteractwithSign(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock().getState() instanceof Sign) {
					Sign s = (Sign) e.getClickedBlock().getState();
					if(s.getLine(0).equals("§7[§9Grundstück§7]")) {
						if(s.getLine(1).equalsIgnoreCase("")) {
							if(s.getLine(2).equalsIgnoreCase("§b150€")) {
								if(s.getLine(3).startsWith("gs")) {
									
									double having = EconomyAPI.getMoney(p.getUniqueId().toString());
									
									
									if(having >= 150) {
										EconomyAPI.removeMoney(p.getUniqueId().toString(), 150);
										p.sendMessage(Main.pr + "Das Grundstück §b" + s.getLine(3) + " §5gehört nun dir.");
										//try {
											
										//} catch(Exception e1) {
											Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "rg addmember -w " + p.getLocation().getWorld().getName() + " " + s.getLine(3) + " " + p.getName());			
										//}
										
										
                                        s.setLine(0, "§7[§9Grundstück§7]");
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
		public void onTryBreakGSSign(BlockBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBlock().getState() instanceof Sign) {
				Sign s = (Sign) e.getBlock().getState();
				
				if(s.getLine(0).equals("§7[§9Grundstück§7]")) {
					if(s.getLine(1).equals("§bBesitzer:")) {
						if(s.getLine(2).startsWith("§3")) {
							if(s.getLine(3).startsWith("gs")) {
								if(!p.hasPermission("CraftDreams.Admin")) {

									e.setCancelled(true);
									p.sendMessage(Main.pr + "Du kannst dieses Schild nicht zerstören!");
								} else {
									if(p.getItemInHand().getType() == Material.NETHER_STAR) {
										String delgs = s.getLine(3);
										String oldowner = s.getLine(2);
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "rg delete -w " + p.getLocation().getWorld().getName() + " " + delgs);
										p.sendMessage(Main.pr + "Du hast das Grundstück mit dem Namen §b" + delgs + " §5gelöscht!");
										e.setCancelled(true);
										
                                        s.setLine(0, "§7[§9Grundstück§7]");
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
		public void onTryBreakSellGSSign(BlockBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBlock().getState() instanceof Sign) {
				Sign s = (Sign) e.getBlock().getState();
				
				if(s.getLine(0).equals("§7[§9Grundstück§7]")) {
					if(s.getLine(1).equals("")) {
						if(s.getLine(2).equals("§b150€")) {
							if(s.getLine(3).startsWith("gs")) {
								if(!p.hasPermission("CraftDreams.Admin")) {

									e.setCancelled(true);
									p.sendMessage(Main.pr + "Du kannst dieses Schild nicht zerstören!");
								} else {
									if(p.getItemInHand().getType() == Material.NETHER_STAR) {
										String delgs = s.getLine(3);
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "rg delete -w " + p.getLocation().getWorld().getName() + " " + delgs);
										p.sendMessage(Main.pr + "Du hast das Verkaufsschild mit dem Grundstück §b" + delgs + " §5gelöscht!");
										e.setCancelled(true);
										
                                        s.setLine(0, "§7[§9Grundstück§7]");
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
