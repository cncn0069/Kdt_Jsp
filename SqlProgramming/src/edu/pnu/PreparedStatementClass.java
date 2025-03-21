package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PreparedStatementClass {

	static Scanner sc = new Scanner(System.in);

	void mission1(Connection con) throws Exception {
		PreparedStatement psmt = null;
		ResultSet rs = null;
//		try (Scanner sc = new Scanner(System.in)){
		try {
			sc.nextLine();
			psmt = con.prepareStatement("Select Name,Population from city where Population > ?;");

			System.out.print("\n인구수를 적으면 입력 값 이상의 나라가 출력됩니다. \n 값 : ");
			int value = sc.nextInt();
			psmt.setInt(1, value);

			rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("name") + ", ");
				System.out.println(rs.getString("Population"));
			}

		} catch (Exception e) {

		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {

			}

		}

	}

	void mission2(Connection con) throws Exception {

		sc.nextLine();

		// %%가 앞뒤로 쌓여있으면 어떻게 될까?
		// 질의 객체 생성
		PreparedStatement psmt = con.prepareStatement(
				"SELECT country.name, city.name, CountryCode, District from city join country on city.CountryCode=country.code where CountryCode=? || country.name like ?;"
						+ "");

		System.out.print("\n국가명의 일부 또는 국가 코드를 입력하세요. \n 값 : ");
		String value = sc.nextLine();

		// 질의 객체 설정
		psmt.setString(1, value);
		psmt.setString(2, "%" + value + "%");

		// 결과 객체 생성
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("country.name") + ", ");
			System.out.print(rs.getString("CountryCode") + ", ");
			System.out.print(rs.getString("District") + ", ");
			System.out.println(rs.getString("city.name"));
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		psmt.close();
		rs.close();
	}

	void mission3(Connection con) throws Exception {

		sc.nextLine();

		// %%가 앞뒤로 쌓여있으면 어떻게 될까?
		// 질의 객체 생성
		PreparedStatement psmt = con.prepareStatement("Select name, Continent from country where Continent = ?;" + "");

		System.out.print("\n 대륙을 입력하세요. \n 값 : ");
		String value = sc.nextLine();

		// 질의 객체 설정
		psmt.setString(1, value);

		// 결과 객체 생성
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("name") + ", ");
			System.out.println(rs.getString("Continent"));
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		psmt.close();
		rs.close();
	}

	void mission4(Connection con) throws Exception {

		sc.nextLine();

		// 질의 객체 생성
		PreparedStatement psmt = con
				.prepareStatement("Select Name,SurfaceArea from country where SurfaceArea < ?;" + "");

		System.out.print("\n 넓이를 입력하면 입력값보다 작은 넓이를 가진 나라가 출력됩니다.\n 값 : ");
		int value = sc.nextInt();

		// 질의 객체 설정
		psmt.setInt(1, value);

		// 결과 객체 생성
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("Name") + ", ");
			System.out.println(rs.getString("SurfaceArea"));
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		psmt.close();
		rs.close();
	}

	void mission5(Connection con) throws Exception {

		sc.nextLine();

		// 질의 객체 생성
		PreparedStatement psmt = con.prepareStatement(
				"Select name,countrycode,District,population from city where countrycode='kor' AND District=?");

		System.out.print("\n 대한민국의 지역이름을 입력하세요 예)Seoul, Busan, Kyonggi\n 값 : ");
		String value = sc.nextLine();

		// 질의 객체 설정
		psmt.setString(1, value);

		// 결과 객체 생성
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getString("Name") + ", ");
			System.out.print(rs.getString("countrycode") + ", ");
			System.out.print(rs.getString("District") + ", ");
			System.out.println(rs.getDouble("population") + ", ");
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		psmt.close();
		rs.close();
	}

	void mission6(Connection con) throws Exception {

		sc.nextLine();

		// 질의 객체 생성
		PreparedStatement psmt = con.prepareStatement(
				"Select CountryCode, Language,isOfficial from countrylanguage where Language = ? AND isOfficial= 'T';");

		System.out.print("\n 해당하는 언어를 공식적으로 사용하는 나라를 보여줍니다. 예)English, Dutch, Korean\n 값 : ");
		String value = sc.nextLine();

		// 질의 객체 설정
		psmt.setString(1, value);

		// 결과 객체 생성
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("CountryCode") + ", ");
			System.out.print(rs.getString("Language") + ", ");
			System.out.print(rs.getString("isOfficial"));
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		psmt.close();
		rs.close();
	}

	

	void mission7(Connection con) throws Exception {

		sc.nextLine();

		// 질의 객체 생성
		PreparedStatement psmt = con
				.prepareStatement("Select CountryCode, Language, Percentage from countrylanguage Where Percentage >?;");

		System.out.print("\n 입력한 언어에 대한 비율보다 해당 언어를 많이 사용하는 나라\n 값 : ");
		int value = sc.nextInt();

		// 질의 객체 설정
		psmt.setInt(1, value);

		// 결과 객체 생성
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("CountryCode") + ", ");
			System.out.print(rs.getString("Language") + ", ");
			System.out.println(rs.getDouble("Percentage"));
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		psmt.close();
		rs.close();
	}
	

void mission9(Connection con) throws Exception {
	boolean run = true;
	
	Map<String,String> crud = new HashMap<String, String>();
	ResultSet rs = null;
	
	while (run) {
		sc.nextLine();
		
		System.out.print("mysql(0 isQuit)>");
		// 질의 객체 생성
		
		String value = sc.nextLine();
		
		//CRUD 맵 생성
		Statement sr = con.createStatement();
		
		try {
			
			rs = sr.executeQuery(value + ";");
		
		}catch(SQLException  e) {
			//잘못 입력했을 경우!!
			System.out.println("다시 입력하세요");
			continue;
		}
		

		// 질의 객체 설정
		
		ResultSetMetaData list =  rs.getMetaData();
		// 결과 객체 생성
		while (rs.next()) {
			
			//컬럼 인덱스는 1부터 시작
			for(int i = 1;i <= list.getColumnCount();i++)
			{
				System.out.print(rs.getString(list.getColumnName(i)) + ",");
			}
			System.out.println();
		}

		// 객체 연결 끊어주기..

		// 연결이 한번되고 끊기겠지?
		// 아니다 rs가 가르키던 친구는 계속 세션에 살아있따
		rs.close();

	}

}

	public static void main(String[] args) {
		PreparedStatementClass ps = new PreparedStatementClass();

		// DB연결이 가장 비용이 많이 들기 때문에 Connection con은 하나만!!
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "napkin");

			// ps.mission1(con);

			// 와일 조건
			boolean run = true;

			while (run) {

				System.out.println("1~7번 중 입력 0은 종료");
				System.out.println("1. 인구 수를 입력 받아서 그보다 많은 인구를 가진 도시를 검색.");
				System.out.println("2. 국가 명의 일부 또는 국가 코드를 입력 받아서 해당 국가의 도시의 이름과 인구를 검색.");
				System.out.println("3. 대륙을 입력 받아서 해당 대륙에 위치한 국가를 검색. (Continent)");
				System.out.println("4. 넓이(10,0002 km)를 입력 받아서 입력 값보다 작은 면적을 가진 국가의 이름과 면적을 면적 오름차순으로 검색");
				System.out.println("5. 대한민국의 District를 입력 받아서 해당 지역에 있는 모든 도시를 검색. (예:‘Kyonggi’)");
				System.out.println("6. 언어를 입력 받아서 해당 언어가 국가 공식 언어인 국가를 검색. (예:'Spanish’)");
				System.out.println("7. CountryLanguage에서 사용자가 입력 비율 이상인 언어의 국가 코드와 비율을 검색.");
				System.out.println();
				System.out.print("입력하세요 : ");
				int key = sc.nextInt();

				switch (key) {
				case 1: {
					ps.mission1(con);
					break;
				}
				case 2: {
					ps.mission2(con);
					break;
				}
				case 3: {
					ps.mission3(con);
					break;
				}
				case 4: {
					ps.mission4(con);
					break;
				}
				case 5: {
					ps.mission5(con);
					break;
				}
				case 6: {
					ps.mission6(con);
					break;
				}
				case 7: {
					ps.mission7(con);
					break;
				}
				case 9: {
					ps.mission9(con);
					break;
				}
				case 0: {
					run = false;
					System.out.println("감사합니다.");
					break;
				}
				default:
					System.out.println("다시 입력해주세요.");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("연결실패");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("Con 실패");
			}

		}

	}
}
