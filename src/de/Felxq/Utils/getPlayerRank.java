package de.Felxq.Utils;

import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class getPlayerRank {
	
		public static String getRank(Player p) {
			if(PermissionsEx.getUser(p).inGroup("Admin")) {
			return "Admin";
			} else if(PermissionsEx.getUser(p).inGroup("Developer")) {
			return "Developer";
			} else if(PermissionsEx.getUser(p).inGroup("Moderator")) {
			return "Moderator";
			} else if(PermissionsEx.getUser(p).inGroup("Supporter")) {
			return "Supporter";
			} else if(PermissionsEx.getUser(p).inGroup("Builder")) {
			return "Builder";
			} else if(PermissionsEx.getUser(p).inGroup("Dreamer")) {
			return "Dreamer";
			} else if(PermissionsEx.getUser(p).inGroup("Donator")) {
			return "Donator";
			} else {
				return "default";
			}
		}
}
