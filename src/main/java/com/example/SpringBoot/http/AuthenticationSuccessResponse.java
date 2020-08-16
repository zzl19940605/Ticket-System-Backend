package com.example.SpringBoot.http;

import com.example.SpringBoot.beans.User;

public class AuthenticationSuccessResponse extends Response{
	
	private Object user;
	
	public AuthenticationSuccessResponse(boolean success, int code, String message, Object user) {
		super (success, code, message);
		this.user = user;
	}
	
	public Object getUser() {
		return user;
	}
	
	public void setUser(Object user) {
		this.user = user;
	}
}
