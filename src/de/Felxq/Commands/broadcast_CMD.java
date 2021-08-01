package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;




public class broadcast_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			
        if (sender.hasPermission("CraftDreams.BroadCast")) {
            if (args.length == 0) {
                sender.sendMessage(Main.pr + "Verwende §c/bc <Nachricht>");
            } else if (args.length >= 1) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (i < args.length) {
                    sb.append(String.valueOf(args[i]) + " ");
                    ++i;
                }
                String st = sb.toString();
                for (Player all : Bukkit.getOnlinePlayers()) {
                	all.sendMessage("");
                    all.sendMessage(Main.pr + st.replace("&", "\u00a7"));
                    all.sendMessage("");
                }
            }
        } else {
            sender.sendMessage(Main.noperm);
        }

		return false;
	}
	

}
