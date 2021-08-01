package de.Felxq.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class day_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
		if(s instanceof Player) {
			if(p.hasPermission("CraftDreams.Day")) {
				p.getWorld().setTime(0);
				p.sendMessage(Main.pr + "Es ist nun Tag in §b" + p.getLocation().getWorld().getName());
			} else {
				p.sendMessage(Main.noperm);
			}
		} else {
			s.sendMessage("Du musst ein Spieler sein.");
		}

		return false;
	}
	
	

}
