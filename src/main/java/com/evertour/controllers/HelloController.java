package com.evertour.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evertour.services.TestTourService;
import com.evertour.services.impl.TourCategoryService;

@Controller
public class HelloController {

	@Autowired
	TourCategoryService tourCategoryService; 
	
	@Autowired
	TestTourService tourService;
	
	public HelloController(){
		System.out.println("HelloController created!!!");
	}
	
	/**
	 * Controller that maps to the initial view (i.e. starting view of the
	 * application)
	 * @param model
	 * @return
	 */
	@RequestMapping("/home")
	public String showTestMapPage(Map<String, Object> model){
		
		//add to the model, a list containing all the tour categories
		// of our application
		model.put("tourCategories", tourCategoryService.getAllCategories());
		model.put("allTours", tourService.getAllTours());
		return "touristMainMapView";
	}
	
	
	
	
	
}//end of HelloController
