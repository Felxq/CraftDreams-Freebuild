package de.Felxq.MySQL;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQL {
    
	public static Connection con;
	
	public static void connect() {
		if(!isConnected()) {
			 try {
				//con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/minecraft_data?autoReconnect=true", "testuser", "test");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/minecraft_data?autoReconnect=true", "root", "");
				System.out.println("[MySQL - UserData] Die Verbindung zur Datenbank wurde erfolgreich aufgebaut!");
				createTable();
			 } catch (SQLException e) {
			}
		}
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("[MySQL - UserData] Die Verbindung zur Datenbank wurde erfolgreich getrennt!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected() {
		return (con != null);
	}

	public static void createTable() {
		try {
			con.prepareStatement("CREATE TABLE IF NOT EXISTS playerbalance (UUID VARCHAR(100), money DOUBLE(16,2))").executeUpdate();
			con.prepareStatement("CREATE TABLE IF NOT EXISTS playerJob (UUID VARCHAR(100), job_name VARCHAR(20), job_level INT(16))").executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
