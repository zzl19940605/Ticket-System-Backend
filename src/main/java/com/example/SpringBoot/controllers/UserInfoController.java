package com.example.SpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.beans.User;
import com.example.SpringBoot.beans.UserInfo;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.services.UserInfoService;



@RestController
@RequestMapping("/user-details")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping
	public List<UserInfo> findAll() {
		return userInfoService.getAll();
	}

	@PostMapping
	public Response postUserDetails(@RequestBody UserInfo userInfo) {
//		System.out.println(userInfo.getZip());
		return userInfoService.addUserInfo(userInfo);
	}
	
	@PutMapping
	public Response putUserInfos(@RequestBody UserInfo userInfo) {
		return userInfoService.updateUserInfo(userInfo);
	}
	
}

