package de.Felxq.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class setspawn_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		
				Player p = (Player)s;
				if(p.hasPermission("CraftDreams.Admin")) {
				Main.cfg.set("Spawn.World", p.getWorld().getName());
				Main.cfg.set("Spawn.Y", p.getLocation().getY());
				Main.cfg.set("Spawn.X", p.getLocation().getX());
				Main.cfg.set("Spawn.Z", p.getLocation().getZ());
				Main.cfg.set("Spawn.Yaw", p.getLocation().getYaw());
				Main.cfg.set("Spawn.Pitch", p.getLocation().getPitch());
				
				p.sendMessage(Main.pr + "Die Spawn Location wird abgespeichert");
				
				try {
					Main.cfg.save(Main.Spawn);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				p.sendMessage(Main.pr + " Die Location wurde gespeichert. Reloade nun den Server um /spawn nutzen zu können.");
			} else {
					p.sendMessage(Main.noperm);
				}
		
		return false;
	}
	

}
