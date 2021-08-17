<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome : Join Form</title>
</head>
<body>
	<h1>Join Form</h1>
		<form method="POST" action="<%= request.getContextPath() %>/users">
		<input type="hidden" name="a" value="join">
		<label for="name">이름<label>
			<input type="text" name="name" id="name"/><br />
		<label for="password">비밀번호</label>
			<input type="text" name="password" id= "password"/><br/>
		<label for="password">이메일</label>
			<input type="text" name="email" id= "email"/><br/>
		<label for="password">성별</label>
			<input type="radio" name="gender" value="F" checked/>여성
			<input type="radio" name="gender" value="M"/><br/>남성
		<input type="submit" value="가입"/>
		</form>

</body>
</html>