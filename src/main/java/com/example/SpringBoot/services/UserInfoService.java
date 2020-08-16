package com.example.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.beans.User;
import com.example.SpringBoot.beans.UserInfo;
import com.example.SpringBoot.daos.UserDao;
import com.example.SpringBoot.daos.UserInfoDao;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.http.UserInfoResponse;

@Service
public class UserInfoService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	public List<UserInfo> getAll(){
		return userInfoDao.findAll();
	}
	
//	public Response addUserInfo(UserInfo userInfo, Authentication authentication) {
//		User user = userDao.findByUsername(authentication.getName());
//		System.out.println("asdffgh");
//		System.out.println(userInfo);
//		
//		userInfo.setUser(user);
//		return new UserInfoResponse(true, userInfoDao.save(userInfo));	
//	}
//
	public Response addUserInfo(UserInfo userInfo) {
//		User user = userDao.findById(userInfo.getUid());
		//get userId and save it in another column
		User user = userDao.findById(Integer.parseInt(userInfo.getZip()));		
		userInfo.setUser(user);
		return new UserInfoResponse(true, userInfoDao.save(userInfo));	
	}
	
	public Response updateUserInfo(UserInfo userInfo) {
		UserInfo ud = userInfoDao.findById(userInfo.getId()).get();
		userInfo.setUser(ud.getUser());
		ud= userInfo;
		userInfoDao.save(ud);
		return new Response(true);
	}
}
