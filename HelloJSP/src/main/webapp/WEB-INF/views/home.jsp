<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Include할때 상단 정보 통일할 것. -->
<!-- 동적 페이지 Include -->
<jsp:include page="/WEB-INF/views/Includes/header.jsp">
	<jsp:param value="메인페이지" name="message"/></jsp:include>
	
	<ul>
		<li><a href="<%=request.getContextPath() %>/users?a=joinform">회원가입</a></li>
		<li><a href="<%=request.getContextPath() %>/users?a=loginform">로그인</a></li>
	</ul>

	<H4>GET 전송</H4>
	<!--  
	URL로 Data를 전송한다
	parameter는 ? 뒤에 파라메터명=파라메터값으로 전송
	여러개의 파라미터는 &로 연결한다. -->

	<p>
		<a href="hs?name=Servlet">HelloServelt 요청</a>
	</p>

	<H4>POST 전송</H4>
	<!-- 사용자 입력 데이터 전송을 위한 form tag -->
	<form action="hs" method="POST">
		<label for="Last_name"> 성 </label> 
		<input type="text" name="Last_name"	id="Last_name" /><br /> 
		<label for="First_name">이름</label> 
		<input type="text" name="First_name" id="First_name" /><br /> 
		<input type="submit" value="전송" />
	</form>

	<H3> Emaillist (model 1)</H3>
	<p>
		<a href="/web/emaillist/">이메일 리스트(Model 1) 목록</a>
	</p>
	
	<h4> Emaillist (Model 2:MVC)</h4>
	<p><a href="/web/el">이메일 리스트 (Model 2)</a>
	
	<h4>Cookie Test</h4>
	<p><a href="<%=request.getContextPath() %>/cookies">쿠키테스트</a>	
<!--  정적 페이지 include -->
<%@ include file ="/WEB-INF/views/Includes/footer.jsp" %>
