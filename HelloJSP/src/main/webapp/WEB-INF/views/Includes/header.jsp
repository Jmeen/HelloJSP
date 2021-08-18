<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String message = request.getParameter("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home</title>
</head>
<body>
	<h3>My Home</h3>
	<p>이것은 Jaemin이 만든 첫번째 HTML입니다.</p>
	<P><%=message%></P>