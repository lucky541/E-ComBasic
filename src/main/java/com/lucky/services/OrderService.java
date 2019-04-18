package com.lucky.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucky.dao.ItemsDao;
import com.lucky.dao.OrderDao;
import com.lucky.dao.UserDao;
import com.lucky.dto.ItemVo;
import com.lucky.dto.OrderVo;
import com.lucky.dto.ResponseDto;
import com.lucky.entities.ItemsDo;
import com.lucky.entities.OrdersDo;
import com.lucky.entities.UserDo;
import com.lucky.util.MyUtil;


@Service("OrderService")
@Transactional
public class OrderService implements OrderServiceLocal {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ItemsDao itemDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public ResponseDto create(OrderVo dto) {
		try {
			OrdersDo dos = new OrdersDo();
			
			if(MyUtil.isEmpty(dto.getItems()))
				throw new Exception("No item is selected");
			
			UserDo user = new UserDo();
			user.setEmailId(dto.getEmail());
			 user = userDao.find(user);
	            if(MyUtil.isEmpty(user))
	            	throw new Exception("User does not exist with email id "+dto.getEmail());
			
			dos.setOrderId(MyUtil.getUUID());

			Date date = new Date();
			/*dos.setCreatedAt(date);
			dos.setUpdatedAt(date);
			*/
			
			
			for(ItemVo itemVo : dto.getItems())
			{
				ItemsDo itemDo = new ItemsDo();
				itemDo.setItemId(itemVo.getItemId());
				itemDo = itemDao.find(itemDo);
				if(MyUtil.isEmpty(itemDo)) throw new Exception("No item is exist with id "+itemVo.getItemId());
				if(itemDo.getAvailQty()<itemVo.getQuantity()) throw new Exception("Only  "+itemDo.getAvailQty()+" is available.");
				
				itemDo.setAvailQty(itemDo.getAvailQty()-itemVo.getQuantity());
				//itemDo.setUpdatedAt(new Date());
				
				dos.getItems().add(itemDo);
			}
			
			dos.setUser(user);
			
			orderDao.persist(dos);
			
			return new ResponseDto(dos, "Success : " + dos.getOrderId());
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto update(OrdersDo dto) {
		try {
			orderDao.update(dto);
            return new ResponseDto( dto,"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getById(OrdersDo dto) {
		try {
            return new ResponseDto( orderDao.find(dto),"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getAll() {
		try {
            return new ResponseDto( orderDao.findAll(new OrdersDo()),"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getUsersOrder(String emailId) {
		try {
            return new ResponseDto( orderDao.getUsersOrder(emailId),"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

}
