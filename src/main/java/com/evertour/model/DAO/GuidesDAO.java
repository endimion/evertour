package com.evertour.model.DAO;

import java.util.List;

import com.evertour.model.DMO.Guide;

public interface GuidesDAO {

	//return in a list all the guides of the APP
	public List<Guide> getAllGuides();
	
	//return the guide with the given name
	public Guide getGuideByUserName(String userName);
	
		
	
	/**
	 * 
	 * @param guide, a new guide for the system is being registered
	 */
	public void registerGuide(Guide guide);
	
	
}
