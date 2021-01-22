package com.akashmjain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDataServlet
 */
@WebServlet("/admin/contactus/requests")
public class DashboardServlet extends HttpServlet {
	private static final String CONTACT_ID = "id";
	private static final String CONTACT_FULL_NAME = "name";
	private static final String CONTACT_EMAIL = "email";
	private static final String CONTACT_COMMENT = "message";
	private static final String CONTACT_IS_ARCHIVED = "is_archived";
	
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/contact_us";
	private static final String DB_USER_NAME = "postgres";
	private static final String DB_USER_PASSWORD = "password";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contact> contactList = getContacts();
		String dashboardURL = "/dashboard.jsp";
		request.setAttribute("contacts", contactList);
		RequestDispatcher rd = request.getRequestDispatcher(dashboardURL);
		rd.forward(request, response);
	}
	private List<Contact> getContacts() {
		String query = "select * from contacts;";
		List<Contact> contactList = new ArrayList<>();
		
		Connection conn;
		try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
            	Contact contact = new Contact();
            	contact.setContactId(rs.getString(CONTACT_ID));
            	contact.setFullName(rs.getString(CONTACT_FULL_NAME));
            	contact.setEmail(rs.getString(CONTACT_EMAIL));
            	contact.setComment(rs.getString(CONTACT_COMMENT));
            	contact.setIsArchived(rs.getBoolean(CONTACT_IS_ARCHIVED));
            	contactList.add(contact);
            }
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
		return contactList;
	}
}