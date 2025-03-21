<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="IsErrorPage.jsp"%>

<%!public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int mutlple(int num1, int num2) {
		return num1 * num2;
	}

	public double devide(double num1, double num2) {
		return num1 / num2;
	}

	public int minus(int num1, int num2) {

		return num1 - num2;
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
	int result = add(10, 20);
	%>
	덧셈 결과 1 :	<%=result%>
	<br /> 덧셈 결과 2 :	<%=add(Integer.parseInt(request.getParameter("num1")), Integer.parseInt(request.getParameter("num2")))%>
	<br /> 
	곱셈 결과 :<%=mutlple(Integer.parseInt(request.getParameter("num1")), Integer.parseInt(request.getParameter("num2"))) %>
	<br /> 
	뺄셈 결과 :<%=minus(Integer.parseInt(request.getParameter("num1")), Integer.parseInt(request.getParameter("num2"))) %>
	<br />
	나눗셈 결과 :<%=devide(Double.parseDouble(request.getParameter("num1")), Double.parseDouble(request.getParameter("num2"))) %>
	<br />

</body>
</html>