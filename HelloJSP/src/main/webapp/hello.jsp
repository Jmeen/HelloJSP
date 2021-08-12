<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h3>Hello JSP</h3>
	<!- name parameter 받아오기-!> <%
 // java code
 String name = request.getParameter("name");

 // 파라메터 전송되지 않으면
 if (name == null) {
 	name = "Anonymous";
 }
 %>
	<p><%=name%></p>
</body>
</html>