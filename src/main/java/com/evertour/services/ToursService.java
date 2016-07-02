package com.evertour.services;

import java.util.List;

import com.evertour.model.DMO.Tour;

public interface ToursService {

	public List<Tour> getAllTours();
	public void addTour(Tour tour);

	public Tour getTourByName(String name);
	
	
	
}
