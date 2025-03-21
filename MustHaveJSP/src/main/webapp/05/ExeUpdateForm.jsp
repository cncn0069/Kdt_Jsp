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
<form action="./ExeUpdate2.jsp" method="post">
	  <label for="id">ID:</label><br>
	  <input type="text" id="id" name="id" value="id"><br>
	  
	  <label for="title">타이틀:</label><br>
	  <input type="text" id=title name="title" value="title"><br>
	  
	  <label for="content">입력하세요:</label><br>
	  <input type="text" id="content" name="content" value="content"><br><br>
	  <input type="submit" value="Submit">
</form>

</body>
</html>