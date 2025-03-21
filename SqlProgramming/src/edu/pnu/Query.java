package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Query {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rc = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.125.121.174:3306/world","root","tiger");
			
			st = con.createStatement();
			
			rc = st.executeQuery("SELECT * from city");
			
			while(rc.next())
			{
				System.out.print(rc.getInt("ID"));
				System.out.println(rc.getString("Name"));
			}
			
		}catch(Exception e) {
			System.out.println("연결 실패");
		}finally {
			try {
				if(con != null)
				{
					con.close();
				}
				if(st != null)
				{
					st.close();
				}
				if(rc != null)
				{
					st.close();
				}
			}catch(Exception e) {
				
			}
			
		}
	}
}
