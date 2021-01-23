package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/contactus.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
		String fullName = request.getParameter("full_name") == null ? "" : request.getParameter("full_name");
		String email = request.getParameter("email") == null ? "" : request.getParameter("email");
		String comment = request.getParameter("comment") == null ? "" : request.getParameter("comment");
		PrintWriter out;
		
		try {
			if(validateContactInfo(fullName, email, comment)) {
				DatabaseHelper.saveContactInformation(fullName, email, comment);
				out = response.getWriter();
				out.println("data saved successfully");
			} else {
				out = response.getWriter(); 
				out.println("<p>Please Enter Valid Data</p>");
				System.out.println("inside else");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private boolean validateContactInfo(String fullName, String email, String comment) {
		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		final int CONTACT_MAX_FULL_NAME_SIZE = 0;
		final int CONTACT_MAX_COMMENT_SIZE = 10;
		return (VALID_EMAIL_ADDRESS_REGEX.matcher(email).find() && fullName.length() > CONTACT_MAX_FULL_NAME_SIZE && comment.length() > CONTACT_MAX_COMMENT_SIZE);	
	}
	
}
