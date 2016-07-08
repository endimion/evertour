package com.evertour.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evertour.model.DMO.Guide;
import com.evertour.services.GuideService;


@Controller
public class LoginControllers {

	@Autowired
	GuideService gservice;
	
	
	@RequestMapping(value="/login", method={RequestMethod.GET,RequestMethod.POST})
	public String login(@RequestParam("name")String name, @RequestParam("pass")String pass
						, Model model){
		//TODO validate the login
		Guide guide = gservice.getGuideByUserName(name);
		if(guide == null){
			model.addAttribute("loginErr","No such user found");
			return "guideRegister";
		}else{
			if(guide.getPassword().equals(pass)){
				return "redirect:home";
			}
			model.addAttribute("loginErr","Invalid combination of user name and password");
			return "register";
		}
	}//end of login controller
	
	
}//end of class
