package com.example.SpringBoot.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot.beans.User;
import com.example.SpringBoot.beans.UserInfo;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	User findById(int userId);
	
}