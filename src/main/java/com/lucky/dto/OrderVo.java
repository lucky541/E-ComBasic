package com.lucky.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVo {
   
	List<ItemVo> items;
	String email;
}

