package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akashmjain.beans.Contact;

@WebServlet("/contactus/save")
// change spelling 
public class SaveContactServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact contact = new Contact();
		contact.setFullName(request.getParameter("full_name"));
		contact.setEmail(request.getParameter("email"));
		contact.setComment(request.getParameter("comment"));
		contact.setIsArchived(false);
		// after if space is required
		if (DatabaseHelper.saveContactInformation(contact)) {
			response.getWriter().println("data saved successfully");
		} else {
			response.getWriter().println("Internal Error Occured please try again after some time");
		}
	}
}
