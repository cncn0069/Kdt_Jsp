<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>서비스 중 일시적인 오류가 발생하였습니다.</h2>
	<p>
	<%
	if(exception instanceof java.lang.NumberFormatException)
	{
		out.println("오류 클래스 : " + exception.getClass().getName());
		out.println("오류 메시지 : " + exception.getMessage()) ;
	}
	%>
	
	</p>
</body>
</html>