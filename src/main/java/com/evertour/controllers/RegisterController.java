package com.evertour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evertour.model.DMO.Guide;
import com.evertour.model.DMO.User;
import com.evertour.services.GuideService;
import com.evertour.services.UserService;

@Controller
public class RegisterController {

	@Autowired
	GuideService gserv;
	@Autowired
	UserService userServ;

	/**
	 * Redirects to the view that presents the registration form
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/register", "/" }, method = RequestMethod.GET)
	public String registerGuide(Model model) {

		Guide guide = new Guide();
		model.addAttribute("guide", guide);

		return "register";
	}

	/**
	 * Registers a new user to our system as unAuthorized this has to be
	 * validated to make him authorized
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String receiveRegistrationInfo(@RequestParam("reg_username") String username,
			@RequestParam("reg_password") String password,
			@RequestParam("reg_password_confirm") String passwordConfirm, @RequestParam("reg_fullname") String name,
			@RequestParam("reg_email") String email, 
			@RequestParam(value="user",required=false) Boolean isUser, Model model) {

		if(isUser == null)	isUser = true;
		
		if (password.equals(passwordConfirm)) {
			if (!isUser) {
				Guide guide = new Guide();
				guide.setLat(0);
				guide.setLng(0);
				guide.setAddress("not set");
				guide.setName(name);
				guide.setPassword(password);
				guide.setUserName(username);

				if (gserv.registerNewGuide(guide) >= 0) {
					return "redirect:home";
				}
				model.addAttribute("regErr", "Username already taken!!!");
				return "register";
			}else{
				User u = new User();
				u.setName(name);
				u.setPassword(password);
				u.setUserName(username);
				u.setLat(0);
				u.setLng(0);
				if(userServ.getUserByUserName(username) == null){
					userServ.saveUser(u);
					return "redirect:home";
				}
				model.addAttribute("regErr", "Username already taken!!!");
				return "register";
			}
		}
		model.addAttribute("regErr", "passwords do not match");
		return "register";
	}

}
