package com.akashmjain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.akashmjain.db.DatabaseHelper;

@WebServlet("/admin/contactus/requests")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
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
