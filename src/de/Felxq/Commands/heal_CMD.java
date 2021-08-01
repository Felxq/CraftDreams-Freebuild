package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class heal_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
			Player p = (Player)s;
				if(p.hasPermission("CraftDreams.Heal")) {
					if(args.length == 0) {
						p.setHealth(20);
						p.setFoodLevel(20);
						p.sendMessage(Main.pr + "Du wurdest erfolgreich geheilt.");
					} else if(args.length == 1) {
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							target.setHealth(20);
							target.setFoodLevel(20);
							p.sendMessage(Main.pr + "Du hast den Spieler §b" + target.getName() + " §5geheilt.");
						} else {
							p.sendMessage(Main.pr + "Der Spieler ist nicht online.");
						}
					}
				} else {
					p.sendMessage(Main.noperm);
				}

		return false;
	}

}
