<%@page import="java.sql.ResultSetMetaData"%>
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
	<%
	JDBCConnect jdbc = new JDBCConnect();

	jdbc.setSt(jdbc.getCon().createStatement());

	ResultSet rs = jdbc.getSt().executeQuery("SELECT num,title,postdate,visitcount FROM board");
	ResultSetMetaData mtrs = rs.getMetaData();

	out.print("<table>");
	out.print("<thead>");
	out.print("<tr>");
	for (int i = 1; i <= mtrs.getColumnCount(); i++) {
		out.print("<th>" + mtrs.getColumnName(i) + "</th>");
	}
	out.print("</tr>");
	out.print("</thead>");
	out.print("<tbody>");
	while (rs.next()) {
		out.print("<tr>");
		out.print("<td>" + rs.getString("num") + "</td>");
		out.print("<td>" + rs.getString("title") + "</td>");
		out.print("<td>" + rs.getString("postdate") + "</td>");
		out.print("<td>" + rs.getString("visitcount") + "</td><br>");
		out.print("</tr>");
	}
	out.print("</tbody>");
	out.print("</table>");
	%>
</body>
</html>