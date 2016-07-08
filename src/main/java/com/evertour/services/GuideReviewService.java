package com.evertour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DAO.GuideReviewDAO;
import com.evertour.model.DMO.GuideReviewTO;
public interface GuideReviewService{
	
	public void printAllReviews();
	
}//end of class
