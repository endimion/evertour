package com.evertour.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evertour.model.DMO.TourCategoryTO;
import com.evertour.model.DMO.TourTO;
import com.evertour.services.GuideReviewService;
import com.evertour.services.TestTourService;
import com.evertour.services.impl.TourCategoryService;



@Controller
public class TourFinderController {

	//private ToursService tourService;
	
	@Autowired
	private GuideReviewService reviewService;
	
	@Autowired
	private TourCategoryService tourCategoryService;
	
	@Autowired
	private TestTourService testTourService;
	
	
	@Inject
	public TourFinderController(TestTourService tourService){
		System.out.println("tour finder controller bean created!");
		//this.testTourService = testTourService;
	}
	
	@RequestMapping(value="/find/tours/all", method = RequestMethod.GET)
	public @ResponseBody List<TourTO> getAllToursJSON(Map<String, Object> model){
		return testTourService.getAllTours();
	}//end of getAllToursJSON
	
	
	
	/**
	 * Method that adds a new Tour object to the db
	 * @return the view to redirect it to
	 */
	@RequestMapping(value="/add/tour/new",method=RequestMethod.POST)
	public void addTour(HttpServletRequest request, HttpServletResponse response, 
						  @RequestParam(value="tourName", required=false) String name,
						  @RequestParam(value="lat", required=true) String lat,
						  @RequestParam(value="lng", required=true) String lng,
						  @RequestParam(value="description", required= false) String description){
		
		TourTO tour = new TourTO();
		//tour.setName("this is a POST tour");
		//tour.setLat(37.878846); //37.978846, 23.763825
		//tour.setLon(23.763830);
		try{
			tour.setName(name);
			tour.setLat(Double.parseDouble(lat));
			tour.setLng(Double.parseDouble(lng));
			tour.setDescription(description);
			
			TourCategoryTO category = tourCategoryService.getAllCategories().get(0);
					
			tour.setCategory(category);
			//tour.setPicture("this should contain the url of the tour pict");
			System.out.println(tour.getLat() + " --- " + tour.getLng() + "\n" 
								+"description: " + tour.getDescription());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		this.testTourService.addTour(tour);
		System.out.println("addTour with post called");
		//return "testMapView";
		try{
			response.sendRedirect("/Evertour");
		}catch(Exception e){e.printStackTrace();}
	}//end of addTour


	/**
	 * Redirects us to the form to add a new tour
	 * takes as optional input the address (/add/tour/new/?address=some_address
	 * @return the view to redirect it to
	 */
	@RequestMapping(value="/add/tour/new/form",method=RequestMethod.POST)
	public String getAddTourView(@RequestParam(value="address", required=false) String address,
								 @RequestParam(value="lat", required=false) double lat,
								 @RequestParam(value="lng", required=false) double lng,
								Map<String, Object> model){
			
		System.out.println("got post req at /add/tour/new/form with params "+ 
							address + " " + lat + " " + lng);
		model.put("address", address);
		model.put("lat",lat);
		model.put("lng",lng);
		return "addTourView";
	}
	
	
	/**
	 	Takes as input the name of a Tour, adds it to the model
	 	and returns
	 	a view that displays that tour
	 * @return
	 */
	@RequestMapping(value="display/tour",method=RequestMethod.GET)
	public String displayTourInfoByName(@RequestParam(value="name") String name,
									Map<String, Object> model){
		TourTO t = testTourService.getTourByName(name);
		if(t != null){
			model.put("tour", t);
			return "displayTourView";
		}else{
			return "tourNotFoundView";
		}
	}//displayTourInfoByName
	
	

	/**
	 * 
	 * @param category a String representation of the id
	 * @return
	 */
	@RequestMapping(value="/filterToursByCategory", method=RequestMethod.GET)
	public @ResponseBody List<TourTO> getToursByCategory(@RequestParam(value="catId") String category){
		Integer cat = Integer.parseInt(category);
		return testTourService.getToursByCategory(cat);
	}//end of getToursByCategory
	
	
	
	
	@RequestMapping(value="testtest", method=RequestMethod.GET)
	public String testView(){
		reviewService.printAllReviews();
		tourCategoryService.printAllCategories();
		testTourService.printAllTours();
		return "touristMainMapView";
	}


	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void testTheTestView(Map<String, Object> model){
		testTourService.printAllTours();
	}


}//end of class
