package de.Felxq.JobSystem;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Job_Inventory_Page1 implements Listener {
	
	@EventHandler
	public void onJobInvClick(InventoryClickEvent e) {
		Player p = null;
		if(e.getWhoClicked() instanceof Player) {
			p = (Player) e.getWhoClicked();
		}
		
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().hasItemMeta()) {
				
				
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bDein Beruf")) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§0§kLLL")) {
					e.setCancelled(true);
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bWähle einen Beruf")) {
					//Page2
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
					p.openInventory(job_CMD.chooseJob);
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bLevel kaufen")) {
					//Page3
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
					p.openInventory(job_CMD.lvlup);
				}
				}
			}
	}
}
