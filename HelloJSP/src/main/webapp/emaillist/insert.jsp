<%@page import="com.example.emaillist.vo.EmailVO"%>
<%@page import="com.example.emaillist.dao.EmaillistDaoImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 파라미너 받아오기

String lastName = request.getParameter("last_name");
String firstName = request.getParameter("first_name");
String email = request.getParameter("email");

// 파라미터 확인

//DAO
EmaillistDao dao = new EmaillistDaoImpl();

// vo객체 생성
EmailVO vo = new EmailVO();
vo.setLastname(lastName);
vo.setFirstname(firstName);
vo.setEmail(email);
dao.insert(vo);

// INDEX.jsp로 리다이렉트(페이지전환 302)
response.sendRedirect(request.getContextPath()+"/emaillist/");
%>

<H3>
	성 :
	<%=lastName%></H3>
<H3>
	이름 :
	<%=firstName%></H3>
<H3>
	이메일 :
	<%=email%></H3>