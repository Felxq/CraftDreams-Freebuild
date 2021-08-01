package de.Felxq.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Economy_API.EconomyAPI;
import de.Felxq.Main.Main;

public class money_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		if(!(s instanceof Player)) {
			s.sendMessage("Du musst ein Spieler sein!");
		} else {
			Player p = (Player)s;
			p.sendMessage(Main.pr + "Dein Kontostand beträgt derzeit §b" + EconomyAPI.getMoney(p.getUniqueId().toString()) + "€§5.");
		}
		return false;
	}

}
