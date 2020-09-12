package com.safra.safrat6.model;

import java.util.Date;

public class Invite {
	private long userId;
	private Date dateInvite;
	private long email;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getDateInvite() {
		return dateInvite;
	}
	public void setDateInvite(Date dateInvite) {
		this.dateInvite = dateInvite;
	}
	public long getEmail() {
		return email;
	}
	public void setEmail(long email) {
		this.email = email;
	}
	
	
}
