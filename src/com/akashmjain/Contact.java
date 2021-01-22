package com.akashmjain;

import java.io.Serializable;

public class Contact implements Serializable {
	private String contactId;
	private String fullName;
	private String email;
	private String comment;
	private boolean isArchived;
	
	public Contact() {
		this.contactId = "";
		this.fullName = "";
		this.email = "";
		this.comment = "";
		this.isArchived = false;
	}
	public Contact(String contactId, String fullName, String email, String comment) {
		this.contactId = contactId;
		this.fullName = fullName;
		this.email = email;
		this.comment = comment;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean getIsArchived() {
		return isArchived;
	} 
	public void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", email=" + email + ", comment="
				+ comment + ", isArchived=" + isArchived + "]";
	}
	
}
