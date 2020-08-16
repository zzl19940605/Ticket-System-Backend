package com.example.SpringBoot.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot.beans.Order;


public interface OrderDao extends JpaRepository<Order, Integer>{
	
}
