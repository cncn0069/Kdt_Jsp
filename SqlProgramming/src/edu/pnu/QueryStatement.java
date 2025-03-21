package edu.pnu;

import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QueryStatement {
	

	    public static void printInBox(String text) {
	        int width = text.length() + 4;
	        
	        // 상단 테두리 출력
	        System.out.println("+" + "-".repeat(width - 2) + "+");
	        
	        // 텍스트와 측면 테두리 출력
	        System.out.println("| " + text + " |");
	        
	        // 하단 테두리 출력
	        System.out.println("+" + "-".repeat(width - 2) + "+");
	    }



	public void mission1(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("검색을 원하는 인구 수?( X>인구 *이상일 경우 이떄에 X는 입력값.)");

		int Population = sc.nextInt();

		rs = st.executeQuery("Select Name,Population from city where Population > " + Population + " ORDER BY population;");

		while (rs.next()) {
			printInBox(rs.getString("name") + "," + rs.getInt("population"));
		}

	}

	public void mission2(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("검색할 도시의 코드또는 국가명을 입력하시오 일부 입력 가능");

		String searchName = sc.nextLine();

		rs = st.executeQuery("SELECT country.name,city.name,CountryCode,District from city join country on city.CountryCode=country.code where CountryCode like '%"+searchName +" %' || country.name like '%"+searchName +"%';");
		
		while (rs.next()) {
			printInBox(rs.getString("name") + "," + rs.getString("District") + "," + rs.getString("CountryCode"));
		}
	}

	public void mission3(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("검색할 도시의 대륙을 입력하시오(Asia,North America,등등");
		
		String searchName = sc.nextLine();

		rs = st.executeQuery("Select name, Continent from country where Continent = '" + searchName + "';");

		while (rs.next()) {
			printInBox(rs.getString("name") + ","+rs.getString("Continent"));
		}
	}

	public void mission4(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("얼마나 작은 면적을 가진 나라를 찾을건가요?(X < 국가 * 이때에 X는 입력값");

		int SurfaceArea = sc.nextInt();
		//오름차순 ORDER BY 앞에 스페이스를 안 넣어서 오류가 났었음
		rs = st.executeQuery("Select Name,SurfaceArea from country where SurfaceArea < " + SurfaceArea + " ORDER BY SurfaceArea ASC;");

		while (rs.next()) {
			printInBox(rs.getString("name") + "," + rs.getInt("SurfaceArea"));
		}

	}

	public void mission5(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("검색할 도시의 지역(Seoul,Pusan,Inchon)");

		String searchName = sc.nextLine();

		rs = st.executeQuery("SELECT Name,District From city WHERE District = '" + searchName + "';");

		while (rs.next()) {
			
			printInBox(rs.getString("name") + "," + rs.getString("District"));
		}
	}

	public void mission6(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("해당언어를 가진 ?(English,Dutch,Spanish)");

		String language = sc.nextLine();

		rs = st.executeQuery("SELECT CountryCode,Language,IsOfficial FROM countrylanguage WHERE Language = '" + language
				+ "' AND IsOfficial ='T';");

		while (rs.next()) {
			printInBox(rs.getString("CountryCode") + "," + rs.getString("Language") + rs.getString("IsOfficial"));
		}
	}

	public void mission7(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("몇 이상의 언어 비율을 가진 국가를 검색하고 싶으신가요?");

		int langRatio = sc.nextInt();

		rs = st.executeQuery(
				"SELECT CountryCode, Percentage FROM countrylanguage WHERE Percentage > " + langRatio + ";");

		while (rs.next()) {
			printInBox(rs.getString("CountryCode") + "," + rs.getDouble("Percentage"));
		}

	}
	
	public void mission9(Connection con, Statement st, ResultSet rs) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("몇 이상의 언어 비율을 가진 국가를 검색하고 싶으신가요?");

		int langRatio = sc.nextInt();

		rs = st.executeQuery(
				"SELECT CountryCode, Percentage FROM countrylanguage WHERE Percentage > " + langRatio + ";");

		while (rs.next()) {
			printInBox(rs.getString("CountryCode") + "," + rs.getDouble("Percentage"));
		}

	}

	public static void main(String[] args) {
		QueryStatement qs = new QueryStatement();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/world";

			con = DriverManager.getConnection(url, "root", "napkin");

			// 질의 객체 생성
			st = con.createStatement();

			
			boolean run = true;

			while (run) {

				
				System.out.println("1. 인구 수를 입력 받아서 그보다 많은 인구를 가진 도시를 검색.");
				System.out.println("2. 국가 명의 일부 또는 국가 코드를 입력 받아서 해당 국가의 도시의 이름과 인구를 검색.");
				System.out.println("3. 대륙을 입력 받아서 해당 대륙에 위치한 국가를 검색. (Continent)");
				System.out.println("4. 넓이(10,0002 km)를 입력 받아서 입력 값보다 작은 면적을 가진 국가의 이름과 면적을 면적 오름차순으로 검색");
				System.out.println("5. 대한민국의 District를 입력 받아서 해당 지역에 있는 모든 도시를 검색. (예:‘Kyonggi’)");
				System.out.println("6. 언어를 입력 받아서 해당 언어가 국가 공식 언어인 국가를 검색. (예:'Spanish’)");
				System.out.println("7. CountryLanguage에서 사용자가 입력 비율 이상인 언어의 국가 코드와 비율을 검색.");
				System.out.println();
				System.out.println("질의 1~7 중 하나를 고르시오(0은 종료)");
				int key = sc.nextInt();

				switch (key) {
				case 1: {
					qs.mission1(con, st, rs);
					break;
				}
				case 2: {
					qs.mission2(con, st, rs);
					break;
				}
				case 3: {
					qs.mission3(con, st, rs);
					break;
				}

				case 4: {
					qs.mission4(con, st, rs);
					break;
				}
				case 5: {
					qs.mission5(con, st, rs);
					break;
				}
				case 6: {
					qs.mission6(con, st, rs);
					break;
				}
				case 7: {
					qs.mission7(con, st, rs);
					break;
				}
				case 9: {
					qs.mission9(con, st, rs);
					break;
				}
				case 0: {
					run = false;
					System.out.println("감사합니다.");
					break;
				}
				default:
					continue;
				}
			}

		} catch (Exception e) {
			System.out.println("연결 실패.");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
				if (st != null)
					st.close();
				if (sc !=null)
					sc.close();

			} catch (Exception e) {

			}

		}
	}

}


