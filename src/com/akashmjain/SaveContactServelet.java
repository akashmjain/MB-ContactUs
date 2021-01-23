package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus/save")
public class SaveContactServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("full_name");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		PrintWriter out = response.getWriter();
		out = response.getWriter();
		if(DatabaseHelper.saveContactInformation(fullName, email, comment)) {
			out.println("data saved successfully");
		}
		else {
			out.println("Internal Error Occured please try again after some time");
		}
		

	}
}
