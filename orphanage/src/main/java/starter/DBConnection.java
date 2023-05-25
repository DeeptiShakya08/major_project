package starter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/orphanage";
		String userName = "root";
		String password = "Deepti";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			String query = "select * from m_orphanage_events";
			PreparedStatement p = con.prepareStatement(query);
			ResultSet res = p.executeQuery();
			res.next();
			System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4)+" ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
