<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="common.IdInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	
	List<IdInfo> idList = (ArrayList<IdInfo>)session.getAttribute("idList");
	
	if(id!=null && name!=null&& pass!=null)
	{
		response.sendRedirect("InsertForm.jsp?errmsg=fail");
		return;
	}
	
	for(int i = 0; i < idList.size();i++)
	{
		//아이디가 있다면 ..
		if(idList.get(i).getId().compareTo(id) == 0)
		{
			response.sendRedirect("InsertForm.jsp?errmsg=가입실패");
			return;
//			request.getRequestDispatcher("InsertForm.jsp?errmsg=가입실패")
//			.forward(request, response);
		}
		
	}
	//없다면
	idList.add(new IdInfo(id,name,pass));
	response.sendRedirect("InsertSuccess.jsp");
	
	%>
</body>
</html>