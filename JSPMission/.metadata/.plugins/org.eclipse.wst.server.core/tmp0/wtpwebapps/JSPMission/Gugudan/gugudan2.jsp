<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>

<style>
table {
	border: 1px solid;
	border-collapse: collapse;
}

td, tr {
	border: 1px solid;
	padding: 4px 10px;
}

.title {
	text-align: center;
	background-color: lightgray;
}
</style>
</head>
</head>

<body>

	<table border="1" style="" class="title">

		<thead>
			<tr>
				<%
				
				String varSt = (String) request.getParameter("dan");
				int dan =2;
				
				if(varSt != null)
				{
					dan = Integer.parseInt(varSt);
				}
				for (int i = dan; i < 10; i++) {
					out.print("<th>" + i + "단" + "</th>");
				}
				%>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 1; i < 10; i++) {
			%>
			<tr>
				<%
				for (int j = dan; j < 10; j++) {
					out.print("<td>" + j + "*" + i + "=" + i * j);
				}
				%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<%

	%>

</body>
</html>