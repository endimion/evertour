package com.evertour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evertour.model.DMO.Guide;
import com.evertour.model.DMO.User;
import com.evertour.services.GuideService;
import com.evertour.services.UserService;

@Controller
public class LoginControllers {

	@Autowired
	GuideService gservice;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@RequestParam("name") String name, @RequestParam("pass") String pass,
						ModelMap model) {
		// TODO validate the login
		Guide guide = gservice.getGuideByUserName(name);
		User u = userService.getUserByUserName(name);

		if (guide == null && u == null) {
			model.addAttribute("loginErr", "No such user found");
			return "register";
		} else {// if either a user of a guide with the given name was found
			if (guide != null) {
				if (guide.getPassword().equals(pass)) {
					return "redirect:home";
				}
				model.addAttribute("loginErr", "Invalid combination of user name and password");
				return "register";
			}// end if the user was a guilde
			else {
				if (u.getPassword().equals(pass)) {
					return "redirect:home";
				} else {
					model.addAttribute("loginErr", "Invalid combination of user name and password");
					return "register";
				}
			}// end if the user was a user
		}
	}// end of login controller

}// end of class
