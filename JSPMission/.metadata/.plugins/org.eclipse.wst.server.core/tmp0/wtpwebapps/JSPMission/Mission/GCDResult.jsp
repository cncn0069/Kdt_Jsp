<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%!
		public int gcd(int x, int y)
		{
			if(y==0)
				return x;
			else
				return gcd(y, x%y);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
	
	%>
</body>
</html>