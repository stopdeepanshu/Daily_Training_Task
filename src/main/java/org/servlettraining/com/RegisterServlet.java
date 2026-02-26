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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // ⭐ IoC
																												// Container

		UserDao dao = context.getBean(UserDao.class); // ⭐ Bean

		Users user = new Users();

		user.setUsername(username);
		user.setPassword(password);

		dao.registerUser(user);

		request.setAttribute("msg", "Registration Successful");

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}