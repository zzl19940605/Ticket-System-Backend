package com.example.SpringBoot.services;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBoot.beans.Profile;
import com.example.SpringBoot.beans.User;
import com.example.SpringBoot.daos.UserDao;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.security.utils.SecurityUtil;

@Service

public class UserService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	public List<User> getAll(){
		return userDao.findAll();
	}
	
	
	
	public Response register(User user) {
		
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Profile> profiles = new ArrayList<Profile>();
			profiles.add(new Profile(2));
			user.setProfiles(profiles);
			userDao.save(user);
//			System.out.println(user.getId());
			return new Response(true,user.getId());
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			return new Response(false, 400, e.getMessage());
		}
	}
	
	public Response changePassword(User user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName())
				|| SecurityUtil.isAdmin(authentication.getAuthorities())) {
			User u = userDao.findByUsername(user.getUsername());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			userDao.save(u);
		}else {
			return new Response(false);
		}
		return new Response(true);
	}
	
	public Response deleteUser(int id) {
		if(userDao.findById(id)!= null) {
			userDao.deleteById (id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

