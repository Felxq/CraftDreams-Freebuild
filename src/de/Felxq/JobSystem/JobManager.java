package de.Felxq.JobSystem;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;

import de.Felxq.Main.Main;

public class JobManager {
	
	static List<String> JobList = Arrays.asList( "Fischer", "Minenarbeiter", "Farmer");
	
	
	public static void setJob(Player p, String jobname, int joblevel) {
		String getPlayerJob = JobAPI.getJobName(p.getUniqueId().toString());
		int getPlayerJobLevel = JobAPI.getJobLevel(p.getUniqueId().toString());
	
		if(getPlayerJob == "Unbekannt" || getPlayerJob == "Arbeitslos") {
			JobAPI.updateJob(p.getUniqueId().toString(), jobname, 0);
			p.sendMessage(Main.pr + "Du übst nun den Beruf: §b" + jobname + " §5aus!");
		} else {
			if(getPlayerJobLevel >= 3) {
				JobAPI.updateJob(p.getUniqueId().toString(), jobname, 0);
				p.closeInventory();
				p.sendMessage(Main.pr + "Dein neuer Beruf ist nun §b" + jobname + "§5!");
			} else {
				p.sendMessage(Main.pr + "Du musst mindestens in deinem Beruf §b" + getPlayerJob + " §5das §bLevel 3 §5erreicht haben!");
			}
		}
		
	}
		
		/**
		if(getPlayerJob == "Arbeitslos") {
			JobAPI.setJob(p.getUniqueId().toString(), jobname, 0);
		} else if(getPlayerJob == "Fischer" || getPlayerJob == "Farmer" || getPlayerJob == "Minenarbeiter") {
			if(getPlayerJobLevel <= 5) {
				p.sendMessage(Main.pr + "Du musst mindestens in deinem Beruf §b" + jobname + " §5das Level 5 erreicht haben!");
			} else {
				JobAPI.setJob(p.getUniqueId().toString(), jobname, 0);
				p.sendMessage(Main.pr + "Dein neuer Beruf ist nun §b" + jobname + "§5!");
			}
		}
	}
	**/
	public static void setArbeitslos(Player p) {
		JobAPI.setJob(p.getUniqueId().toString(), "Arbeitslos", 0);
	}
	
	public static void setJobLevel(Player p, int joblevel) {
		//JobAPI.setJob(p.getUniqueId().toString(), JobAPI.getJobName(p.getUniqueId().toString()), joblevel);
		JobAPI.updateJob(p.getUniqueId().toString(), JobAPI.getJobName(p.getUniqueId().toString()), joblevel);
	}
	
}
