<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/Includes/header.jsp">
	<jsp:param value="Login" name="message"/></jsp:include>
	
<body>
	<h1>Login</h1>
	<form method="post" action="<%=request.getContextPath()%>/users">
	<!-- action parameters -->
		<input type="hidden" name="a" value="login"/>
		<label for="email">이메일</label>	
		<input type="text" name="email" id ="email"><br>
		<label for="password">패스워드</label>	
		<input type="text" name="password" id ="password"><br>
		<input type="submit" value="로그인">
	</form>
		<a href="<%=request.getContextPath() %>">돌아가기</a>
		
<%@ include file ="/WEB-INF/views/Includes/footer.jsp" %>