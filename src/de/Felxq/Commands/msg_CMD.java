package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class msg_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if(args.length >= 2) {
			String msg = "";
			Player p2 = Bukkit.getPlayer(args[0]);
			if(p2 != null) {
				if(p2 !=sender) {
					
					for (int i = 1; i<args.length; i++) {
						msg = msg + args[i]+ " ";
				}
					p2.sendMessage("§7[§bNachricht§7]" + " §7[" + sender.getName() + " §7» Dir] §b" + msg);
					sender.sendMessage("§7[§bNachricht§7]" +  " §7[Du » " + p2.getName() + "§7] §b" + msg);
					
					for(Player all: Bukkit.getOnlinePlayers()) {
						if(spy_CMD.spylist.contains(all)) {
							all.sendMessage("§cSPY §7[§bNachricht§7]" + " §7[" + sender.getName() + " §7» " + p2.getName() + "§7] §b" + msg);
						}
					}
				} else {
					sender.sendMessage(Main.pr + "Du kannst dir selbst keine Nachricht schreiben!");
				}

			} else sender.sendMessage(Main.pr + " Dieser Spieler ist nicht Online!"); 
			return false;
			
		} else {
			sender.sendMessage(Main.pr + " Benutze: §7/msg §3<§2Spieler§3> <§2Nachricht§3>");
			return false;
			}
	}

}
