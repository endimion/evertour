package com.evertour.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DAO.TourCategoryDAO;
import com.evertour.model.DMO.TourCategoryTO;


@Service
@Transactional
public class TourCategoryService {

	@Autowired
	private TourCategoryDAO tourCategoryDAO;
	
	public TourCategoryService(){
		System.out.println("TourCategoryService bean created!!!");
	}
	
	@Transactional
	public void printAllCategories(){
		List<TourCategoryTO> categories = tourCategoryDAO.getAllCategories();
		for(TourCategoryTO category : categories){
			System.out.println("This is a category " + category.getName());
		}
	}//end of printAllReviews
	

	@Transactional
	public List<TourCategoryTO> getAllCategories(){
		return tourCategoryDAO.getAllCategories();
	}//end of getAllCategories
	
	
}
