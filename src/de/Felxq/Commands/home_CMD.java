package de.Felxq.Commands;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;



public class home_CMD implements CommandExecutor {
	
	public static File Homes = new File("plugins//CraftDreams//Homes.yml");
	@SuppressWarnings("static-access")
	public static YamlConfiguration hcfg = new YamlConfiguration().loadConfiguration(Homes);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			Player player = (Player)sender;
            if(hcfg.isSet(String.valueOf(player.getUniqueId()))) {
                
    			if(hcfg.isSet(String.valueOf(player.getUniqueId())));
                String s = hcfg.getString(String.valueOf(player.getUniqueId()));
                int x = Integer.valueOf(s.split(" ")[0]).intValue();
                int y = Integer.valueOf(s.split(" ")[1]).intValue();
                int z = Integer.valueOf(s.split(" ")[2]).intValue();
                World world = Bukkit.getWorld(UUID.fromString(s.split(" ")[3]));
                
                Location loc = new Location(world, x, y, z);
                player.teleport(loc);
                player.sendMessage(Main.pr + "Du wurdest zu deinem Zuhause teleportiert.");
            } else {
            	player.sendMessage(Main.pr + "Du hast bisher noch kein Zuhause gesetzt!");
            }
            

            

            
	  return false;
	}
}
