
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String dan = (String)request.getParameter("dan");


 
%>

	<%
	if(dan!=null)
	{
		int dnaNum = Integer.parseInt(dan);
		out.print("<span>" + dnaNum + "단" + "<span><br />");
		for (int i = 1; i < 10; i++) {
			out.print(dnaNum + " *" + i + "=" + dnaNum * i +",\t<br/>");
		}
	}
	else{
		out.print("값이 없습니다.");
	}

	%>

</body>
</html>