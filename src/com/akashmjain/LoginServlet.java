package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/login.jsp";
		request.getRequestDispatcher(url).include(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(validateLogin(username, password)) {
	        HttpSession session=request.getSession();
	        session.setAttribute("username", username);
	        session.setAttribute("password", password);
	        String dashboardUrl = "/contactus/admin/contactus/requests";
	        response.sendRedirect(dashboardUrl);
		} else {
			PrintWriter out = response.getWriter();
			out.println("Enter proper credentials");
		}
	}
	
	private boolean validateLogin(String username, String password) {
		ServletContext context = getServletContext();
		String verUsername = context.getInitParameter("username");
		String verPassword = context.getInitParameter("password");
		return (username.equals(verUsername) && password.equals(verPassword));
	}
}
