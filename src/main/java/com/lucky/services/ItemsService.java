package com.lucky.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucky.dao.ItemsDao;
import com.lucky.dto.ResponseDto;
import com.lucky.entities.ItemsDo;
import com.lucky.util.MyUtil;

@Service("ItemsService")
@Transactional
public class ItemsService implements ItemServiceLocal {

	@Autowired
	ItemsDao itemDao;

	@Override
	public ResponseDto create(ItemsDo dos) {
		try {

			dos.setItemId(MyUtil.getUUID());
            Date date = new Date();
            /*dos.setCreatedAt(date);
            dos.setUpdatedAt(date);*/
			itemDao.persist(dos);
			return new ResponseDto(dos, "Success : " + dos.getItemId());
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto update(ItemsDo dos) {
		try {
			 itemDao.update(dos);
			return new ResponseDto(dos, "Success : " + dos.getItemId());
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getById(ItemsDo dos) {
		try {
			dos = itemDao.find(dos);
			return new ResponseDto(dos, "Success : " + dos.getItemId());
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getAll() {
		try {
			return new ResponseDto(itemDao.findAll(new ItemsDo()), "Success" );
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

}
