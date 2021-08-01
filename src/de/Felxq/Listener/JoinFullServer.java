package de.Felxq.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class JoinFullServer implements Listener {
	
	  @EventHandler
	  public void on(PlayerLoginEvent e) {
	    Player p = e.getPlayer();
	    if ((e.getResult().equals(PlayerLoginEvent.Result.KICK_FULL)) && 
	      (p.hasPermission("CraftDreams.JoinFullServer"))) {
	      e.allow();
	    }
	  }
	}

