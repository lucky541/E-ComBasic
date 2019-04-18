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
import com.lucky.entities.ItemsDo;
import com.lucky.services.ItemServiceLocal;

@RestController
@CrossOrigin
@ComponentScan("com.lucky")
@RequestMapping(value="items", produces = "application/json")
public class ItemsController {
   
	@Autowired
	ItemServiceLocal itemService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseDto create(@RequestBody ItemsDo dos){
		return itemService.create(dos);
	}
	
	@RequestMapping(value="/{itemId}",method=RequestMethod.PUT)
	public ResponseDto update(@PathVariable String itemId,@RequestBody ItemsDo dos){
		dos.setItemId(itemId);
		return itemService.update(dos);
	}
	
	@RequestMapping(value="/{itemId}", method=RequestMethod.GET)
	public ResponseDto findById(@PathVariable String itemId){
		ItemsDo dos = new ItemsDo();
		dos.setItemId(itemId);
		return itemService.getById(dos);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseDto findAll(){
		return itemService.getAll();
	}
}
