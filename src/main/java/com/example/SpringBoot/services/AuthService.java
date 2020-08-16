package com.example.SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.daos.UserDao;
import com.example.SpringBoot.http.AuthenticationSuccessResponse;
import com.example.SpringBoot.http.Response;

@Service
public class AuthService {
	
	@Autowired
	UserDao userDao;

	public Response checklogin(Authentication authentication) {
		if(authentication != null) {
			Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", userDao.findByUsername(authentication.getName()));
			return response;
		}else {
			return new Response(false);
		}
	}
}
