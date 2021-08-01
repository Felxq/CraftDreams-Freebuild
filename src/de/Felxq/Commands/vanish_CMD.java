package de.Felxq.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class vanish_CMD implements CommandExecutor {
	
		ArrayList<String> vanish = new ArrayList<>();
		

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
			if(p.hasPermission("CraftDreams.Vanish")) {
				if(!vanish.contains(p.getName())) {
					p.sendMessage(Main.pr + "§3Du bist nun Unsichtbar.");
					vanish.add(p.getName());
					
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
						all.sendMessage("§8[§c-§8] §c" + p.getName());
					}
					
				} else {
					p.sendMessage(Main.pr + "§3Du bist nun nicht mehr Unsichtbar.");
					vanish.remove(p.getName());
					
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(p);
						all.sendMessage("§8[§e+§8] §e" + p.getName());
					}
				}
			} else {
			}
			p.sendMessage(Main.noperm);

		return false;
	}
	
	

}
