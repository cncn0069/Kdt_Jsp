<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gugudan5.jsp" method="post">
	<input type="radio" id="hGugu" name="gugudan" value="1">
  	<label for="hGugu">Type1: 세로</label><br>
  	<input type="radio" id="wGugu" name="gugudan" value="2">
  	<label for="wGugu">Type2: 가로</label><br>
  	<input type="radio" id="oneGugu" name="gugudan" value="3">
  	<label for="oneGugu">Type3: 하나만 출력</label><br>
  	<input type="radio" id="mutiGugu" name="gugudan" value="4">
  	<label for="mutiGugu">Type4: 여러개씩 묶어서 출력</label><br/>
  	<input type="text" name="guValue"><br>
	<input type="submit" value="단수/열수">
	</form>
	
	<%
	
	String gugudan = request.getParameter("gugudan");
	String guValue = request.getParameter("guValue");
	
	if(gugudan !=null)
	{
		String redirectURL = "";
	    switch(gugudan) {
	        case "1":
	            redirectURL = "gugudan1.jsp"+ "?dan=";
	            break;
	        case "2":
	            redirectURL = "gugudan2.jsp"+ "?dan=";
	            break;
	        case "3":
	            redirectURL = "gugudan3.jsp" + "?dan=";
	            break;
	        case "4":
	            redirectURL = "gugudan4.jsp" + "?var=";
	            break;
	         default:
	        	 break;

	    }
	    response.sendRedirect(redirectURL + guValue);
		
	}
	
	%>
</body>
</html>