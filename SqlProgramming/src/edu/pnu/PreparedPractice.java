package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class PreparedPractice {
	public static void main(String[] args) {
		Connection con = null;

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/world";
			con = DriverManager.getConnection(url,"root","napkin");
			
			PreparedStatement st = con.prepareStatement("SELECT * FROM city");
			
			//st.setInt(0, 0);
			
			ResultSet cr = st.executeQuery();
			
			while(cr.next())
			{
				System.out.println(cr.getString("Name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
