package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;




public class cc_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
        if (s.hasPermission("CraftDreams.ClearChat")) {
            if (args.length != 0) {
                s.sendMessage(Main.pr + "§cVerwende /cc");
            } else {
                int i = 0;
                while (i < 200) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(" ");
                    }
                    ++i;
                }
                for (Player all : Bukkit.getOnlinePlayers()) {
                	all.sendMessage("");
                    all.sendMessage("§5Der Chat wurde von §b" + p.getName() + " §5gelerrt.");
                	all.sendMessage("");
                }
            }
        } else {
            s.sendMessage(Main.noperm);
        }
 



		return false;
	}
	

}
