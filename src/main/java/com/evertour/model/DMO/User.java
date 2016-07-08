package com.evertour.model.DMO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// defines the connection to the database table GUIDE 

@Entity
@Table(name = "USERS")
public class User {


	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id;
	
	@Column(name = "GNAME")
	private String name;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "TYPE_ID")
	private boolean type;
	
	@Column(name = "LAT")
	private double lat;
	
	@Column(name = "LNG")
	private double lng;
	
	
	@Column(name ="USERNAME")
	private String userName;
	
	@Column(name="PASS")
	private String password;
	
	
	public User(){	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public boolean isType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return lng;
	}


	public void setLng(double lng) {
		this.lng = lng;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



}//end of guide
