package com.lucky.dao;

import org.springframework.stereotype.Repository;

import com.lucky.entities.UserDo;
import com.lucky.util.MyUtil;

@Repository("UserDao")
public class UserDao extends BaseDao<UserDo>{

	@Override
	public UserDo importDto(UserDo dos, UserDo dto) {
		
		if(!MyUtil.isEmpty(dto.getEmailId()))
			dos.setEmailId(dto.getEmailId());
		if(!MyUtil.isEmpty(dto.getName()))
			dos.setName(dto.getName());
		if(!MyUtil.isEmpty(dto.getLocation()))
			dos.setLocation(dto.getLocation());
		
		return dos;
	}

}
