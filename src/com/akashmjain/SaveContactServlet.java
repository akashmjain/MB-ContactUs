package com.akashmjain;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/contactus/save")
public class SaveContactServlet extends HttpServlet {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final int CONTACT_MAX_FULL_NAME_SIZE = 0;
	public static final int CONTACT_MAX_COMMENT_SIZE = 10;
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/contact_us";
	private static final String DB_USER_NAME = "postgres";
	private static final String DB_USER_PASSWORD = "password";
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("full_name");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		PrintWriter out = response.getWriter();
		try {
			if(	VALID_EMAIL_ADDRESS_REGEX.matcher(email).find() && 
				fullName.length() > CONTACT_MAX_FULL_NAME_SIZE && 
				comment.length() > CONTACT_MAX_COMMENT_SIZE) {
				saveData(fullName, email, comment);
				out.println("data saved successfully");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("error", "Please Enter valid Data");
				response.sendRedirect("/ContactUs/contactus");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	private void saveData(String fullName, String email, String comment) {
		String query = "insert into contacts(name, email, message, is_archived) values "
				+ "('"+fullName+"','"+email+"', '"+comment+"', false);";
		Connection conn;
		try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASSWORD);
            Statement statement = conn.createStatement();
            int code = statement.executeUpdate(query);
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
	}
	
}
