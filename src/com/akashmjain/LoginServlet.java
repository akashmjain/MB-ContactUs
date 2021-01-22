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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/login.jsp";
		request.getRequestDispatcher(url).include(request, response);
		
		ServletContext context = getServletContext();
		String username = request.getParameter("username") == null ? "" : request.getParameter("username");
		String password = request.getParameter("password") == null ? "" : request.getParameter("password");
		String verUsername = (String)context.getInitParameter("username");
		String verPassword = (String)context.getInitParameter("password");
		
		if(username.equals(verUsername) && password.equals(verPassword)) {
	        HttpSession session=request.getSession();
	        session.setAttribute("username", username);
	        session.setAttribute("password", password);
	        String dashboardUrl = "/admin/contactus/requests";
	        request.getRequestDispatcher(dashboardUrl).include(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<br/><br/>Please Enter correct password");
		}
	}
}
