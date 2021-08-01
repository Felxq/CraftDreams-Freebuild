package de.Felxq.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class spy_CMD implements CommandExecutor {
	
	public static ArrayList<Player> spylist = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
		if(s instanceof Player) {
			if(p.hasPermission("CraftDreams.Spy")) {
				if(spylist.contains(p)) {
					spylist.remove(p);
					p.sendMessage(Main.pr + "Du kannst nun keine privaten Nachrichten mehr mit lesen!");
				} else {
					spylist.add(p);
					p.sendMessage(Main.pr + "Du kannst nun private Nachrichten mit lesen!");
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
