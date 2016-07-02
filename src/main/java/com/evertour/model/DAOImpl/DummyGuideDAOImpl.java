package com.evertour.model.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import com.evertour.model.DAO.GuidesDAO;
import com.evertour.model.DMO.GuideReviewTO;
import com.evertour.model.DMO.Guide;
import com.evertour.model.DMO.Tour;

public class DummyGuideDAOImpl implements GuidesDAO {

	private String name;
	private ArrayList<String> languages;
	private List<Tour> tours;
	private int ratingScore;
	private List<GuideReviewTO> ratingList;
	private String userName;
	private String password;
	private long id;
	
	/**
	 * makes a new Guide with the given name, user name and password
	 * and instantiates the list of ratings to an new ArrayList and
	 * the list of languages to a new ArrayList of Strings
	 * @param name
	 * @param userName
	 * @param password
	 * @param id, the unique id of the guide, this should be like the pkey
	 */
	public DummyGuideDAOImpl(String name, String userName, String password, long id){
		this.name = name;
		this.userName= userName;;
		this.password = password;
		this.ratingList = new ArrayList<GuideReviewTO>();
		this.languages = new ArrayList<String>();
		this.id = id;
	}//end of constructor
	
	
	


	@Override
	public List<Guide> getAllGuides() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Guide> getGuidesForTour(int tourId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Guide getGuideByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}//end of class
