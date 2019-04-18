package com.lucky.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucky.dao.UserDao;
import com.lucky.dto.ResponseDto;
import com.lucky.entities.UserDo;
import com.lucky.util.MyUtil;

@Service("UserService")
@Transactional
public class UserService implements UserServiceLocal{
  
	@Autowired
	UserDao userDao;
	
	@Override
	public ResponseDto create(UserDo dos) {
		try {
            UserDo temp = userDao.find(dos);
            if(!MyUtil.isEmpty(temp))
            	throw new Exception("User already exist with email id "+dos.getEmailId());
            
           /* Date date  = new Date();
            dos.setCreatedAt(date);
            dos.setUpdatedAt(date);*/
            
            userDao.persist(dos);
            return new ResponseDto(dos,"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto update(UserDo dos) {
		try {
            UserDo temp = userDao.find(dos);
            if(!MyUtil.isEmpty(temp))
            	throw new Exception("User already exist with email id "+dos.getEmailId());
            userDao.update(dos);
            return new ResponseDto(dos,"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getById(UserDo dos) {
		try {
            return new ResponseDto(userDao.find(dos),"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

	@Override
	public ResponseDto getAll() {
		try {
              return new ResponseDto(userDao.findAll(new UserDo()),"Success");
		} catch (Exception e) {
			return new ResponseDto("NA", "Failed : " + e.getMessage());
		}
	}

}
