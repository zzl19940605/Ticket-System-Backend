package com.example.SpringBoot.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.SpringBoot.beans.User;
import com.example.SpringBoot.daos.UserDao;
import com.example.SpringBoot.security.utils.SecurityUtil;

@Component
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private UserDao userDao;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User user = userDao.findByUsername(authentication.getName());
		
		SecurityUtil.sendAuthenticationSuccessResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null,user);
	}
	
}
