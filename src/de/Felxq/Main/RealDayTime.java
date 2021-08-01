package de.Felxq.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;


public class RealDayTime {
	
			public static void startTimer() {
				new BukkitRunnable() {
					@Override
					public void run() {
						Bukkit.getWorld("FarmWelt").setTime(getTime());
						
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 0, 5);
			}
			
			private static Integer getTime() {
				SimpleDateFormat time = new SimpleDateFormat("HH:mm");
				String[] args = time.format(new Date()).split(":");
				Integer hours = Integer.parseInt(args[0])*1000;
				Integer minutes = Integer.parseInt(args[1])*(100/60);
				return hours+minutes+18000;
			}

}
