package com.lucky.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lucky.entities.OrdersDo;
import com.lucky.util.MyUtil;

@Repository("OrderDao")
public class OrderDao extends BaseDao<OrdersDo> {

	@Override
	public OrdersDo importDto(OrdersDo dos, OrdersDo dto) {
		
		if(!MyUtil.isEmpty(dto.getOrderId()))
			dos.setOrderId(dto.getOrderId());
		if(!MyUtil.isEmpty(dto.getItems()))
			dos.setItems(dto.getItems());
		if(!MyUtil.isEmpty(dto.getUser()))
			dos.setUser(dto.getUser());
		/*if(!MyUtil.isEmpty(dto.getUpdatedAt()))
			dos.setUpdatedAt(new Date());*/
		
		return dos;
	}

	public List<OrdersDo> getUsersOrder(String emailId) {
		String hql = "Select o from OrdersDo o join o.user u where u.emailId = :emailId";
		Query q = getSession().createQuery(hql);
		q.setParameter("emailId", emailId);
		return (List<OrdersDo>) q.list();
	}

}