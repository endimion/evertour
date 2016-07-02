package com.evertour.model.DAO;

import java.util.List;

import com.evertour.model.DMO.GuideReviewTO;

public interface GuideReviewDAO {
	
	//retrieves all the reviews in the system
	public List<GuideReviewTO> getAllReviews();

}//end of guideReviewDAO
