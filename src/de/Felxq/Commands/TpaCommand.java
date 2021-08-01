package de.Felxq.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Felxq.Main.Data;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TpaCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 1) {
				
				Player p2 = Bukkit.getPlayer(args[0]);
				
				if(p2 != null ) {
					if(!(p2.getName() == p.getName())) {
						
					Data.canaccept.add(p2.getName());
					Data.locatio.put(p2.getName(), p.getName());
					
					
		               TextComponent tc = new TextComponent();
		                tc.setText("§5Diese kannst du mit §a/tpaccept §5annehmen ");
		                tc.setClickEvent(new ClickEvent(Action.RUN_COMMAND,"/tpaccept"));
		                tc.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aAkzeptiere die teleportations Anfrage.").create()));
		                
		               TextComponent tc2 = new TextComponent();
		                tc2.setText("§5oder §5mit §c/tpdeny §5ablehnen.");
		                tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND,"/tpdeny"));
		                tc2.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cLehne die teleportations Anfrage ab.").create()));
		                
		                tc.addExtra(tc2);

					p2.sendMessage(Data.Prefix + " Der Spieler §b"+p.getName()+" §5hat dir eine teleportations Anfrage gesendet!");
					//p2.sendMessage(Data.Prefix + " Diese kannst du mit §a" + tc.getInsertion() + " §5oder mit §c" + tc2.getInsertion() + " §5annehmen oder ablehnen");
					p2.spigot().sendMessage(tc);
					
					
					p.sendMessage(Data.Prefix + " Du hast dem Spieler §b"+p2.getName()+" §5eine teleportations Anfrage gesendet!");
					}else {
						p.sendMessage(Data.Prefix + " Du kannst dir selbst keine teleportations Anfrage senden!");
					}
					
					
					
					
					
					
					
					
					
					
				}else {
					p.sendMessage(Data.Prefix + " Dieser Spieler ist nicht online!");
				}
				
				
				
			}else {
				p.sendMessage(Data.Prefix + " Benutze /tpa <Spieler>");
			}
			
			
		}else{
			
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
