<%@page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.JDBCConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JDBC 테스트 1</h2>
	<% 
	String driver = application.getInitParameter("MySQLDriver");
	String url = application.getInitParameter("MySQLURL");
	String id = application.getInitParameter("MySQLId");
	String pwd = application.getInitParameter("MySQLPwd");
	
	
	JDBCConnect jdbc1 = new JDBCConnect();
	jdbc1.close();
	
	JDBCConnect jdbc2 = new JDBCConnect(driver,url,id,pwd);
	jdbc2.close();
	
	JDBCConnect jdbc3 = new JDBCConnect(driver,url,id,pwd);
	jdbc3.close();
	
	DBConnPool dbPool = new DBConnPool();
	dbPool.close();
	%>
	

</body>
</html>