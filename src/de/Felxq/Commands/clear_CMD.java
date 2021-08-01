package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class clear_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
			if(s instanceof Player) {
				Player p = (Player)s;
					if(args.length == 0) {
						if(p.hasPermission("CraftDreams.Clear")) {
						p.getInventory().clear();
						p.sendMessage(Main.pr + "Dein Inventar wurde gelerrt.");
						} else {
							p.sendMessage(Main.noperm);
						}
					} else if(args.length == 1) {
						if(p.hasPermission("CraftDreams.Clear.Other")) {
						Player p2 = Bukkit.getPlayer(args[0]);
						if(p2 != null) {
							p2.getInventory().clear();
							p.sendMessage(Main.pr + "Du hast das Inventar von §b" + p2.getName() + " §5gelerrt.");
						} else {
							p.sendMessage(Main.pr + "Der Spieler ist nicht online.");
						}
						} else {
							p.sendMessage(Main.noperm);
						}
					}
				
				
			} else {
				s.sendMessage("Du musst ein Spieler sein.");
			}
		
		return false;
	}
	

}
