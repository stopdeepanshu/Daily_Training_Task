package org.servlettraining.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.servlettraining.com.config.AppConfig; // ⭐ SPRING CORE
import org.servlettraining.com.dao.UserDao;
import org.servlettraining.com.entity.Users;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; // ⭐ SPRING CORE

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // IoC
																												// Container

		UserDao dao = context.getBean(UserDao.class); // Bean

		Users user = dao.checkLogin(username, password);

		if (user != null) {

			request.setAttribute("greet", username);

			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);

		} else {

			request.setAttribute("msg", "Login Failed");

			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}