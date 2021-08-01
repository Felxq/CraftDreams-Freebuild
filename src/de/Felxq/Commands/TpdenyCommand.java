package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Data;

public class TpdenyCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p  = (Player)sender;
			if(args.length == 0) {
			if(Data.canaccept.contains(p.getName())) {
				Data.canaccept.remove(p.getName());
				Player p2 = Bukkit.getPlayer(Data.locatio.get(p.getName()));
				
				p2.sendMessage(Data.Prefix + " Der Spieler §b"+p.getName()+" §5hat deine teleportations Anfrage §cabgelehnt");
				p.sendMessage(Data.Prefix + " Du hast die teleportations Anfrage von §b"+Data.locatio.get(p.getName())+" §cabgelehnt");
				
				
			}else {
				p.sendMessage(Data.Prefix + " Es gibt derzeit keine teleportations Anfrage die du ablehnen kannst!");
			}
			}else {
				p.sendMessage(Data.Prefix + " Benutze /tpdeny");
			}
			
		}else {
			
		}
		return true;
	}

	
}
