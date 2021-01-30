package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.akashmjain.beans.Contact;

/**
 * Servlet implementation class ShowDataServlet
 */
@WebServlet("/admin/contactus/requests")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username") != null) {
			request.setAttribute("archivedContacts", DatabaseHelper.getArchivedContacts());
			request.setAttribute("unArchivedContacts", DatabaseHelper.getUnArchivedContacts());
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
		} else {
			response.getWriter().println("Please Login First");
		}
	}
}
