package com.example.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.beans.Order;
import com.example.SpringBoot.daos.OrderDao;
import com.example.SpringBoot.http.Response;
@Service
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	public List<Order> getAll(){
		return orderDao.findAll();
	}
	
	public Response saveOrder(Order order) {
		try {
			orderDao.save(order);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false, 400, e.getMessage());
		}
	}
}
