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
@Table(name="UserDo")
public class UserDo implements BaseDo{
   
	@Id
	String emailId;
	String name;
	String location;
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;*/
	
	public String getPrimaryKey() {
		return emailId;
	}

}
