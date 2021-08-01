package de.Felxq.Economy_API;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.Felxq.MySQL.MySQL;

public class EconomyAPI {

		public static double getMoney(String uuid) {
			try {
				PreparedStatement st = MySQL.con.prepareStatement("SELECT * FROM playerbalance WHERE UUID = ?");
				st.setString(1, uuid);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					return rs.getDouble("money");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		public static void setMoney(String uuid, double money) {
			if(getMoney(uuid) == -1) {
				try {
					PreparedStatement st = MySQL.con.clientPrepareStatement("INSERT INTO playerbalance (UUID, money) VALUES (?,?)");
					st.setString(1, uuid);
					st.setDouble(2, money);
					st.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else {
				try {
					PreparedStatement st = MySQL.con.clientPrepareStatement("UPDATE playerbalance SET money = ? WHERE UUID = ?");
					st.setString(2, uuid);
					st.setDouble(1, money);
					st.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void addMoney(String uuid, double money) {
			setMoney(uuid, money + getMoney(uuid)); 
			
		}
		
		public static void removeMoney(String uuid, double money) {
			setMoney(uuid, getMoney(uuid) - money);
		}
	
}
