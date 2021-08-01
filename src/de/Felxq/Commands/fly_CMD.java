package de.Felxq.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class fly_CMD implements CommandExecutor {
	
		public static ArrayList<Player> flylist = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
			if(s instanceof Player) {
				Player p = (Player)s;
					if(p.hasPermission("CraftDreams.Fly")) {
						if(!flylist.contains(p)) {
							flylist.add(p);
							p.sendMessage(Main.pr + "Du kannst nun Fliegen.");
							p.setAllowFlight(true);
							p.setFlying(true);
						} else {
							flylist.remove(p);
							p.sendMessage(Main.pr + "Du kannst nun nicht mehr Fliegen.");
							p.setAllowFlight(false);
							p.setFlying(false);
						}
					} else {
						p.sendMessage(Main.noperm);
					}
			} else {
				s.sendMessage("Du musst ein Spieler sein.");
			}

		return false;
	}

}
