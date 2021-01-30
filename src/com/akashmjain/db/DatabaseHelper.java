package com.akashmjain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.akashmjain.beans.Contact;

public class DatabaseHelper {
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/contact_us";
	private static final String DB_USER_NAME = "postgres";
	private static final String DB_USER_PASSWORD = "password";
	private static final String CONTACT_TABLE_NAME = "contacts_with_timestamp";
	private static final String CONTACT_ID = "id";
	private static final String CONTACT_FULL_NAME = "name";
	private static final String CONTACT_EMAIL = "email";
	private static final String CONTACT_COMMENT = "message";
	private static final String CONTACT_IS_ARCHIVED = "is_archived";
	private static final String CONTACT_CREATED_AT = "created_at";

	
	public static List<Contact> getContacts() {
		String query = "select * from "+CONTACT_TABLE_NAME+";";
		List<Contact> contacts = getContactsGivenQuery(query);
		return contacts;
	}
	
	public static List<Contact> getArchivedContacts() {
		String query = "select * from "+CONTACT_TABLE_NAME+" where is_archived = true;";
		List<Contact> contacts = getContactsGivenQuery(query);
        contacts.sort((c1, c2) -> (c2.getTimestamp()).compareTo(c1.getTimestamp()));
		return contacts;
	}
	
	public static List<Contact> getUnArchivedContacts() {
		String query = "select * from "+CONTACT_TABLE_NAME+" where is_archived = false;";
		List<Contact> contacts = getContactsGivenQuery(query);
		contacts.sort((c1, c2) -> (c2.getTimestamp()).compareTo(c1.getTimestamp()));
		return contacts;
	}
	
	private static List<Contact> getContactsGivenQuery(String query) {
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
            	contact.setTimestamp(rs.getTimestamp(CONTACT_CREATED_AT));
            	contactList.add(contact);
            }
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
		
		contactList.sort(new Comparator<Contact>() {
			@Override
			public int compare(Contact c1, Contact c2) {
				return c1.getContactId().compareTo(c2.getContactId());
			}
		});
		return contactList;
	}
	
	public static void updateArchiveStatus(String contactId) {
		String getEntry = "select * from "+CONTACT_TABLE_NAME+" where id="+contactId+";";		
		Connection conn;
		try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getEntry);
            while (rs.next()) {
            	boolean isArchived = rs.getBoolean(CONTACT_IS_ARCHIVED);
            	String updateEntry = "update "+CONTACT_TABLE_NAME+" set is_archived="+!isArchived+" where id="+contactId+";";
            	statement.executeUpdate(updateEntry);
			}
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }	
	}
	
	public static boolean saveContactInformation(Contact contact) {
		String query = "insert into "+CONTACT_TABLE_NAME+"(name, email, message, is_archived) values "
				+ "('"+contact.getFullName()+"','"+contact.getEmail()+"', '"+contact.getComment() +"', '"+contact.getIsArchived()+"');";
		Connection conn;
		try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASSWORD);
            Statement statement = conn.createStatement();
            int code = statement.executeUpdate(query);
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
	}

}

