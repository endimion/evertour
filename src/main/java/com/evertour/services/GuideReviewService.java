package com.evertour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DAO.GuideReviewDAO;
import com.evertour.model.DMO.GuideReviewTO;

@Service
@Transactional
public class GuideReviewService {

	@Autowired
	private GuideReviewDAO guideReviewDAO;
	
	public GuideReviewService(){
		System.out.println("GuideReviewService bean created!!!");
	}
	
	
	@Transactional
	public void printAllReviews(){
		List<GuideReviewTO> reviews = guideReviewDAO.getAllReviews();
		for(GuideReviewTO review : reviews){
			System.out.println("This is a review " + review.getID() + review.getRatingText());
		}
	}//end of printAllReviews
	
	
	
	
}//end of class
