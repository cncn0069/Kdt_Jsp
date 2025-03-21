package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JDBCConnect {
	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement psmt = null;
	
	

	public JDBCConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "napkin";

			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JDBCConnect(String driver, String url, String id, String pwd) {

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public JDBCConnect(ServletContext application) {
		try {

			String driver = application.getInitParameter("MySQLDriver");

			Class.forName(driver);

			String url = application.getInitParameter("MySQLURL");
			String id = application.getInitParameter("MySQLId");
			String pwd = application.getInitParameter("MySQLPwd");

			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(인수 생성자 2)");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void close() {
		try {
			if (con != null) {
				System.out.println("자원해제 성공");
				con.close();	
			}
			if (stmt != null) {
				System.out.println("자원해제 성공");
				stmt.close();	
			}
			if (psmt != null) {
				System.out.println("자원해제 성공");
				psmt.close();	
			}
			if (rs != null) {
				System.out.println("자원해제 성공");
				rs.close();	
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

}
