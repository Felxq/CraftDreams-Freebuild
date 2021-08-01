package de.Felxq.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatListener implements Listener {
	
	@EventHandler
	public void PlayerChatPrefix(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		
		if(PermissionsEx.getUser(p).inGroup("Admin")) {
			e.setFormat("§4Admin §7• §4" + p.getName() + " §b» §3" + msg);
		} else
			if(PermissionsEx.getUser(p).inGroup("Developer")) {
				e.setFormat("§bDeveloper §7• §b" + p.getName() + " §b» §3" + msg);	
		} else
			if(PermissionsEx.getUser(p).inGroup("Moderator")) {
				e.setFormat("§cModerator §7• §c" + p.getName() + " §b» §3" + msg);
		} else
			if(PermissionsEx.getUser(p).inGroup("Supporter")) {
				e.setFormat("§9Supporter §7• §9" + p.getName() + " §b» §3" + msg);
		} else
			if(PermissionsEx.getUser(p).inGroup("Builder")) {
				e.setFormat("§6Builder §7• §6" + p.getName() + " §b» §3" + msg);
		} else
			if(PermissionsEx.getUser(p).inGroup("Dreamer")) {
				e.setFormat("§5Dreamer §7• §5" + p.getName() + " §b» §3" + msg);
		} else
			if(PermissionsEx.getUser(p).inGroup("Donator")) {
				e.setFormat("§6* §7" + p.getName() + " §b» §3" + msg);
		} else {
				e.setFormat("§7" + p.getName() + " §b» §3" + msg);
		}
} 
}