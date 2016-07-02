package com.evertour.services;

import java.util.List;

import com.evertour.model.DMO.TourTO;


public interface TestTourService {

	
	public void addTour(TourTO tour);
	
	public List<TourTO> getToursByCategory(int categoryId);
	
	public List<TourTO> getAllTours();
	
	public void printAllTours();
	
	public TourTO getTourByName(String name);
	
	
}
