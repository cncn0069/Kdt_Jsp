<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>향상된 for문 형태의 forEach 태그</h4>
	<%
	String rgba ="Red, Green, Blue, Black";
	%>
	
	<c:forTokens items="<%=rgba%>" delims="," var="color">
		<span style="color:${color};">${color}</span>
	</c:forTokens>

</body>
</html>