package de.Felxq.Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.Felxq.Commands.TpCommand;
import de.Felxq.Commands.TpaCommand;
import de.Felxq.Commands.TpacceptCommand;
import de.Felxq.Commands.TpdenyCommand;
import de.Felxq.Commands.broadcast_CMD;
import de.Felxq.Commands.cc_CMD;
import de.Felxq.Commands.clear_CMD;
import de.Felxq.Commands.day_CMD;
import de.Felxq.Commands.echo_cmd;
import de.Felxq.Commands.fly_CMD;
import de.Felxq.Commands.gm_CMD;
import de.Felxq.Commands.heal_CMD;
import de.Felxq.Commands.home_CMD;
import de.Felxq.Commands.invsee_CMD;
import de.Felxq.Commands.money_CMD;
import de.Felxq.Commands.msg_CMD;
import de.Felxq.Commands.pay_CMD;
import de.Felxq.Commands.setJobLevel_CMD;
import de.Felxq.Commands.sethome_CMD;
import de.Felxq.Commands.setspawn_CMD;
import de.Felxq.Commands.spawn_CMD;
import de.Felxq.Commands.spy_CMD;
import de.Felxq.Commands.vanish_CMD;
import de.Felxq.Grundstücke.SignListener;
import de.Felxq.JobSystem.Job_Inventory_Page1;
import de.Felxq.JobSystem.Job_Inventory_Page2;
import de.Felxq.JobSystem.job_CMD;
import de.Felxq.Listener.ChatListener;
import de.Felxq.Listener.DeathListener;
import de.Felxq.Listener.JoinFullServer;
import de.Felxq.Listener.JoinListener;
import de.Felxq.Listener.QuitListener;
import de.Felxq.Listener.Scoreboard;
import de.Felxq.Listener.UnknownCommand;
import de.Felxq.MySQL.MySQL;
import de.Felxq.Shop.ShopVillagerHandler;
import de.Felxq.Shop.ShopVillager_Inventory_Page1;
import de.Felxq.Team.TeamChat;
import de.Felxq.Team.login_CMD;
import de.Felxq.UserShop.SignListenerShop;

public class Main extends JavaPlugin {
	
	public static String pr = "§cCraft§3Dreams §8× §5";
	public static String noperm = pr + "Dafür hast du keine Berechtigung!";
	
	public static File Spawn = new File("plugins//CraftDreams//Spawn.yml");
	File craftdreams = new File("plugins//CraftDreams");
	@SuppressWarnings("static-access")
	public static YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(Spawn);
	
	ShopVillagerHandler shopvillHandler = new ShopVillagerHandler();
		public void onEnable() {
			Bukkit.getConsoleSender().sendMessage("§cCraft§3Dreams §9» §7Plugin wird gestartet!");
			registerEvents();
			registerCommands();
			createFile();
			
			MySQL.connect();
			befüllen.fill();
			//RealDayTime.startTimer();
			startTimer();
		}
		
		public void registerEvents() {
			Bukkit.getPluginManager().registerEvents(shopvillHandler, this);
			
			Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
			Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
			Bukkit.getPluginManager().registerEvents(new UnknownCommand(), this);
			Bukkit.getPluginManager().registerEvents(new JoinFullServer(), this);
			Bukkit.getPluginManager().registerEvents(new TeamChat(), this);
			Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
			Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
			Bukkit.getPluginManager().registerEvents(new SignListener(), this);
			Bukkit.getPluginManager().registerEvents(new SignListenerShop(), this);
			Bukkit.getPluginManager().registerEvents(new ShopVillager_Inventory_Page1(), this);
			Bukkit.getPluginManager().registerEvents(new Job_Inventory_Page1(), this);
			Bukkit.getPluginManager().registerEvents(new Job_Inventory_Page2(), this);			
		}
		
		public void registerCommands() {
			getCommand("setspawn").setExecutor(new setspawn_CMD());
			getCommand("spawn").setExecutor(new spawn_CMD());
			getCommand("setshop").setExecutor(shopvillHandler);
			getCommand("money").setExecutor(new money_CMD());
			getCommand("team").setExecutor(new login_CMD());
			getCommand("pay").setExecutor(new pay_CMD());
			getCommand("gm").setExecutor(new gm_CMD());
			getCommand("day").setExecutor(new day_CMD());
			getCommand("vanish").setExecutor(new vanish_CMD());
			getCommand("heal").setExecutor(new heal_CMD());
			getCommand("spy").setExecutor(new spy_CMD());
			getCommand("broadcast").setExecutor(new broadcast_CMD());
			getCommand("bc").setExecutor(new broadcast_CMD());
			getCommand("cc").setExecutor(new cc_CMD());
			getCommand("clearchat").setExecutor(new cc_CMD());
			getCommand("clear").setExecutor(new clear_CMD());
			getCommand("ci").setExecutor(new clear_CMD());
			getCommand("invsee").setExecutor(new invsee_CMD());
			getCommand("sethome").setExecutor(new sethome_CMD());
			getCommand("home").setExecutor(new home_CMD());
			getCommand("fly").setExecutor(new fly_CMD());
			getCommand("msg").setExecutor(new msg_CMD());
			getCommand("tpa").setExecutor(new TpaCommand());
			getCommand("tp").setExecutor(new TpCommand());
			getCommand("tpaccept").setExecutor(new TpacceptCommand());
			getCommand("tpdeny").setExecutor(new TpdenyCommand());
			getCommand("job").setExecutor(new job_CMD());
			getCommand("beruf").setExecutor(new job_CMD());
			getCommand("echo").setExecutor(new echo_cmd());
			
			/*
			 * Muss noch ausgiebig getestet werden!
			 */
			
			
			
			//Debug CMDS
			getCommand("setJobLevel").setExecutor(new setJobLevel_CMD());
		}
		
		public void onDisable() {
			MySQL.disconnect();
		}
		
		public void createFile() {
			if(!craftdreams.exists()) {
				craftdreams.mkdir();
			}
			
			if(!Spawn.exists()) {
				try {
					Spawn.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(!home_CMD.Homes.exists()) {
				try {
					home_CMD.Homes.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void startTimer() {
			
	        new BukkitRunnable() {
	            public void run() {

	                for(Player player : Bukkit.getOnlinePlayers()){
		                Scoreboard.setScoreboard(player);
	                    }
	                }
	               
	            }.runTaskTimer(this, 20, 20*10);
		}

}
