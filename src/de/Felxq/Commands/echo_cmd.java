package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.Felxq.Economy_API.EconomyAPI;
import de.Felxq.Main.Main;

public class echo_cmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		if(s.hasPermission("CraftDreams.Money.Manipulate")) {
			if(args.length == 0) {
				s.sendMessage(Main.pr + "Benutze §b/echo <Spieler> <add,remove,set,clear> <Betrag>");
			} else if(args.length == 1) {
				s.sendMessage(Main.pr + "Benutze §b/echo <Spieler> <add,remove,set,clear> <Betrag>");
			} else if(args.length == 2) {
				if(args[1].equalsIgnoreCase("clear")) {
					if(Bukkit.getPlayer(args[0]) != null) {
						EconomyAPI.setMoney(Bukkit.getPlayer(args[0]).getUniqueId().toString(), 0);
						s.sendMessage(Main.pr + "Der Spieler §b" + args[0] + " §5hat nun einen Kontostand von §b0€");
					} else {
						s.sendMessage(Main.pr + "Der Spieler ist nicht online.");
					}
				} else {
					s.sendMessage(Main.pr + "Benutze §b/echo <Spieler> <add,remove,set,clear> <Betrag>");
				}
			} else if(args.length == 3) {
				if(args[1].equalsIgnoreCase("add")) {
					double num = Double.parseDouble(args[2]);
					EconomyAPI.addMoney(Bukkit.getPlayer(args[0]).getUniqueId().toString(), num);
					s.sendMessage(Main.pr + "Dem Spieler §b" + args[0] + " §5wurden §b" + num + "€ §5hinzugefügt!");
				} else if(args[1].equalsIgnoreCase("remove")) {
					double num = Double.parseDouble(args[2]);
					EconomyAPI.removeMoney(Bukkit.getPlayer(args[0]).getUniqueId().toString(), num);
					s.sendMessage(Main.pr + "Dem Spieler §b" + args[0] + " §5wurden §b" + num + "€ §5abgezogen!");
				} else if(args[1].equalsIgnoreCase("set")) {
					double num = Double.parseDouble(args[2]);
					EconomyAPI.setMoney(Bukkit.getPlayer(args[0]).getUniqueId().toString(), num);
					s.sendMessage(Main.pr + "Der Spieler §b" + args[0] + " §5hat nun einen Kontostand von §b" + num + "€");
				} else {
					s.sendMessage(Main.pr + "Benutze §b/echo <Spieler> <add,remove,set,clear> <Betrag>");
				}
			}
		} else {
			s.sendMessage(Main.noperm);
		}
		return false;
	}
	

}
