package com.evertour.model.DAO;

import java.util.List;

import com.evertour.model.DMO.TourTO;

public interface TestTourDAO {

	
	public List<TourTO> getAllTours();
	public List<TourTO> getAllToursByCategory(int typeId);
	public void addTour(TourTO tour);

	public TourTO getTourByName(String name);
	public TourTO getTourById(Integer id);
}
