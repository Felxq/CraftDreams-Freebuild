package de.Felxq.Commands;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class spawn_CMD implements CommandExecutor {
	
	ArrayList<String> spawnTeleport = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
			Player p = (Player)s;

			if(!spawnTeleport.contains(p.getName())) {
				World w = Bukkit.getServer().getWorld(Main.cfg.getString("Spawn.World"));
				double x = Main.cfg.getDouble("Spawn.X");
				double y = Main.cfg.getDouble("Spawn.Y");
				double z = Main.cfg.getDouble("Spawn.Z");
				double yaw = Main.cfg.getDouble("Spawn.Yaw");
				double pitch = Main.cfg.getDouble("Spawn.Pitch");
				
				Location Spawn = new Location(w, x, y, z, (float) yaw, (float) pitch);
				
				
				try {
					Main.cfg.load(Main.Spawn);
				} catch (IOException | InvalidConfigurationException e) {
					e.printStackTrace();
				}
				
			
			p.sendMessage(Main.pr + "Du wirst in 5 Sekunden zum Spawn teleportiert.");
			spawnTeleport.add(p.getName());
				
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
	                   
	                @Override
	                public void run() {
	                	
	                	
	                	p.teleport(Spawn);
	                	p.sendMessage(Main.pr + "Du wurdest zum Spawn teleportiert.");
	                	spawnTeleport.remove(p.getName());
	                }
	        }, 20*5);
		} else {
			p.sendMessage(Main.pr + "Du befindest dich bereits in einem Teleportations Vorgang.");
		}

				
			

		return false;
	}
	

}
