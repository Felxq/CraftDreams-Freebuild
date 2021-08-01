package de.Felxq.Main;


import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.Felxq.JobSystem.job_CMD;
import de.Felxq.Shop.ShopVillager_Inventory_Page1;

public class befüllen {
	
		@SuppressWarnings("deprecation")
		public static void fill() {
			
			//SHOP
			ItemStack bowshop = new ItemStack(Material.BOW);
			ItemMeta bowMeta = bowshop.getItemMeta();
			bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
			bowMeta.setDisplayName("§c» §bTest");
			bowshop.setItemMeta(bowMeta);
			
			ShopVillager_Inventory_Page1.MainShop.setItem(11, bowshop);
			
			
			//JOB
			@SuppressWarnings("deprecation")
			ItemStack cover = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta cMeta = cover.getItemMeta();
			cMeta.setDisplayName("§0§kLLL");
			cover.setItemMeta(cMeta);
			//Page
			job_CMD.JobGUI.setItem(0, cover);
			job_CMD.JobGUI.setItem(1, cover);
			job_CMD.JobGUI.setItem(2, cover);
			job_CMD.JobGUI.setItem(3, cover);
			job_CMD.JobGUI.setItem(4, cover);
			job_CMD.JobGUI.setItem(5, cover);
			job_CMD.JobGUI.setItem(6, cover);
			job_CMD.JobGUI.setItem(7, cover);
			job_CMD.JobGUI.setItem(8, cover);
			
			job_CMD.JobGUI.setItem(9, cover);
			
			job_CMD.JobGUI.setItem(11, cover);

			job_CMD.JobGUI.setItem(13, cover);
			job_CMD.JobGUI.setItem(15, cover);
			job_CMD.JobGUI.setItem(17, cover);
			job_CMD.JobGUI.setItem(18, cover);
			job_CMD.JobGUI.setItem(19, cover);
			job_CMD.JobGUI.setItem(20, cover);
			job_CMD.JobGUI.setItem(21, cover);
			job_CMD.JobGUI.setItem(22, cover);
			job_CMD.JobGUI.setItem(23, cover);
			job_CMD.JobGUI.setItem(24, cover);
			job_CMD.JobGUI.setItem(25, cover);
			job_CMD.JobGUI.setItem(26, cover);
			
			//Page2
			job_CMD.chooseJob.setItem(0, cover);
			job_CMD.chooseJob.setItem(1, cover);
			job_CMD.chooseJob.setItem(3, cover);
			job_CMD.chooseJob.setItem(5, cover);
			job_CMD.chooseJob.setItem(7, cover);
			job_CMD.chooseJob.setItem(8, cover);
			
			//Page3
			job_CMD.lvlup.setItem(1, cover);
			job_CMD.lvlup.setItem(3, cover);
			job_CMD.lvlup.setItem(5, cover);
			job_CMD.lvlup.setItem(7, cover);
			
			
			ItemStack lvl1 = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta lvl1Meta = (SkullMeta) lvl1.getItemMeta();
			lvl1Meta.setOwner("Felxq");
			lvl1Meta.setDisplayName("§c» §bLevel 1 - 500€");
			ArrayList<String> lorelvl1 = new ArrayList<String>();
			lorelvl1.add("§3Levele deinen Beruf auf das Level 1!");
			lvl1Meta.setLore(lorelvl1);
			lvl1.setItemMeta(lvl1Meta);
			job_CMD.lvlup.setItem(0, lvl1);
			
			ItemStack lvl2 = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta lvl2Meta = (SkullMeta) lvl2.getItemMeta();
			lvl2Meta.setOwner("Felxq");
			lvl2Meta.setDisplayName("§c» §bLevel 2 - 750€");
			ArrayList<String> lorelvl2 = new ArrayList<String>();
			lorelvl2.add("§3Levele deinen Beruf auf das Level 2!");
			lvl2Meta.setLore(lorelvl2);
			lvl2.setItemMeta(lvl2Meta);
			job_CMD.lvlup.setItem(2, lvl2);
			
			ItemStack lvl3 = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta lvl3Meta = (SkullMeta) lvl3.getItemMeta();
			lvl3Meta.setOwner("Felxq");
			lvl3Meta.setDisplayName("§c» §bLevel 3 - 1000€");
			ArrayList<String> lorelvl3 = new ArrayList<String>();
			lorelvl3.add("§3Levele deinen Beruf auf das Level 3!");
			lvl3Meta.setLore(lorelvl3);
			lvl3.setItemMeta(lvl3Meta);
			job_CMD.lvlup.setItem(4, lvl3);
			
			ItemStack lvl4 = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta lvl4Meta = (SkullMeta) lvl4.getItemMeta();
			lvl4Meta.setOwner("Felxq");
			lvl4Meta.setDisplayName("§c» §bLevel 4 - 1250€");
			ArrayList<String> lorelvl4 = new ArrayList<String>();
			lorelvl4.add("§3Levele deinen Beruf auf das Level 4!");
			lvl4Meta.setLore(lorelvl4);
			lvl4.setItemMeta(lvl4Meta);
			job_CMD.lvlup.setItem(6, lvl4);
			
			ItemStack lvl5 = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta lvl5Meta = (SkullMeta) lvl5.getItemMeta();
			lvl5Meta.setOwner("Felxq");
			lvl5Meta.setDisplayName("§c» §bLevel 5 - 1500€");
			ArrayList<String> lorelvl5 = new ArrayList<String>();
			lorelvl5.add("§3Levele deinen Beruf auf das Level 5!");
			lvl5Meta.setLore(lorelvl5);
			lvl5.setItemMeta(lvl5Meta);
			job_CMD.lvlup.setItem(8, lvl5);
			
			/**
			 SkullOwner:{Id:"e4e58ac7-b628-40f1-a7eb-44f281a5e336",Properties:{textures:[{Value:"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmY5Njk0YTUyMjEyNzE5ZTExM2RjN2U2YWY2OThhOWZjM2FiNjNjNzQ5OTVmZmFkYzU3ZDM0NmZhY2U0ZTc1In19fQ=="}]}}} 1  
			 
			  
			**/
			
			ItemStack chooseJob = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta cJMeta = (SkullMeta) chooseJob.getItemMeta();
			cJMeta.setOwner("Minecat9000");
			cJMeta.setDisplayName("§c» §bWähle einen Beruf");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("§3Du kannst deinen Beruf im nachhinein noch wechseln!");
			cJMeta.setLore(lore);
			chooseJob.setItemMeta(cJMeta);
			job_CMD.JobGUI.setItem(12, chooseJob);
			
			ItemStack buylvl = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta buylvlMeta = (SkullMeta) buylvl.getItemMeta();
			buylvlMeta.setOwner("jdogduffy");
			buylvlMeta.setDisplayName("§c» §bLevel kaufen");
			ArrayList<String> lore2 = new ArrayList<String>();
			lore2.add("§3Hier kannst du mit deinem verdientem Geld Level kaufen.");
			buylvlMeta.setLore(lore2);
			buylvl.setItemMeta(buylvlMeta);
			job_CMD.JobGUI.setItem(14, buylvl);
			
			ItemStack info = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta infoMeta = (SkullMeta) info.getItemMeta();
			infoMeta.setOwner("MHF_Question");
			infoMeta.setDisplayName("§c» §bInformationen");
			ArrayList<String> infolore = new ArrayList<String>();
			infolore.add("§3Finde hier Informationen zu dem Job System.");
			infoMeta.setLore(infolore);
			info.setItemMeta(infoMeta);
			job_CMD.JobGUI.setItem(16, info);
			
			ItemStack farmchoosen = new ItemStack(Material.WOODEN_HOE);
			ItemMeta fcMeta = farmchoosen.getItemMeta();
			fcMeta.setDisplayName("§c» §bFarmer");
			ArrayList<String> lore1 = new ArrayList<String>();
			lore1.add("§3Bekomme für jeden abgebauten:");
			lore1.add("§3Weizen, Karotten, Kartoffeln und Melonen");
			lore1.add("§3eine Summe von 1€ ausgezahlt.");
			fcMeta.setLore(lore1);
			farmchoosen.setItemMeta(fcMeta);
			
			job_CMD.chooseJob.setItem(2, farmchoosen);
			
			ItemStack fishchoosen = new ItemStack(Material.FISHING_ROD);
			ItemMeta fMeta = fishchoosen.getItemMeta();
			fMeta.setDisplayName("§c» §bFischer");
			ArrayList<String> lore11 = new ArrayList<String>();
			lore11.add("§3Bekomme für jeden geangelten Fisch");
			lore11.add("§3eine Summe von 1€ ausgezahlt.");
			fMeta.setLore(lore11);
			fishchoosen.setItemMeta(fMeta);
			
			job_CMD.chooseJob.setItem(4, fishchoosen);
			
			
			ItemStack minechoosen = new ItemStack(Material.DIAMOND_PICKAXE);
			ItemMeta mineMeta = minechoosen.getItemMeta();
			mineMeta.setDisplayName("§c» §bMinenarbeiter");
			ArrayList<String> lore111 = new ArrayList<String>();
			lore111.add("§3Bekomme für jedes abgebaute:");
			lore111.add("§3Eisen-, Gold-, und Diamanterz");
			lore111.add("§3eine Summe von 1€ ausgezahlt.");
			mineMeta.setLore(lore111);
			minechoosen.setItemMeta(mineMeta);
			
			job_CMD.chooseJob.setItem(6, minechoosen);
		}
		
		public static ItemStack getItem(Material id, int anzahl, int s, String name){
		
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(id,anzahl,(short)s);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
		}
}
