package com.lucky.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lucky.entities.BaseDo;
import com.lucky.util.MyUtil;

@Repository("BaseDao")
public abstract class BaseDao<E extends BaseDo> {
    
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// Persist
	public void persist(E entity) {
		getSession().saveOrUpdate(entity);
	}

	// Update
	public void update(E entity) {
		E dos = find(entity);
		dos = importDto(dos,entity);
		getSession().merge(dos);
	}
	
	public E find(E pojo) {
		E result = null;
		result = (E) getSession().get(pojo.getClass(), (Serializable) pojo.getPrimaryKey());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll(E dto) throws Exception {
		
		Criteria criteria = getSession().createCriteria(dto.getClass());
		//criteria.addOrder(Order.desc("createdAt"));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<E> listDo = (List<E>) criteria.list();
		return listDo;
	}
	
	public abstract E importDto(E dos, E dto);
}
