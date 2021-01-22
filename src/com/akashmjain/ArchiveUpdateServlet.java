package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateData")
public class ArchiveUpdateServlet extends HttpServlet {
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
		String contactId = request.getParameter("contact_id");
		PrintWriter	out = response.getWriter();
		updateArchiveStatus(contactId);
		response.sendRedirect("admin/contactus/requests");
	}
	private void updateArchiveStatus(String contactId) {
		String getEntry = "select * from contacts where id="+contactId+";";		
		
		Connection conn;
		try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getEntry);
            while (rs.next()) {
            	boolean isArchived = rs.getBoolean(CONTACT_IS_ARCHIVED);
            	String updateEntry = "update contacts set is_archived="+!isArchived+" where id="+contactId+";";
            	statement.executeUpdate(updateEntry);
			}
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
		
	}
}
