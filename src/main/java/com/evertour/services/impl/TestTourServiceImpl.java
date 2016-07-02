package com.evertour.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DAO.TestTourDAO;
import com.evertour.model.DMO.TourTO;
import com.evertour.services.TestTourService;



@Service
@Transactional
public class TestTourServiceImpl  implements TestTourService{
	
	@Autowired
	private TestTourDAO tourDAO;
	
	public TestTourServiceImpl(){
		System.out.println("----- TestTourSERVICE bean created!!!");
	}
	
	@Override
	@Transactional
	public void printAllTours(){
		List<TourTO> tours = tourDAO.getAllTours();
		for(TourTO tour : tours){
			System.out.println("This is a TOUR " + tour.getId() + tour.getName() + " "+ tour.getCategory().getName());
		}
	}//end of printAllReviews
	
	@Override
	@Transactional
	public List<TourTO> getAllTours(){
		return this.tourDAO.getAllTours();
	}
	
	
	@Override
	@Transactional
	public List<TourTO> getToursByCategory(int categoryId){
		return tourDAO.getAllToursByCategory(categoryId);
	}//end of getToursByCategory
	
	@Override
	@Transactional
	public void addTour(TourTO tour){
		tourDAO.addTour(tour);
	}//end of addTour

	
	@Transactional
	@Override
	public TourTO getTourByName(String name) {
		return tourDAO.getTourByName(name);
	}
	
	
}//end of class
