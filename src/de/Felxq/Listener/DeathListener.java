package de.Felxq.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.Felxq.Main.Main;


public class DeathListener implements Listener {
	
	
			@EventHandler
			public void onDeath(PlayerDeathEvent e) {
				Player p = (Player) e.getEntity();
				e.setDeathMessage(null);
				p.sendMessage(Main.pr + "Du bist gestorben.");
				
			}
			
			@EventHandler
			public void onRespawn(PlayerRespawnEvent e) {
				World w = Bukkit.getServer().getWorld(Main.cfg.getString("Spawn.World"));
				double x = Main.cfg.getDouble("Spawn.X");
				double y = Main.cfg.getDouble("Spawn.Y");
				double z = Main.cfg.getDouble("Spawn.Z");
				double yaw = Main.cfg.getDouble("Spawn.Yaw");
				double pitch = Main.cfg.getDouble("Spawn.Pitch");
				
				Location Spawn = new Location(w, x, y, z, (float) yaw, (float) pitch);
				e.setRespawnLocation(Spawn);
			}

}
