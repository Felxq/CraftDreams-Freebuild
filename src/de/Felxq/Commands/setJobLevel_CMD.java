package de.Felxq.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.JobSystem.JobManager;
import de.Felxq.Main.Main;

public class setJobLevel_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		Player p = (Player)s;
		if(s.hasPermission("CraftDreams.Debug.Admin")) {
			
			
			if(args.length == 0) {
				s.sendMessage(Main.pr + "Benutze §b/setJobLevel <Level>");
			} else if(args.length == 1) {
				if(args[0].equals("0") || args[0].equals("1") || args[0].equals("2") || args[0].equals("3") || args[0].equals("4") || args[0].equals("5")) {
					
					try {
					    int number = Integer.parseInt(args[0]); // Use number for your usage

						JobManager.setJobLevel(p, number);
						p.sendMessage(Main.pr + "Dein Beruf's Level beträgt nun: §b" + number);
					} catch (NumberFormatException error) { // This will catch the error if someone put not an Integer at args[1]
					    System.out.println(error);
					}
					
	
				} else {
					p.sendMessage(Main.pr + "Benutze die Zahlen von 0-5."); 
				}
			}
		}

		
		
		return false;
	}

}
