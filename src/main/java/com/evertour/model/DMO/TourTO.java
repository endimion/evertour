package com.evertour.model.DMO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "TOURS")
public class TourTO {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "TNAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="LNG")
	private double lng;
	@Column(name="LAT")
	private double lat;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID", nullable = false)
	private TourCategoryTO category;

	// **********************************
	//*************IMPORTANT*************
	//***********************************
	// Tours are in a many to many relation with GUIDES
	// SO HERE WE CAN SIMPLY CREATE A NEW "COLUMN" that will allow us
	// TO HANDLE THIS
	
	//ALSO, because we use lazy loading so as not to retrieve the whole db graph, 
	//we have to remember in the DAO to initialize the getGuides!!!
	@ManyToMany(fetch = FetchType.LAZY) 
    @JoinTable(name = "GUIDES_TOURS", //this is the junction table 
             joinColumns = { @JoinColumn(name = "TOUR_ID") },  
             inverseJoinColumns = { @JoinColumn(name = "GUIDE_ID") })
    private Set<Guide> guides = new HashSet<Guide>();
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public TourCategoryTO getCategory() {
		return category;
	}

	public void setCategory(TourCategoryTO category) {
		this.category = category;
	}

	public Set<Guide> getGuides() {
		return guides;
	}

	public void setGuides(Set<Guide> guides) {
		this.guides = guides;
	}
	
	

}//end of class
