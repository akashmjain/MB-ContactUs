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
@WebFilter("/admin/contactus/requests")
public class LoginFilter implements Filter {
	public void destroy() {}
	
	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		PrintWriter out = res.getWriter();
		String username = req.getParameter("username") == null ? "" : req.getParameter("username");
		String password = req.getParameter("password") == null ? "" : req.getParameter("password");
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
		System.out.println(username);
		System.out.println(password);
		System.out.println("asdsada");
		return (username.equals(verUsername) && password.equals(verPassword));
	}
}

