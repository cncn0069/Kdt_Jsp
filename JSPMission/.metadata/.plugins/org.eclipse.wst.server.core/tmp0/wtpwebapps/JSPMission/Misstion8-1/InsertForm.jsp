<%@page import="common.IdInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
List<IdInfo> list = (List<IdInfo>)session.getAttribute("idList");
if (list == null) {
	list = new  ArrayList<IdInfo>();
	session.setAttribute("idList", list);
}
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="InsertProcess.jsp" method="post">
		<label for="title">아이디:</label> 
		<input type="text" id="id"
			name="id" value="" placeholder="값을 입력하세요"> <br>
		
		<label for="content">암호:</label> 
		<input type="text" id="pass"
			name="pass" value="" placeholder="값을 입력하세요"> <br>
		
		<label for="id">이름:</label> 
		<input type="text" id="name"
			name="name" value="" placeholder="값을 입력하세요"> <br>
		<input type="submit" value="입력">
	</form>
	
	
<%
out.println("<h2>" + list.size() + "</h2>");
if(request.getParameter("errmsg") != null)
{
	out.print(request.getParameter("errmsg") +"<br>");	
}
%>
</body>
</html>