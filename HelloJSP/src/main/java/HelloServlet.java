import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿은 HttpServlet을 상속
public class HelloServlet extends HttpServlet {

	// GET방식의 요청을 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 응답의 페이지 타입 결정
		resp.setContentType("text/html; charset=UTF-8");

		// 파라미터 확인
		String name = req.getParameter("name");
		if (name == null) {
			name = "Anonymous";
		}

		// 응답 출력을 위한 Writer
		PrintWriter out = resp.getWriter();
		out.println("<h3>Hello Servlet</h3>");
		out.println("<p>Welcome, " + name + "</p>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 데이터 인코딩 설정
		// 요청 데이터 인코딩 설정
//		req.setCharacterEncoding("UTF-8");
//		// 페이지 응답 설정s
//		resp.setContentType("text/html; charset=UTF-8");

		// 폼 데이터 받기(파라미터 받기)
		// input tag의 name 속성의 이름
		String firstname = req.getParameter("First_name");
		String lastname = req.getParameter("Last_name");

		PrintWriter out = resp.getWriter();
		out.println("<h3>From Data</h3>");
		out.println("<p>성:" + lastname + "</p>");
		out.println("<p>이름:" + firstname + "</p>");

	}

}
