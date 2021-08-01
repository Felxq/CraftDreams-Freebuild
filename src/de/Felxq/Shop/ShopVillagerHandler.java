package de.Felxq.Shop;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import de.Felxq.Main.Main;

public class ShopVillagerHandler implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(p.hasPermission("CraftDreams.Admin")) {
				if(args.length == 0) {
					
					new ShopVillager(p.getLocation());
					p.sendMessage(Main.pr + "Der Shop " + ShopVillager.VILLAGER_NAME + " §5wurde erfolgreich erstellt!");
					
				} else {
					p.sendMessage(Main.pr + "Du darfst keine Argumente benutzen!");
				}
			} else {
				p.sendMessage(Main.noperm);
			}
		}
		return false;
	}
	
	@EventHandler
	public void handleShopInteract(PlayerInteractEntityEvent event) {
		if(!(event.getRightClicked() instanceof Villager)) return;
		Villager shop = (Villager) event.getRightClicked();
		
		if(shop.getCustomName().equals(ShopVillager.VILLAGER_NAME)) {
			event.setCancelled(true);
			Player p = event.getPlayer();
			p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
			p.openInventory(ShopVillager_Inventory_Page1.MainShop);
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void handleShopDamage(EntityDamageByEntityEvent event) {
		if(!(event.getEntity() instanceof Villager)) return;
		Villager shop = (Villager) event.getEntity();
		if(!shop.getCustomName().equals(ShopVillager.VILLAGER_NAME)) return;
		
		event.setCancelled(true);
		
		if(!(event.getDamager() instanceof Player)) return;
		Player p = (Player) event.getDamager();
		if(p.hasPermission("CraftDreams.Admin")) {
			if(p.getItemInHand().getType() == Material.NETHER_STAR) {
				shop.setHealth(0);
				p.sendMessage(Main.pr + "Du hast den Shop entfernt!");
			}
		}
	}
	

}
