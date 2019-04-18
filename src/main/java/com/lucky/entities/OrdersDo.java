package com.lucky.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "OrdersDo")
public class OrdersDo implements BaseDo, Comparable<OrdersDo>{
   
	@Id
	String orderId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<ItemsDo> items = new HashSet<ItemsDo>();
	Long quantity;
	
	@OneToOne
	UserDo user = new UserDo();
	
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;*/
	
	public String getPrimaryKey() {
		return orderId;
	}

	public int compareTo(OrdersDo o) {
		return this.orderId.compareTo(o.orderId);
	}
	
	
	
}
