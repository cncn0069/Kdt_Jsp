package edu.pnu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookDao {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/myfirstdb";

	
	
	public void insertPhonebook(Connection con) {
		PreparedStatement prsq = null;
		
		class PB{
			String name;
			String phoneNumber;
			public PB(String name, String phoneNumber) {
				super();
				this.name = name;
				this.phoneNumber = phoneNumber;
			}
			public String getName() {
				return name;
			}

			public String getPhoneNumber() {
				return phoneNumber;
			}

			
		}
		
		try {
			
			
			String basic = "INSERT INTO phonebook(name,mobile) VALUES ";
			
			List<PB> list = new ArrayList<PB>(); 

			sc.nextLine();
			

			while(true)
			{
				System.out.print("이름(Q 탈출)\n : ");
				String name = sc.nextLine();
				
				if(name.toUpperCase().equals("Q")) {
					break;
				}
				
				System.out.println("휴대폰 번호\n : ");
				String phoneNumber = sc.nextLine();

				PB pb = new PB(name,phoneNumber);
				
				list.add(pb);
			}
			
			String tempString = "";
			for(int i = 0; i < list.size();i++)
			{
				if(i != 0) tempString = tempString + ",";
				tempString = tempString + "(?,?)";
			
			}

			prsq = con.prepareStatement("INSERT INTO phonebook(name,mobile) VALUES " + tempString);
			PB temp = null;
			System.out.println("INSERT INTO phonebook(name,mobile) VALUES " + tempString);
			for(int i = 0; i < list.size();i++)
			{
				temp = list.get(i);
				prsq.setString((i*2 + 1), temp.getName());
				prsq.setString((i*2 + 2), temp.getPhoneNumber());
			
			}

			prsq.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (prsq != null)
					prsq.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updatePhonebook(Connection con) {
		PreparedStatement prsq = null;
		try {
			prsq = con.prepareStatement("UPDATE `myfirstdb`.`phonebook` SET `name` = ?,`mobile` = ? WHERE `id` = ?");

			System.out.print("ID 값\n : ");
			String id = sc.nextLine();
			System.out.print("이름\n : ");
			String name = sc.nextLine();
			System.out.println("휴대폰 번호\n : ");
			String phoneNumber = sc.nextLine();

			prsq.setString(1, name);
			prsq.setString(2, phoneNumber);
			prsq.setString(3, id);

			prsq.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (prsq != null)
					prsq.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deletePhonebook(Connection con) {
		PreparedStatement prsq = null;
		try {
			prsq = con.prepareStatement("DELETE FROM phonebook WHERE `id`=?");

			System.out.print("ID 값\n : ");
			String id = sc.nextLine();

			prsq.setString(1, id);

			prsq.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (prsq != null)
					prsq.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectAllPhonebook(Connection con) {
		Statement st = null;
		ResultSet rs = null;
		ResultSetMetaData rsmt = null;

		try {
			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM phonebook");
			rsmt = rs.getMetaData();

			while (rs.next()) {
				for (int i = 0; i < rsmt.getColumnCount(); i++) {
					System.out.print(rs.getString(rsmt.getColumnName(i + 1)) + ", ");
				}
				System.out.println();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void nativeQuery(Connection con) {
		boolean flag = true;
		System.out.println("0은 종료");
		Statement st = null;
		ResultSet rs = null;
		ResultSetMetaData rsmt = null;

		try {
			String value = "";
			String[] key = null;
			st = con.createStatement();

			while (flag) {
				System.out.print("mysql>");
				value = sc.nextLine();

				key = value.split(" ");

				switch (key[0].toUpperCase()) {
				case "SELECT": {
					rs = st.executeQuery(value);

					rsmt = rs.getMetaData();
					
					System.out.println("-".repeat(60));
					
					while (rs.next()) {
						for (int i = 0; i < rsmt.getColumnCount(); i++) {
							System.out.print(rs.getString(rsmt.getColumnName(i + 1)) + ", ");
						}
						System.out.println();
					}
					System.out.println("-".repeat(60));

					break;
				}
				case "INSERT": {
					st.executeUpdate(value);
					System.out.println("INSERT 완료");
					break;
				}
				case "UPDATE": {
					st.executeUpdate(value);
					System.out.println("UPDATE 완료");
					break;
				}
				case "DELETE": {
					st.executeUpdate(value);
					System.out.println("DELETE 완료");
					break;
				}
				default: {
					System.out.println("다시 입력하세요");
					continue;
				}

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류");
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public static void main(String[] args) throws Exception {
		PhoneBookDao pbo = new PhoneBookDao();
		DBConnect con = new DBConnect();
		
		con.connect();


		boolean flag = true;
		while (flag) {
			System.out.print("[I]nsert/[U]pdate/[D]elete/[S]elect/[N]ative/[Q]uit:");
			char c = sc.next().toUpperCase().charAt(0);
			switch (c) {
			case 'I':
				pbo.insertPhonebook(con.getCon());
				break;
			case 'U':
				pbo.updatePhonebook(con.getCon());
				break;
			case 'D':
				pbo.deletePhonebook(con.getCon());
				break;
			case 'S':
				pbo.selectAllPhonebook(con.getCon());
				break;
			case 'N':
				pbo.nativeQuery(con.getCon());
				break;
			case 'Q':
				flag = false;
				break;
			}
		}
		
		con.close();
		System.out.println("Bye~");
	}
}
