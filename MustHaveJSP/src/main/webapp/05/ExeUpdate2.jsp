<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	
	if(id != null && title !=null && content !=null)
	{
		JDBCConnect jdbc = new JDBCConnect();
		PreparedStatement pst = jdbc.getCon().prepareStatement("INSERT INTO board(id,title,content) VALUES(?,?,?)");
		
		pst.setString(1, id);
		pst.setString(2, title);
		pst.setString(3, content);
		
		pst.executeUpdate();
		
		out.print("추가 완료");
	}else{
		out.print("다시 입력하세요.");
	}
	
	
%> 


</body>
</html>