<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MinBill.jsp" method="post">
		<label for="bill">지불금액:</label> 
		<input type="text" id="bill"
			name="bill" value="" placeholder="숫자를 입력하세요"> <br>
		
		<label for="bagain">할인금액:</label> 
		<input type="text" id="bagain" name="bagain" value="" readonly><br>
		
		<label for="5B">오만원권:</label> 
		<input type="text" id="5B" name="5B" value="" readonly><br>
		
		<label for="1B">일만원권:</label> 
		<input type="text" id="1B" name="1B" value="" readonly><br>
			
		<label for="5T">오천원권:</label> 
		<input type="text" id="5T" name="5T" value="" readonly><br>
		
		<label for="1T">일천원권:</label> 
		<input type="text" id="1T" name="1T" value="" readonly><br>
			
		<input type="submit" value="Submit">
	</form>
	<%
		int bill = 0;
		int barGain = 0;
		int fiveB = 0;
		int oneB = 0;
		int fiveT = 0;
		int oneT = 0;
		
		if(request.getParameter("bill") != null)
		{
			
			bill = 	Integer.parseInt(request.getParameter("bill"));
			barGain = bill%100;
			bill = bill - barGain;
			
			fiveB = bill/50000;
			bill = bill - (fiveB*50000);
			
			oneB = bill/10000;
			bill = bill - (oneB*10000);
			
			fiveT = bill/5000;
			bill = bill - (fiveT*5000);
			
			oneT = bill/1000;
		}
	%>
	
	<script>
	document.getElementById("bagain").value = "<%= barGain%>";
	document.getElementById("5B").value = "<%= fiveB%>";
	document.getElementById("1B").value = "<%= oneB%>";
	document.getElementById("5T").value = "<%= fiveT%>";
	document.getElementById("1T").value = "<%= oneT%>";
	</script>
</body>
</html>