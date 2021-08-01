package de.Felxq.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class ShopVillager_Inventory_Page1 implements Listener {
	
	public static Inventory MainShop = Bukkit.createInventory(null, 45, "§6Shop §c»");

	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = null;
		if(e.getWhoClicked() instanceof Player) {
			p = (Player) e.getWhoClicked();
		}
		
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().hasItemMeta()) {
					
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c» §bTest")) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1, 1);
					}
				}
			}
	}
}
