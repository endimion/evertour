package com.evertour.model.DMO;

import java.util.ArrayList;
import java.util.List;

public class Tour {

	private double lon;
	private double lat;
	private String name;
	private String description;
	private String picture;
	private List<Guide> guides; 
	private  int id;
	



	public Tour(){
		guides = new ArrayList<Guide>();
	}

	
	public List<Guide> getGuides() {
		return guides;
	}

	public void setGuides(List<Guide> guides) {
		this.guides = guides;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
