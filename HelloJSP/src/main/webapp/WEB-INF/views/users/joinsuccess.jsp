<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/Includes/header.jsp">
	<jsp:param value="가입에 성공하셧습니다." name="message"/></jsp:include>

	
	<a href="<%=request.getContextPath() %>">메인홈으로</a> 

<%@ include file ="/WEB-INF/views/Includes/footer.jsp" %>