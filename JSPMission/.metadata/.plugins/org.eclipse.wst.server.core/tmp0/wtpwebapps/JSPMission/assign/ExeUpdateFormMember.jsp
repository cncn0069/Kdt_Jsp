<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ExeUpdateMember.jsp" method="post">
		<label for="id">ID:</label> 
		<input type="text" id="id"
			name="id" value="" placeholder="숫자를 입력하세요"> <br>
		
		<label for="pass">PWD:</label> 
		<input type="text" id="pass"
			name="pass" value="" placeholder="숫자를 입력하세요"> <br>
		
		<label for="name">NAME:</label> 
		<input type="text" id="name"
			name="name" value="" placeholder="숫자를 입력하세요"> <br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>