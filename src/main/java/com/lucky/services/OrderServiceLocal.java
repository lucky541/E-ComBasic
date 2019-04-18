package com.lucky.services;

import com.lucky.dto.OrderVo;
import com.lucky.dto.ResponseDto;
import com.lucky.entities.OrdersDo;

public interface OrderServiceLocal {
   
	ResponseDto create(OrderVo dto);
	
	ResponseDto update(OrdersDo dto);
	
	ResponseDto getById(OrdersDo dto);
	
	ResponseDto getAll();

	ResponseDto getUsersOrder(String emailId);
}
