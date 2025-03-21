<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBCConnect"%>
<%@page import="java.sql.JDBCType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	JDBCConnect jdbc = new JDBCConnect();
	
	String sql = "SELECT id,pass,name, regidate FROM member";
	
	Statement stmt = jdbc.getCon().createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	ResultSetMetaData meta = rs.getMetaData();
	out.print("<table border=\"1\">");
	out.print("<thead>");
	
	for(int i = 1; i <= meta.getColumnCount();i++)
	{
		out.print("<th>" + meta.getColumnName(i) + "</th>");
	}
	out.print("</thead>");
	out.print("<tbody>");
	while(rs.next())
	{
		out.print("<tr>");
			String id = rs.getString(1);
			out.print("<td>" + id +"</td>");
			
			String pw = rs.getString(2);
			out.print("<td>" + pw +"</td>");
			
			String name = rs.getString("name");
			out.print("<td>" + name +"</td>");
			
			Date regidate = rs.getDate("regidate");
			out.print("<td>" + regidate +"</td>");
		out.print("</tr>");

	}
	out.print("</tbody>");
	out.print("</table>");
	
	%>
</body>
</html>