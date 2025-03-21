package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private Connection con = null;
	

	public Connection getCon() {
		return con;
	}

	public boolean connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","napkin");
			
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("도메인 오류");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("오류");
		}
		
		return false;
	}
	
	public boolean close() {
		try {
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
}
