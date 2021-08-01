package de.Felxq.JobSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Job_Inventory_Page2 implements Listener {

	@EventHandler
	public void onBerufInvClick(InventoryClickEvent e) {
		Player p = null;
		if(e.getWhoClicked() instanceof Player) {
			p = (Player) e.getWhoClicked();
		}
		
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().hasItemMeta()) {
				
				
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§0§kLLL")) {
					e.setCancelled(true);
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bFarmer")) {
					e.setCancelled(true);
					JobManager.setJob(p, "Farmer", 0);
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bFischer")) {
					e.setCancelled(true);
					JobManager.setJob(p, "Fischer", 0);
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bMinenarbeiter")) {
					e.setCancelled(true);
					JobManager.setJob(p, "Minenarbeiter", 0);
				}
				}
			}
	}
	
}
