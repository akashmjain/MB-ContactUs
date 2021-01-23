package com.akashmjain.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/admin/login/validation")
public class LoginFilter implements Filter {

	public void destroy() {}
	
	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		PrintWriter out = res.getWriter();
		String username = request.getParameter("username") == null ? "" : request.getParameter("username");
		String password = request.getParameter("password") == null ? "" : request.getParameter("password");
		if(validateLogin(username, password, request)) {
			chain.doFilter(request, response);    
		} else {
			out.println("Enter proper credentials");
		}	
	}
	public boolean validateLogin(String username, String password, ServletRequest req) {
		ServletContext context = req.getServletContext();
		String verUsername = (String)context.getInitParameter("username");
		String verPassword = (String)context.getInitParameter("password");
		return (username.equals(verUsername) && password.equals(verPassword));
	}
}
