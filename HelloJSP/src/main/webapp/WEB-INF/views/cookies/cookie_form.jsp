<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String cookievalue = (String) request.getAttribute("example");
if (cookievalue == null) {
	cookievalue = "";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie Test Form</h1>

	<h3>Add/Edit Cookie</h3>
	<form method="post" action="cookies">
		<label for="example">cookie value</label> 
		<input type="text" name="example" id="example" value="<%=cookievalue %>"> 
		<input type="submit" value="쿠키설정">

	</form>

	<h3>Delete cookie</h3>
	<a href="<%=request.getContextPath()%>/cookies?a=delete">쿠키삭제</a>

</body>
</html>