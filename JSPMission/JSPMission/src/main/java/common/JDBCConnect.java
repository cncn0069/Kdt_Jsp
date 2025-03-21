package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

public class JDBCConnect {
	Connection con = null;
	
	
	private PreparedStatement psmt = null;
	private Statement st = null;

	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}

	public static void main(String[] args) {
		JDBCConnect jdbc = new JDBCConnect();
		
		jdbc.close();
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public PreparedStatement getPsmt() {
		return psmt;
	}

	public void setPsmt(PreparedStatement psmt) {
		this.psmt = psmt;
	}

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
			if (psmt != null) {
				System.out.println("자원해제 성공");
				psmt.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

}
