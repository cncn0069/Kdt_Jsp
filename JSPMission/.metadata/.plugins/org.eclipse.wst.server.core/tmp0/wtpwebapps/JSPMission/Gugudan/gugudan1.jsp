<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String varSt = (String) request.getParameter("dan");
int dan =2;

if(varSt != null)
{
	dan = Integer.parseInt(varSt);
}

for(int i = dan; i<10;i++){
	for(int j = 2; j<10;j++){
		out.print(i + " * " +j + " = " + i*j+ "<br/> ");
	}
}
%>
</body>
</html>