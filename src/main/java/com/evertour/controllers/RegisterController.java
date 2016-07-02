package com.evertour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

	/**
	 * Redirects to the view that presents the registration form
	 * @return
	 */
	@RequestMapping(value={"/register"}, method=RequestMethod.GET)
	public String registerGuide(){
		return "guideRegister";
	}
	
	
	@RequestMapping(value={"/register"}, method=RequestMethod.POST)
	public @ResponseBody String receiveRegistrationInfo(){
		return "Thank your for registering";
	}
	
	
	
	
	
}
