package de.Felxq.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import de.Felxq.Economy_API.EconomyAPI;
import de.Felxq.JobSystem.JobAPI;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Scoreboard implements Listener {
	
	//static Map<Scoreboard, Player> scoreboards = new HashMap();
	//static TNEAPI ecoAPI = TNE.instance().api();
	
		public static void setScoreboard(Player player) {
			final org.bukkit.scoreboard.Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
			@SuppressWarnings("deprecation")
			final Objective obj = sb.registerNewObjective("stats", "dummy");
		//Teams mit Prefix	
			Team adminpr = sb.registerNewTeam("01-Admin");
			adminpr.setPrefix("§4Admin §8× §4");
			adminpr.setColor(ChatColor.DARK_RED);
			Team devpr = sb.registerNewTeam("02-Developer");
			devpr.setPrefix("§bDev §8× §b");
			devpr.setColor(ChatColor.WHITE);
			Team modpr = sb.registerNewTeam("03-Moderator");
			modpr.setPrefix("§cMod §8× §c");
			modpr.setColor(ChatColor.RED);
			Team suppr = sb.registerNewTeam("04-Supporter");
			suppr.setPrefix("§9Supp §8× §9");
			suppr.setColor(ChatColor.BLUE);
			Team builderpr = sb.registerNewTeam("05-Builder");
			builderpr.setPrefix("§6Builder §8× §6");
			builderpr.setColor(ChatColor.GOLD);
			Team dreampr = sb.registerNewTeam("06-Dreamer");
			dreampr.setPrefix("§5Dreamer §8× §5");
			dreampr.setColor(ChatColor.DARK_PURPLE);
			Team playerpr = sb.registerNewTeam("07-Player");
			playerpr.setPrefix("§7");
			playerpr.setColor(ChatColor.GRAY);
		//Teams mit Prefix	
			
			Bukkit.getOnlinePlayers().forEach(players -> {
				if(PermissionsEx.getUser(players).inGroup("Admin")) {
					adminpr.addEntry(players.getName());
				} else if(PermissionsEx.getUser(players).inGroup("Developer")) {
					devpr.addEntry(players.getName());
				} else if(PermissionsEx.getUser(players).inGroup("Moderator")) {
					modpr.addEntry(players.getName());
				} else if(PermissionsEx.getUser(players).inGroup("Supporter")) {
					suppr.addEntry(players.getName());
				} else if(PermissionsEx.getUser(players).inGroup("Builder")) {
					builderpr.addEntry(players.getName());
				} else if(PermissionsEx.getUser(players).inGroup("Dreamer")) {
					dreampr.addEntry(players.getName());
				} else {
					playerpr.addEntry(players.getName());
				}
			});
			
			//Team playerMoney = sb.registerNewTeam("pMoney");
			//playerMoney.setPrefix(" §8» §3" + ecoAPI.getAccount(player.getUniqueId()).getHoldings());
			//playerMoney.addEntry(" §c» §3".toString());
			//https://www.youtube.com/watch?v=rk6vu5rZRGE
			
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.setDisplayName("§8× §cCraft§3Dreams §8×");
			obj.getScore("").setScore(8);
			obj.getScore("§8× §3Dein Rang").setScore(7);
			
			if(PermissionsEx.getUser(player).inGroup("Admin")) {
				obj.getScore(" §8» §4Administrator").setScore(6);
			} else if(PermissionsEx.getUser(player).inGroup("Developer")) {
				obj.getScore(" §8» §bDeveloper").setScore(6);
			} else if(PermissionsEx.getUser(player).inGroup("Moderator")) {
				obj.getScore(" §8» §cModerator").setScore(6);
			} else if(PermissionsEx.getUser(player).inGroup("Supporter")) {
				obj.getScore(" §8» §9Supporter").setScore(6);
			} else if(PermissionsEx.getUser(player).inGroup("Builder")) {
				obj.getScore(" §8» §6Builder").setScore(6);
			} else if(PermissionsEx.getUser(player).inGroup("Dreamer")) {
				obj.getScore(" §8» §5Dreamer").setScore(6);
			} else {
				obj.getScore(" §8» §7Spieler").setScore(6);
			}
			//obj.getScore(" §8» " + ).setScore(6);
			obj.getScore("§1").setScore(5);
			obj.getScore("§8× §3Dein Guthaben").setScore(4);
			obj.getScore(" §8» §3" + EconomyAPI.getMoney(player.getUniqueId().toString()) + "€").setScore(3);
			obj.getScore("§3").setScore(2);
			obj.getScore("§8× §3Dein Beruf").setScore(1);
			obj.getScore(" §8» §3" + JobAPI.getJobName(player.getUniqueId().toString())).setScore(0);
			
			//scoreboards.put((Scoreboard) sb, player);
			player.setScoreboard(sb);
		}


}
