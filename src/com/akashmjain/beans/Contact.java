package com.akashmjain.beans;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final String ARCHIVE_SET = "ARCHIVE";
	private static final String ARCHIVE_UNSET = "UN-ARCHIVE";
	private String contactId;
	private String fullName;
	private String email;
	private String comment;
	private boolean isArchived;
	private String archiveButtonText;
	
	public Contact() {
		this.contactId = "";
		this.fullName = "";
		this.email = "";
		this.comment = "";
		this.isArchived = false;
		this.archiveButtonText = "ARCHIVE";
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
		this.archiveButtonText = isArchived ?  ARCHIVE_UNSET : ARCHIVE_SET;
		this.isArchived = isArchived;
	}
	public String getArchiveButtonText() {
		return this.archiveButtonText;
	} 
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", email=" + email + ", comment="
				+ comment + ", isArchived=" + isArchived + "]";
	}
	
}
