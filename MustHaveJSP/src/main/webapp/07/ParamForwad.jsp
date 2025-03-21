<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="common.Person" scope="request"></jsp:useBean>
	<h2>포워드된 페이제에서 매개변수 확인</h2>
	
	<ul>
		<li><jsp:getProperty property="name" name="person"/> </li>
		<li>나이 : <jsp:getProperty property="age" name="person"/> </li>
		<li>본명 : <%= request.getParameter("param1") %> </li>
		<li>출생 : <%= request.getParameter("param2") %></li>
		<li>특징 : <%= request.getParameter("param3") %></li>
	</ul>
	<jsp:include page="./inc/ParmaInclude.jsp">
		<jsp:param value="loc1" name="Gang"/>
		<jsp:param value="loc2" name="Kim"/>
	</jsp:include>
	
</body>
</html>