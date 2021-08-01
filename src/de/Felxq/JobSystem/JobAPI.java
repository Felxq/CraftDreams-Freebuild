package de.Felxq.JobSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.Felxq.MySQL.MySQL;

public class JobAPI {
	
		public static void setJob(String uuid, String jobname, int joblevel) {
			PreparedStatement st;
			try {
				st = MySQL.con.clientPrepareStatement("INSERT INTO playerjob (UUID, job_name, job_level) VALUES (?,?,?)");
				st.setString(1, uuid);
				st.setString(2, jobname);
				st.setInt(3, joblevel);
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static String getJobName(String uuid) {
			try {
				PreparedStatement st = MySQL.con.prepareStatement("SELECT * FROM playerjob WHERE UUID = ?");
				st.setString(1, uuid);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					return rs.getString("job_name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "Unbekannt";
		}
		
		public static int getJobLevel(String uuid) {
			try {
				PreparedStatement st = MySQL.con.prepareStatement("SELECT * FROM playerjob WHERE UUID = ?");
				st.setString(1, uuid);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					return rs.getInt("job_level");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		public static void updateJob(String uuid, String jobname, int joblevel) {
			try {
				PreparedStatement st = MySQL.con.clientPrepareStatement("UPDATE playerjob SET job_name = ? WHERE UUID = ?");
				st.setString(2, uuid);
				st.setString(1, jobname);
				PreparedStatement st2 = MySQL.con.clientPrepareStatement("UPDATE playerjob SET job_level = ? WHERE UUID = ?");
				st2.setString(2, uuid);
				st2.setInt(1, joblevel);
				st.executeUpdate();
				st2.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

}
