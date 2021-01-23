package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus/save")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("full_name");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		PrintWriter out = response.getWriter();
		DatabaseHelper.saveContactInformation(fullName, email, comment);
		out = response.getWriter();
		out.println("data saved successfully");		
	}


}
