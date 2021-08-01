package de.Felxq.Team;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class login_CMD implements CommandExecutor {

	public static ArrayList<String> TeamLogin = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;

		if(!(s instanceof Player)) {
			s.sendMessage("Du musst ein Spieler sein!");
		} else {
				if(args.length == 0) {
					
				} else if(args.length == 1) {
					if(p.hasPermission("CraftDreams.Team")) {
						if(args[0].equalsIgnoreCase("logout")) {
							if(TeamLogin.contains(p.getName())) {
								TeamLogin.remove(p.getName());
								p.sendMessage(Main.pr + "Du hast dich erfolgreich abgemeldet!");
							} else {
								p.sendMessage(Main.pr + "Du bist bereits abgemeldet! Melde dich mit §b/team login §5 an.");
							}
						} else if(args[0].equalsIgnoreCase("login")) {
							if(TeamLogin.contains(p.getName())) {
								p.sendMessage(Main.pr + "Du bist bereits angemeldet! Melde dich mit §b/team logout §5ab.");
							} else {
								TeamLogin.add(p.getName());
								p.sendMessage(Main.pr + "Du hast dich erfolgreich angemeldet!");
							}
						}
					} else {
						p.sendMessage(Main.noperm);
					}
			}
		}
		return false;
	}

}
