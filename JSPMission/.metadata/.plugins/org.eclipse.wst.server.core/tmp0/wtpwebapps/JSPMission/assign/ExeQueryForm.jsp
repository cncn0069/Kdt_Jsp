<%@page import="java.sql.ResultSet"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse; /* 테두리 겹침 방지 */
	width: 100%; /* 테이블 너비 100% */
}

th, td {
	padding: 10px; /* 셀 안쪽 여백 */
	text-align: left; /* 텍스트 왼쪽 정렬 */
	border: 1px solid #ddd; /* 셀 테두리 */
}

tr:nth-child(even) {
	background-color: #f2f2f2; /* 짝수 행 배경색 */
}

tr:hover {
	background-color: #d1e7dd; /* 마우스 오버 시 배경색 */
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
<select name="fruits" id="fruits">
    <option value="apple">사과</option>
    <option value="banana">바나나</option>
    <option value="orange">오렌지</option>
</select>
	 -->


	<form action="ExeUpdateBoard.jsp" method="post">
		<table>
			<tbody>
				<tr>
					<td>title</td>
					<td><input type="text" id="title" name="title" value=""
						placeholder="값을 입력하세요"></td>
				</tr>
				<tr>
					<td>content</td>
					<td><input type="text" id="content" name="content" value=""
						placeholder="값을 입력하세요"></td>
				</tr>
				<tr>
					<td>id</td>
					<td>
					<select name = "id" id="id">
							<%

								JDBCConnect jdbc = new JDBCConnect();

								jdbc.setSt(jdbc.getCon().createStatement());

								String temp = "SELECT id FROM member";

								ResultSet rs = jdbc.getSt().executeQuery(temp);

								while (rs.next()) {
									out.print("<option value=\"" + rs.getString("id") + "\">" + rs.getString("id") + "</option>");
								
								}
							%>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>