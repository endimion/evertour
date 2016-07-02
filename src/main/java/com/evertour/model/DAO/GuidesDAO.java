package com.evertour.model.DAO;

import java.util.List;

import com.evertour.model.DMO.Guide;

public interface GuidesDAO {

	//return in a list all the guides of the APP
	public List<Guide> getAllGuides();
	
	//return in a list all the guides that offer the given
	// tourId
	public List<Guide> getGuidesForTour(int tourId);
	
	//return the guide with the given name
	public Guide getGuideByUserName(String userName);
	
	
	
	
	
}
