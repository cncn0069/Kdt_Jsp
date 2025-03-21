<%@page import="java.lang.annotation.Documented"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setAttribute("requestGCD", 0);
%>
<%!//request 변수 생성

	public int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="GCD.jsp" method="post">
		<label for="number1">숫자 1:</label> <input type="text" id="number1"
			name="number1" value="" placeholder="숫자를 입력하세요"><br> <label
			for="number2">숫자 2:</label> <input type="text" id="number2"
			name="number2" value="" placeholder="숫자를 입력하세요"><br> <label
			for="GCD">GCD</label> <input type="text" id="GCD" name="GCD"
			value="0" readonly><br> <label for="LCM">LCM</label> <input
			type="text" id="LCM" name="LCM" value="0" readonly><br>

		<input type="submit" value="Submit">
	</form>

	<%
		int number1 = 1;
		int number2 = 1;
	
		if(request.getParameter("number1") != null)
		{
			number1 = Integer.parseInt(request.getParameter("number1"));
			number2 = Integer.parseInt(request.getParameter("number2"));
		}
	
		

		if(number1 < number2)
		{
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}
		
		int GCD = gcd(number1, number2);
		int LCM = (number1*number2)/GCD;
		
	%>
	<script>
	document.getElementById("GCD").value = "<%= GCD%>";
	document.getElementById("LCM").value = "<%= LCM%>";
	</script>
</body>
</html>