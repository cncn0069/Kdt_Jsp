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
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");

	if(title !=null && content !=null && id != null)
	{
		JDBCConnect jdbc = new JDBCConnect();
		
		jdbc.setPsmt(jdbc.getCon().prepareStatement("INSERT INTO board(`title`,`content`,`id`) VALUES (?,?,?)"));
		
		
		jdbc.getPsmt().setString(1,title);
		jdbc.getPsmt().setString(2, content);
		jdbc.getPsmt().setString(3, id);
		
		jdbc.getPsmt().executeUpdate();
		jdbc.close();	
	}
	
	%>
</body>
</html>