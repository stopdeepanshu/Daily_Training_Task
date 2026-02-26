package org.servlettraining.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String mssg = "";

	public void init() {
		mssg = "This value is comming from init()";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("Enter");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("<html>")
//		.append("<head><body>")
//		.append("<h1>")
//		.append("Hello, this is HTML in doGet served by HomeServlet!")
//		.append("</h1></body></head></html>");

		response.sendRedirect("home.jsp");// agar data nahi bhejna sirf redirect krna hai to isko use krenge
//		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");// agar data bhejna chah rha hai to requestDispatcher use krenge
//		request.setAttribute("greet", mssg);
//		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
