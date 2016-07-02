package com.evertour.model.DMO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// defines the connection to the database table GUIDE 

@Entity
@Table(name = "GUIDES")
public class Guide {


	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
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
	
	@Column(name = "PICTURE")
	private String picture;
	
	
	public Guide(){	}


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


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}



}//end of guide
