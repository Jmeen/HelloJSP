<%@page import="com.toyproject.pos.vo.ProductVo"%>
<%@page import="java.util.List"%>
<%@page import="com.toyproject.pos.dao.ProductDaoImpl"%>
<%@page import="com.toyproject.pos.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ProductDao dao = new ProductDaoImpl();
List<ProductVo> list = dao.getlist();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
</head>
<body>
	<h1>Toy project</h1>
	<p>기초부터 차근차근</p>

	<table border="1">
		<caption>
			<b>재밍다방 메뉴판</b>
		</caption>
		<thead>
			<tr>
				<td width="180" align="center">메 뉴</td>
				<td width="180" align="center">가 격</td>
				<td></td>
			</tr>
		</thead>
		<%
		for (ProductVo vo : list) {
		%>
		<tbody>
			<tr>
				<td width="180" align="center">	<%=vo.getName()%></td>
				<td width="180" align="center">	\<%=vo.getPrice()%></td>
				<form action="<%=request.getContextPath()%>/toy_pos/cart.jsp"					
				method="post">
				<input type="hidden" name="add" value="<%=vo.getid()%>"> 
				<td width="50" align="center"><input type="submit" VALUE="담기">
				</td>
			</tr>
		</tbody>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td align="center"><input type="submit" value="add" ></td>
			</tr>
		</tfoot>
	</table>
	<br>
		<h>
		<a href="<%=request.getContextPath()%>/toy_pos/cart.jsp">장바구니 가기</a>
		</h>
</body>
</html>