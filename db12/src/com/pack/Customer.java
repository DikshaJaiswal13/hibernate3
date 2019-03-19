package com.pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//one to many eg ,1 vendor,many customers
@Entity
@Table(name="cust")
public class Customer {
	@Id
	private int id;
	private String name;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

		
}