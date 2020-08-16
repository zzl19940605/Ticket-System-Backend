package com.example.SpringBoot.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.SpringBoot.beans.UserInfo;


public interface UserInfoDao extends JpaRepository<UserInfo, Integer>{
	
}
