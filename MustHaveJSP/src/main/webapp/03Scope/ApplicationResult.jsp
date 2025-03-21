<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Set" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>application 영역의 속성 읽기</h2>
	<%
	Map<String, Person> maps = (Map<String, Person>)application.getAttribute("maps");
	
	if(maps != null)
	{
		
		Set<String> keys = maps.keySet();
		for(String key : keys){
			Person person = maps.get(key);
			out.print(String.format("이름 : %s, 나이 : %d<br/>",
					person.getName(), person.getAge()));
			
		}
	}else{
		out.print("값이 없습니다.");
	}
	

	%>
</body>
</html>