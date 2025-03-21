package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DriverLoading {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/world";
			//String url = "jdbc:mysql://10.125.121.178:3306/world";

			// 커넥션 만들기
			con = DriverManager.getConnection(url, "musthave", "napkin");

			// 질의객체 생성
			st = con.createStatement();

			// 질의문 날리기 ResultSet
			// 첫행은 빈행
			while (true) {
				rs = st.executeQuery("select id, name, countrycode, " + "district, population from city");
				rs.next();
				rs = st.executeQuery("Select Name,SurfaceArea from country where SurfaceArea < " + "1" + " ORDER BY SurfaceArea ASC;");
				rs.next();
				rs = st.executeQuery("Select Name,Population from city where Population > 10000 ORDER BY population;");
				rs.next();
				rs = st.executeQuery("SELECT country.name,city.name,CountryCode,District from city join country on city.CountryCode=country.code where CountryCode like '%%' || country.name like '%%';");
				rs.next();
				rs = st.executeQuery("SELECT name, Continent from country where Continent = '';");
				rs.next();
				rs = st.executeQuery("SELECT Name,District From city WHERE District = '';");
				rs.next();
				rs = st.executeQuery("SELECT CountryCode,Language,IsOfficial FROM countrylanguage WHERE Language = '' AND IsOfficial ='T';");
				rs.next();
			}

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {

				// 예외가 발생해도 모두 닫히도록
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
}