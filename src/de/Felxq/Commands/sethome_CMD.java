package de.Felxq.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class sethome_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		if(!(s instanceof Player)) {
			s.sendMessage("Du musst ein Spieler sein!");
		} else {
			Player player = (Player)s;
			if(args.length == 0) {
				home_CMD.hcfg.set(player.getUniqueId().toString(), player.getLocation().getBlockX() + " " + player.getLocation().getBlockY() + " " + player.getLocation().getBlockZ() + " " + player.getLocation().getWorld().getUID().toString());

				
				try {
					home_CMD.hcfg.save(home_CMD.Homes);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				player.sendMessage(Main.pr + "Dein Zuhause wurde erfolgreich gesetzt!");
			}
		}
		return false;
	}

}
