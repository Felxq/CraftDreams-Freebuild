package de.Felxq.Main;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryManager {
	
	public void firstLogin(Player p) {
		
			p.getInventory().clear();
			
			p.getInventory().setItem(0, createItem(Material.STONE_SWORD, 1, 0, "§3Steinschwert", ""));
			p.getInventory().setItem(1, createItem(Material.STONE_PICKAXE, 1, 0, "§3Steinspitzhacke", ""));
			p.getInventory().setItem(2, createItem(Material.STONE_AXE, 1, 0, "§3Steinaxt", ""));
			p.getInventory().setItem(3, createItem(Material.STONE_SHOVEL, 1, 0, "§3Steinschaufel", ""));
			p.getInventory().setItem(7, createItem(Material.BREAD, 16, 0, "§3Heiliges Brot", ""));
				}
	

			
			public static ItemStack createItem(Material material, int anzahl, int shortid, String disyplayname, String lore) {
				@SuppressWarnings("deprecation")
				ItemStack i = new ItemStack(material, anzahl, (short) shortid);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName(disyplayname);
				im.setLore(Arrays.asList(lore));
				i.setItemMeta(im);
				
				return i;
			}

}
