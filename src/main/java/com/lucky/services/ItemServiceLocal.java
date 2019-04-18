package com.lucky.services;

import com.lucky.dto.ResponseDto;
import com.lucky.entities.ItemsDo;

public interface ItemServiceLocal {
  ResponseDto create(ItemsDo dos);
  ResponseDto update(ItemsDo dos);
  ResponseDto getById(ItemsDo dos);
  ResponseDto getAll();
}
