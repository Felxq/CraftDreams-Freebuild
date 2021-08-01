package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Data;


public class TpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("tp")) {
				
				if(p.hasPermission("CraftDreams.TP")) {
					
					
					
					if(args.length == 1) {
						Player p2 = Bukkit.getPlayer(args[0]);
						
						if(p2 != null) {
							if(p2 != p) {

								p.teleport(p2.getLocation());
								p.sendMessage(Data.Prefix + " Du wurdest erfolgreich zu §b"+p2.getName()+" §5teleportiert");
								
							} else {
								p.sendMessage(Data.Prefix + " Du kannst dich nicht zu dir selbst teleportieren.");
							}
							
							
							
							
							
						}else {
							p.sendMessage(Data.Prefix + " Dieser Spieler ist zurzeit nicht online!");
						}
						
						
						
						
					}else if(args.length == 2) {
						///tp <teleporter> <teleporteter>
						Player teleporter = Bukkit.getPlayer(args[0]);
						Player teleporteter = Bukkit.getPlayer(args[1]);
						
						teleporter.teleport(teleporteter.getLocation());
						
						
						teleporteter.sendMessage(Data.Prefix + " Du wurdest zu §b"+teleporter.getName()+" §5teleportiert");
						
						
						
						
						
					
					}else {
						p.sendMessage(Data.Prefix + " Benutze /tp <Spieler> oder /tp <Spieler> <Spieler>");
					}
					
					
					
					
					
				}else {
					p.sendMessage(Data.NoPerm);
				}
				
				
				
				
				
			}
			
			
			
		}else{
			
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
