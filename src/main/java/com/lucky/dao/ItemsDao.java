package com.lucky.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.lucky.entities.ItemsDo;
import com.lucky.util.MyUtil;

@Repository("ItemsDao")
public class ItemsDao extends BaseDao<ItemsDo>{

	@Override
	public ItemsDo importDto(ItemsDo dos, ItemsDo dto) {
		
		if(!MyUtil.isEmpty(dto.getItemId()))
			dos.setItemId(dto.getItemId());
		if(!MyUtil.isEmpty(dto.getCategory()))
			dos.setCategory(dto.getCategory());
		if(!MyUtil.isEmpty(dto.getName()))
			dos.setName(dto.getName());
		if(!MyUtil.isEmpty(dto.getAvailQty()))
			dos.setAvailQty(dto.getAvailQty());
		/*if(!MyUtil.isEmpty(dto.getUpdatedAt()))
			dos.setUpdatedAt(new Date());*/
		
		return dos;
	}
       
}
