package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Main;


public class invsee_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
			Player p = (Player)s;
			   if(p.hasPermission("CraftDreams.Invsee")){
                   
                   if(args.length == 1){
                           if(s instanceof Player){
                           String name = args[0];
                           if(Bukkit.getPlayer(name) == null){
                                   p.sendMessage(Main.pr + "Der Spieler ist nicht Online!");
                                   return false;
                           }
                           Player target = Bukkit.getPlayer(name);
                           if(p == target){
                                   p.sendMessage(Main.pr + "Du kannst nicht dein eigenes Inventar angucken!");
                                   return false;
                           }
                           p.openInventory(target.getInventory());
                           return true;
                           }else{
                                   s.sendMessage("Du musst ein Spieler sein!");
                           }
                   } else {
                           p.sendMessage(Main.pr + "Benutze §b/invsee §3<§bSpieler§3>");
                   }
                   } else {
                           p.sendMessage(Main.noperm);
                   }
   
          
           return false;
   }
  
}