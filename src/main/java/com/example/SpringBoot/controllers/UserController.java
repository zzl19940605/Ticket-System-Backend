package com.example.SpringBoot.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.beans.User;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Value("${app.name}")
//	private String appName;
//	
//	@GetMapping("/foo/{x}")
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll() {
		return userService.getAll();
	}
	
	@PostMapping
	public Response Register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PutMapping
	public Response changePassword(@RequestBody User user, Authentication authentication) {
		return userService.changePassword(user, authentication);
	}
	
	@DeleteMapping
	public Response deleteUser(int id) {
		return userService.deleteUser(id);
	}
}
