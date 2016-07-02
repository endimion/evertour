package com.evertour.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.evertour.model.DMO.Tour;



@Service
public class TourServiceImpl implements ToursService{

	ArrayList<Tour> tours = new ArrayList<Tour>();
	
	public TourServiceImpl(){
		System.out.println("TestTourSerivceImpl bean created!");
		Tour t1 = new Tour();
		t1.setName("tour 1");
		t1.setLat(37.978846); //37.978846, 23.763825 37.978846, 23.763825
		t1.setLon(23.763825);
		Tour t2 = new Tour();
		t2.setName("tour 2");
		t2.setLat(37.878846); //37.978846, 23.763825
		t2.setLon(23.753825);
		Tour t3 = new Tour();
		t3.setName("tour 3");
		t3.setLat(37.878846); //37.978846, 23.763825
		t3.setLon(23.763830);
		tours.add(t1);
		tours.add(t2);
		tours.add(t3);
	}
	
	// mock up implementation that returns a set of tours
	public List<Tour> getAllTours(){
		return tours;
	}


	public void addTour(Tour tour){
		tours.add(tour);
	}

	
	@Override
	public Tour getTourByName(String name) {
		for(Tour tour : tours){
			if(tour.getName().equals(name)){
				return tour;
			}
		}
		return null;
	}//end of getTourByName
	
	
	
	
}
