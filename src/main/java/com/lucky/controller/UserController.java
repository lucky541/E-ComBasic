package com.lucky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucky.dto.ResponseDto;
import com.lucky.entities.UserDo;
import com.lucky.services.UserServiceLocal;

@RestController
@CrossOrigin
@ComponentScan("com.lucky")
@RequestMapping(value="users", produces = "application/json")
public class UserController {
   
	@Autowired
	UserServiceLocal userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseDto create(@RequestBody UserDo dos){
		return userService.create(dos);
	}
	
	@RequestMapping(value="/{emailId}", method=RequestMethod.PUT)
	public ResponseDto update(@PathVariable String emailId,@RequestBody UserDo dos){
		return userService.update(dos);
	}
	
	@RequestMapping(value="/{emailId}", method=RequestMethod.GET)
	public ResponseDto findById(@PathVariable String emailId){
		UserDo dos = new UserDo();
		dos.setEmailId(emailId);
		return userService.getById(dos);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseDto findAll(){
		return userService.getAll();
	}
	
}
