package de.Felxq.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.Felxq.Economy_API.EconomyAPI;
import de.Felxq.JobSystem.JobAPI;
import de.Felxq.JobSystem.JobManager;


public class JoinListener implements Listener {
	
		@EventHandler
		public void onJoin(PlayerJoinEvent e) {
			Player p = e.getPlayer();
			if(JobAPI.getJobName(p.getUniqueId().toString()) == "Unbekannt") {
				JobManager.setArbeitslos(p);
			}
			
			e.setJoinMessage("§8[§e+§8] §e" + p.getName());
			
			if(!p.hasPlayedBefore()) {
				EconomyAPI.setMoney(p.getUniqueId().toString(), 500);
				
				JobAPI.setJob(p.getUniqueId().toString(), "Arbeitslos", 0);
				
			}	
		}
}
