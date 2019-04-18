package com.lucky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucky.dto.OrderVo;
import com.lucky.dto.ResponseDto;
import com.lucky.entities.ItemsDo;
import com.lucky.entities.OrdersDo;
import com.lucky.services.ItemServiceLocal;
import com.lucky.services.OrderServiceLocal;

@RestController
@CrossOrigin
@ComponentScan("com.lucky")
@RequestMapping(value="orders", produces = "application/json")
public class OrderController {
   
	@Autowired
	OrderServiceLocal orderService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseDto create(@RequestBody OrderVo dos){
		return orderService.create(dos);
	}
	
	@RequestMapping(value="/{orderId}", method=RequestMethod.PUT)
	public ResponseDto update(@PathVariable String orderId,@RequestBody OrdersDo dos){
		dos.setOrderId(orderId);
		return orderService.update(dos);
	}
	
	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
	public ResponseDto findById(@PathVariable String orderId){
		OrdersDo dos = new OrdersDo();
		dos.setOrderId(orderId);
		return orderService.getById(dos);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseDto findAll(){
		return orderService.getAll();
	}
	
	@RequestMapping(value="/{emailId}", method=RequestMethod.GET)
	public ResponseDto getUsersOrder(@PathVariable String emailId){
		return orderService.getUsersOrder(emailId);
	}
}
