package de.Felxq.JobSystem;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.Felxq.Main.Main;


public class job_CMD implements CommandExecutor {


	ArrayList<String> JobAntiSpam = new ArrayList<>();
	
	public static Inventory JobGUI = Bukkit.createInventory(null, 27, "§6Arbeitsamt §c»");
	public static Inventory chooseJob = Bukkit.createInventory(null, 9, "§6Berufe §c»");
	public static Inventory lvlup = Bukkit.createInventory(null, 9, "§6Level kaufen §c»");
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] args) {
		if((s instanceof Player)) {
			Player p = (Player)s;
			if(args.length == 0) {
				if(!JobAntiSpam.contains(p.getName())) {
					
					
					ItemStack BerufStatus = new ItemStack(Material.PLAYER_HEAD);
					SkullMeta bsmeta = (SkullMeta) BerufStatus.getItemMeta();
					bsmeta.setOwner(p.getName());
					bsmeta.setDisplayName("§c» §bDein Beruf");
					ArrayList<String> lore = new ArrayList<String>();
					lore.add("§3" + JobAPI.getJobName(p.getUniqueId().toString()) + " " + JobAPI.getJobLevel(p.getUniqueId().toString()));
					bsmeta.setLore(lore);
					BerufStatus.setItemMeta(bsmeta);

					String JobName = JobAPI.getJobName(p.getUniqueId().toString());
					
					if(JobName == "Farmer") {
						ItemStack farmchoosen = new ItemStack(Material.WOODEN_HOE);
						ItemMeta fcMeta = farmchoosen.getItemMeta();
						fcMeta.setDisplayName("§c» §bFarmer");
						ArrayList<String> lore1 = new ArrayList<String>();
						lore1.add("§3Bekomme für jeden abgebauten:");
						lore1.add("§3Weizen, Karotten, Kartoffeln und Melonen");
						lore1.add("§3eine Summe von 1€ ausgezahlt.");
						fcMeta.addEnchant(Enchantment.LUCK, 1, true);
						fcMeta.setLore(lore1);
						farmchoosen.setItemMeta(fcMeta);
						
						chooseJob.remove(Material.WOODEN_HOE);
						chooseJob.setItem(2, farmchoosen);
					} else if(JobName == "Fischer") {
						ItemStack fishchoosen = new ItemStack(Material.FISHING_ROD);
						ItemMeta fMeta = fishchoosen.getItemMeta();
						fMeta.setDisplayName("§c» §bFischer");
						ArrayList<String> lore1 = new ArrayList<String>();
						lore1.add("§3Bekomme für jeden geangelten Fisch");
						lore1.add("§3eine Summe von 1€ ausgezahlt.");
						fMeta.addEnchant(Enchantment.LUCK, 1, true);
						fMeta.setLore(lore1);
						fishchoosen.setItemMeta(fMeta);
						
						chooseJob.remove(Material.FISHING_ROD);
						chooseJob.setItem(4, fishchoosen);
					} else if(JobName == "Miner") {
						ItemStack minechoosen = new ItemStack(Material.DIAMOND_PICKAXE);
						ItemMeta mineMeta = minechoosen.getItemMeta();
						mineMeta.setDisplayName("§c» §bMinenarbeiter");
						ArrayList<String> lore1 = new ArrayList<String>();
						lore1.add("§3Bekomme für jedes abgebaute:");
						lore1.add("§3Eisen-, Gold-, und Diamanterz");
						lore1.add("§3eine Summe von 1€ ausgezahlt.");
						mineMeta.addEnchant(Enchantment.LUCK, 1, true);
						mineMeta.setLore(lore1);
						minechoosen.setItemMeta(mineMeta);
						
						chooseJob.remove(Material.DIAMOND_PICKAXE);
						chooseJob.setItem(6, minechoosen);
					}
					
					JobGUI.removeItem(BerufStatus);
					JobGUI.setItem(10, BerufStatus);
					
					//chooseJob.remove(BerufStatus);
					//chooseJob.setItem(4, BerufStatus);
					
					p.openInventory(JobGUI);
					p.playSound(p.getLocation(), Sound.BLOCK_SHULKER_BOX_OPEN, 1, 1);
					JobAntiSpam.add(p.getName());
					
					Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		                   
		                @Override
		                public void run() {
		                	
		                	
		                	JobAntiSpam.remove(p.getName());
		                }
		        }, 20*120);
					
				} else {
					p.sendMessage(Main.pr + "Du musst etwas warten, bis du dieses Kommando wieder ausführen kannst.");
				}
					

			}
		} else {
			s.sendMessage("Du musst ein Spieler sein!");
		}
		return false;
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
