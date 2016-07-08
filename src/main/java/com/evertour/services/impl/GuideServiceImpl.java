package com.evertour.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DAO.GuidesDAO;
import com.evertour.model.DMO.Guide;
import com.evertour.services.GuideService;

@Service
@Transactional
public class GuideServiceImpl implements GuideService {
	
	@Autowired
	GuidesDAO guideDAO;
	
	
	@Override
	public Integer registerNewGuide(Guide guide) {
		if(guideDAO.getGuideByUserName(guide.getName()) != null) return -1;
		guideDAO.registerGuide(guide);
		return 0;
	}


	@Override
	public Guide getGuideByUserName(String userName) {
		return  guideDAO.getGuideByUserName(userName);
	}

	
	
	
	
}//end of class
