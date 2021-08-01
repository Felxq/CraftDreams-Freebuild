package de.Felxq.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class gm_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
		if(p.hasPermission("CraftDreams.GameMode")) {
			if(args.length == 0) {
				p.sendMessage(Main.pr + "Benutze /gm §b<0,1,2,3>");
			} else if(args.length == 1) {
				if(args[0].equals("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(Main.pr + "Du bist nun im Überlebens Modus.");
				} else if(args[0].equals("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(Main.pr + "Du bist nun im Kreativen Modus.");
				} else if(args[0].equals("2")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(Main.pr + "Du bist nun im Abenteuer Modus.");
				} else if(args[0].equals("3")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(Main.pr + "Du bist nun im Zuschauer Modus.");
					
				}
			}
		} else {
			p.sendMessage(Main.noperm);
		}

		return false;
	}

}
