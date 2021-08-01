package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Data;


public class TpacceptCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender instanceof Player) {
			
			Player p = (Player)sender;
			if(args.length == 0) {
				
				if(Data.canaccept.contains(p.getName())) {
					Data.canaccept.remove(p.getName());
					
					Player p2 = Bukkit.getPlayer(Data.locatio.get(p.getName()));
					p2.sendMessage(Data.Prefix + " Du wirst zu §b"+p.getName()+" §5teleportiert.");
					p2.teleport(p.getLocation());
					Data.locatio.remove(p.getName());
					p.sendMessage(Data.Prefix + " Der Spieler §b"+p2.getName()+" §5wurde erfolgreich zu dir teleportiert");
					
					
				}else {
					p.sendMessage(Data.Prefix + " Es gibt derzeit keine teleportations Anfrage die du annehmen kannst!");
				}
				
				
				
			}else {
				p.sendMessage(Data.Prefix + " /tpaccept");
			}
			
			
			
			
			
			
			
		}
		
		
		return true;
	}
	
	
	

}
