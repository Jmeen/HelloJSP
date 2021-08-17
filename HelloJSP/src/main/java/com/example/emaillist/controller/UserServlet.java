package com.example.emaillist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");

		if ("joinform".equals(actionName)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		} else if ("joinsuccess".equals(actionName)) {
			// a= joinsuccess
			// 가입성공페이지
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendError(404);  // page not found
		}
		// get 요청 처리

	}
}
