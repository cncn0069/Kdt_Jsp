<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ExeUpdateBoard.jsp" method="post">
		<label for="title">Title:</label> 
		<input type="text" id="title"
			name="title" value="" placeholder="값을 입력하세요"> <br>
		
		<label for="content">Content:</label> 
		<input type="text" id="content"
			name="content" value="" placeholder="값을 입력하세요"> <br>
		
		<label for="id">NAME:</label> 
		<input type="text" id="id"
			name="id" value="" placeholder="값을 입력하세요"> <br>
		<input type="submit" value="Submit">
	</form>
	
	
</body>
</html>