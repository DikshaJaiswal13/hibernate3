package com.pack;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ven")
public class Vendor {

	@Id
	@Column(name="eid")
	private int vendorid;
	private String vname;
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Customer.class,cascade=CascadeType.ALL)//LAZY USED ONLY AT THE TIME OF COLLECTION,will load only this class
	@JoinColumn(name="venid",referencedColumnName="eid")
	private Set Customer;
	
	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public Set getCustomer() {
		return Customer;
	}

	public void setCustomer(Set customer) {
		Customer = customer;
	}

	
		
}
