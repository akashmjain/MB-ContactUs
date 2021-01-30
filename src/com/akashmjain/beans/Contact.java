package com.akashmjain.beans;



public class Contact {
	// @TODO delete all archiveButtonText code
	private String contactId;
	private String fullName;
	private String email;
	private String comment;
	private boolean isArchived;
	
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
