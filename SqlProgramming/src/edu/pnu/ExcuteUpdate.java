package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExcuteUpdate {
	static ExcuteUpdate eu = new ExcuteUpdate();

	public void UdateNameMobile(Connection con) {
		PreparedStatement psmt = null;
		Statement st = null;

		try (Scanner sc = new Scanner(System.in)) {
			psmt = con.prepareStatement("UPDATE `myfirstdb`.`phonebook` SET `mobile`= ? WHERE `id` = ?;");
			st = con.createStatement();
			
			ResultSet cr = st.executeQuery("SELECT COUNT(*) FROM phonebook");
			cr.next();

			String mobile = "010-1111-3222";
			int count = 0;
			//일단 보류
			ResultSetMetaData countValue = psmt.getMetaData();

			for (int i = 1; i <= cr.getInt(1); i++) {
				mobile = String.format("%s%02d", mobile.substring(0, mobile.length() - 2), i);

				psmt.setString(1, mobile);
				psmt.setInt(2, i);
				
				count = count + psmt.executeUpdate();
						
			}
			//변경된 수
			System.out.println("변경된 수 : " + count); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if(st != null)
					st.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	public void InsertNameMobile(Connection con) {
		PreparedStatement psmt = null;

		try (Scanner sc = new Scanner(System.in)) {
			psmt = con.prepareStatement("INSERT INTO `phonebook`(`name`,`mobile`) VALUES (?,?)");

			String name = "";
			String mobile = "010-1111-2222";

			for (int i = 0; i < 30; i++) {
				name = String.format("홍%s동", changeNameToString(i % 10));
				mobile = String.format("%s%02d", mobile.substring(0, mobile.length() - 2), i);

				System.out.println(name);
				System.out.println(mobile);

				psmt.setString(1, name);
				psmt.setString(2, mobile);
				psmt.executeUpdate();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	public String changeNameToString(int values) {
		String temp = "";

		switch (values) {
		case 1: {
			temp = "일";
			break;
		}
		case 2: {
			temp = "이";
			break;
		}
		case 3: {
			temp = "삼";
			break;
		}
		case 4: {
			temp = "사";
			break;
		}
		case 5: {
			temp = "오";
			break;
		}
		case 6: {
			temp = "육";
			break;
		}
		case 7: {
			temp = "칠";
			break;
		}
		case 8: {
			temp = "팔";
			break;
		}
		case 9: {
			temp = "구";
			break;
		}
		case 0: {
			temp = "십";
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + values);
		}
		return temp;
	}

	public static void main(String[] args) {

		Connection con = null;

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb", "root", "napkin");

			// eu.InsertNameMobile(con);
			eu.UdateNameMobile(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("연결 실패");
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
}
