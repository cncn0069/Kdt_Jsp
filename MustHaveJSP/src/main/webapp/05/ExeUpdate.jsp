<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="common.JDBCConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	JDBCConnect jdbc = new JDBCConnect();
	
	String id = "test1";
	String pass = "1111";
	String name = "테스트1회원";
	
	String sql = "INSERT INTO member VALUES (?,?,?, CURRENT_TIMESTAMP)";
	//가급적이면 이렇게 확정을 지어주는게 좋다
	//String sql = "INSERT INTO member(id,pass,name) VALUES (?,?,?)";
	jdbc.setPsmt(jdbc.getCon().prepareStatement(sql));
	
	jdbc.getPsmt().setString(1, id);
	jdbc.getPsmt().setString(2, pass);
	jdbc.getPsmt().setString(3, name);
	
	int inResult = jdbc.getPsmt().executeUpdate();
	out.print(inResult + "행이 입력되었습니다.");
	
	jdbc.close();
	
	%>
</body>
</html>