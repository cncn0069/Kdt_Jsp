<%@page import="common.MemberDAO"%>
<%@page import="common.MemberDTO"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String userId = request.getParameter("user_id");
	String userPwd =request.getParameter("user_pw");
	
	String mysqlDriver = application.getInitParameter("MySQLDriver");
	String mysqlURL = application.getInitParameter("MySQLURL");
	String mysqlId = application.getInitParameter("MySQLId");
	String mysqlPwd = application.getInitParameter("MySQLPwd");
	
	MemberDAO dao = new MemberDAO(mysqlDriver,mysqlURL,mysqlId,mysqlPwd);
	MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
	
	if(memberDTO.getId() !=null){
		session.setAttribute("UserId", memberDTO.getId());
		session.setAttribute("UserName", memberDTO.getName());
		response.sendRedirect("LoginForm.jsp");
	}
	else{
		request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>