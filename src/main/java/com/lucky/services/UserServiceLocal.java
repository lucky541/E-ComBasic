package com.lucky.services;

import com.lucky.dto.ResponseDto;
import com.lucky.entities.UserDo;

public interface UserServiceLocal {
  
	  ResponseDto create(UserDo dos);
	  ResponseDto update(UserDo dos);
	  ResponseDto getById(UserDo dos);
	  ResponseDto getAll();
}
