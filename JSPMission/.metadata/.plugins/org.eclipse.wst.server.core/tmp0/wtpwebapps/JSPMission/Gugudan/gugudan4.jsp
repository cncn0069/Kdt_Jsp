<%@page
	import="org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("myCookie", "3");
cookie.setPath(request.getContextPath());
cookie.setMaxAge(100);
response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid;
	border-collapse: collapse;
}

td, tr, th {
	border: 1px solid;
	padding: 4px 10px;
}

.title {
	text-align: center;
	background-color: lightgray;
	width: 20px;
}
</style>
</head>
<body>

	<%
	String varSt = (String) request.getParameter("var");
	Cookie[] cookies = request.getCookies();
	int var = 0;
	int check = 0;
	if (varSt == null) {

		//쿠키가 있다면
		for (Cookie n : cookies) {
			//원하는 쿠키를 찾으면
			if (n.getName().equals("myCookie")) {
		//쿠키안의 값으로 저장
		var = Integer.parseInt(n.getValue());
		check++;
		response.addCookie(n);
		break;
			}
		}

		if (check == 0) {
			var = 3;
		}

	} else {
		var = Integer.parseInt(varSt);
		for (int i = 0; i < cookies.length; i++) {
			//원하는 쿠키를 찾으면
			if (cookies[i].getName().equals("myCookie")) {
		//쿠키안에 값 저장
		cookies[i].setValue(String.valueOf(var));
		response.addCookie(cookies[i]);
			}
		}
	}
	//response에 추가하질 않음

	int condition = 0;
	//원하는 단 +1
	int dan = 10;

	int abcd = (int) (Math.ceil(dan / var));
	if (Math.ceil(dan / var) == 1)
		abcd = abcd + 1;
	%>

	<%
	for (int temp = 0; temp < abcd; temp++) {
	%>
	<table border="1" style="" class="title">
		<thead>
			<tr>
				<%
				for (int i = 2; i < var + 2; i++) {
					if (i + condition >= dan)
						break;
					out.print("<th>" + (i + condition) + "단" + "</th>");
				}
				%>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 1; i < 10; i++) {
			%>
			<tr>
				<%
				for (int j = 2; j < var + 2; j++) {
					if (j + condition >= dan)
						break;

					out.print("<td>" + (j + condition) + "*" + i + "=" + (i * (j + condition)));

				}
				%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	//단을 빼고
	condition = condition + var;
	}
	%>
</body>
</html>