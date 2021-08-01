package de.Felxq.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.Felxq.Team.login_CMD;

public class QuitListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§8[§c-§8] §c" + p.getName());
		
		if(login_CMD.TeamLogin.contains(p.getName())) {
			login_CMD.TeamLogin.remove(p.getName());
		}
	}

}
