package com.evertour.services;

import com.evertour.model.DMO.Guide;

public interface GuideService {

	/**
	 * Registers the given guide to the database if he does not exist
	 * @param guide
	 * @return -1 if the guide already exists
	 */
	public Integer registerNewGuide(Guide guide);
	
	
	/**
	 * 
	 * @param userName the user name of the  guide
	 * @return the Guide object with that user name, else null if none is found
	 */
	public Guide getGuideByUserName(String userName);
	
	

	
}
