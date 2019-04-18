package com.lucky.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ItemsDo")
public class ItemsDo implements  BaseDo, Comparable<ItemsDo>{
    
	@Id
    String itemId;
    
	String name;
    String category;
    Long availQty;
    
	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;*/
    
    
	public String getPrimaryKey() {
		return itemId;
	}
    
	public int compareTo(ItemsDo o) {
		return this.itemId.compareTo(o.itemId);
	}
}
