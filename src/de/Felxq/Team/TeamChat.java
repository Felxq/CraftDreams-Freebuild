package de.Felxq.Team;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.Felxq.Main.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;


public class TeamChat implements Listener {
	
			@EventHandler
			public void PlayerChatLSEvent(AsyncPlayerChatEvent e) {
				Player p = e.getPlayer();
				
				if(e.getMessage().startsWith("@team")) {
					if(p.hasPermission("CraftDreams.TeamChat")) {
						if(login_CMD.TeamLogin.contains(p.getName())) {
							String msg = e.getMessage();
							
								for(Player team : Bukkit.getOnlinePlayers()) {
									if(team.hasPermission("CraftDreams.TeamChat") && login_CMD.TeamLogin.contains(team.getName())) {
										e.setCancelled(true);
										//team.sendMessage(Main.pr + "§3" + p.getName() + " §b" + msg.replaceAll("@team", "§9 • §a"));
										team.playSound(team.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
										//team.sendMessage("§c* " + p.getDisplayName() + " §b" + msg.replaceAll("@team", "§9 • §a"));
										
										
										if(PermissionsEx.getUser(p).inGroup("Admin")) {
											team.sendMessage("§5* §4Admin §7• §4" + p.getName() + msg.replaceAll("@team", "§b »§3"));
										} else
											if(PermissionsEx.getUser(p).inGroup("Developer")) {
												team.sendMessage("§5* §bDeveloper §7• §b" + p.getName() + msg.replaceAll("@team", "§b »§3"));
										} else
											if(PermissionsEx.getUser(p).inGroup("Moderator")) {
												team.sendMessage("§5* §cModerator §7• §c" + p.getName() + msg.replaceAll("@team", "§b »§3"));
										} else
											if(PermissionsEx.getUser(p).inGroup("Supporter")) {
												team.sendMessage("§5* §9Supporter §7• §9" + p.getName() + msg.replaceAll("@team", "§b »§3"));
										} else
											if(PermissionsEx.getUser(p).inGroup("Builder")) {
												team.sendMessage("§5* §6Builder §7• §6" + p.getName() + msg.replaceAll("@team", "§b »§3"));
										} else {
											team.sendMessage("§5* §7" + p.getName() + msg.replaceAll("@team", "§b »§3"));
										}
									}
								}

						} else {
							p.sendMessage(Main.pr + "Melde dich bitte mit §b/team login §5an.");
							e.setCancelled(true);
						}

					} else {
						p.sendMessage(Main.noperm);
						e.setCancelled(true);
					}
				}
			}

}
