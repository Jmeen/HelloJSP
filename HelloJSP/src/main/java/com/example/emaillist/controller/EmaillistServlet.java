package com.example.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.emaillist.dao.EmaillistDao;
import com.example.emaillist.dao.EmaillistDaoImpl;
import com.example.emaillist.vo.EmailVO;

@WebServlet(name = "Emaillist", urlPatterns = "/el")
public class EmaillistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 4. 파라미터 확인
		// a=form이면 가입폼으로 Fowoad
		String actionName = req.getParameter("a");
		if ("form".equals(actionName)) {
			// a = form이면
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			// 전달
			rd.forward(req, resp);

		} else {

			// 요청과 응답객체를 받았으니, DAO로부터 목록을 받아서 JSP로 전달.
			// 1. 목록 가져오기
			EmaillistDao dao = new EmaillistDaoImpl();
			List<EmailVO> list = dao.getlist();

			// 3. 요청에 list를 추가
			// list 객체를 list 키로 추가
			req.setAttribute("list", list);

			// JSP로 요청을 전달 (FORWARD)
			// 2. dispatcher 확보
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");

			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if ("add".equals(actionName)) {
			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String email = req.getParameter("email");

			// vo 객체 생성
			EmailVO vo = new EmailVO();
			vo.setLastname(lastName);
			vo.setFirstname(firstName);
			vo.setEmail(email);

			// insert 처리
			EmaillistDao dao = new EmaillistDaoImpl();
			int insertedcount = dao.insert(vo);

			// 처리 후 list페이지로 redirect
			resp.sendRedirect(req.getContextPath() + "/el");

		} else if ("delete".equals(actionName)) {
			// a = delete면
			
			Long no = Long.valueOf(req.getParameter("no"));
			EmaillistDao dao = new EmaillistDaoImpl();
			int deletedcount = dao.delete(no);
			// 리스트 페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/el");

		} else {
			doGet(req, resp);
		}
	}
}
