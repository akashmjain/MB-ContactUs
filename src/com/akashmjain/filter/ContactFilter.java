package com.akashmjain.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/contactus/save")
public class ContactFilter implements Filter {
	@Override
	public void destroy() {}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String fullName = request.getParameter("full_name");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		if(validateContactInfo(fullName, email, comment)) {
			chain.doFilter(request, response);	
		} else {
			out.println("Please Enter valid Data");
		}
	}
	
	private boolean validateContactInfo(String fullName, String email, String comment) {
		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		final int CONTACT_MAX_FULL_NAME_SIZE = 0;
		final int CONTACT_MAX_COMMENT_SIZE = 10;
		return (VALID_EMAIL_ADDRESS_REGEX.matcher(email).find() && fullName.length() > CONTACT_MAX_FULL_NAME_SIZE && comment.length() > CONTACT_MAX_COMMENT_SIZE);	
	}
}

