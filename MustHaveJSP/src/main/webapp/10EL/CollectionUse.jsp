<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>List 컬렉션</h2>
<%
List<Object> aList = new ArrayList<Object>();
aList.add("청해진");
aList.add(new Person("장보고", 28));
pageContext.setAttribute("Ocean", aList);
%>
<ul>
	<li>0번째 요소 : ${ Ocean[0] }</li>
	<li>1번째 요소 : ${ Ocean[1].name }, ${ Ocean[2].name }</li>
	<li>2번째 요소 : ${ Ocean[2] }</li>
</ul>
<h2>Map 컬랙션</h2>
<%
Map<String, String> map = new HashMap<String,String>();
map.put("稜堡", "稜堡");
map.put("Eng", "English");
pageContext.setAttribute("King", map);
%>

<ul>
	<li>영문 Key : ${King["Eng"] }, ${King['Eng'] }, ${King.Eng }</li>
	<li>한글 Key : ${King["稜堡"] }, ${King['稜堡'] }, ${ King.稜堡 }</li>
</ul>
</body>
</html>