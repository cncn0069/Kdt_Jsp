<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
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
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	
	out.print(id + pass + name);
	
	if(id !=null && pass !=null && name != null)
	{
		JDBCConnect jdbc = new JDBCConnect();
		
		jdbc.setPsmt(jdbc.getCon().prepareStatement("INSERT INTO member(`id`,`pass`,`name`) VALUES (?,?,?)"));
		
		
		jdbc.getPsmt().setString(1,id);
		jdbc.getPsmt().setString(2, pass);
		jdbc.getPsmt().setString(3, name);
		
		jdbc.getPsmt().executeUpdate();
		jdbc.close();	
	}
	
	%>
</body>
</html>