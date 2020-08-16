package com.example.SpringBoot.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.beans.Order;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.services.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private TeamEventTicketController ttc;
	@GetMapping
	public List<Order> findAll() {
		
		List<Order> ls = orderService.getAll();
		if (ls.size() != 0) Collections.sort(ls, (o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
		return ls;
		
	}
	
	@PostMapping
	public Response save(@RequestBody Order order) {
		
//		ttc.deleteSampleById(order.getTeamEventTicket().getId());
		return orderService.saveOrder(order);
	}
	
}
