package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Economy_API.EconomyAPI;
import de.Felxq.Main.Main;

public class pay_CMD implements CommandExecutor {
	

	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
		if(!(s instanceof Player)) {
			s.sendMessage("Du musst ein Spieler sein!");
		} else {
			if(args.length == 0) {
				p.sendMessage(Main.pr + "Benutze §b/pay <Spieler> <Betrag>§5.");
			} else if(args.length == 1) {
				p.sendMessage(Main.pr + "Benutze §b/pay <Spieler> <Betrag>§5.");
				
			} else if(args.length == 2) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target != p) {
						double num = Integer.parseInt(args[1]);
						double having = EconomyAPI.getMoney(p.getUniqueId().toString());
						double missing = num - having;
						if(num <= EconomyAPI.getMoney(p.getUniqueId().toString())) {
							EconomyAPI.removeMoney(p.getUniqueId().toString(), num);
							EconomyAPI.addMoney(target.getUniqueId().toString(), num);
							
							p.sendMessage(Main.pr + "Du hast dem Spieler §b" + target.getName() + " " + num +"€ §5überwiesen.");
							target.sendMessage(Main.pr + "Du hast von dem Spieler §b" + p.getName() + " " + num +"€ §5überwiesen bekommen.");
						} else {
							p.sendMessage(Main.pr + "Du hast nicht genügend Geld! §5Dir fehlen §c" + missing + "€");
						}
					} else {
						p.sendMessage(Main.pr + "Du kannst dir selbst kein Geld überweisen.");
					}
				} else {
					p.sendMessage(Main.pr + "Der Spieler ist nicht online!");
				}
			} else {
				p.sendMessage(Main.pr + "Benutze §b/pay <Spieler> <Betrag>§5.");
			}
		}
		
		
		return false;
	}
	

}
