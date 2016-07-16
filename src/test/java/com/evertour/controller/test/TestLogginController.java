package com.evertour.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import com.evertour.controllers.LoginControllers;
import com.evertour.model.DMO.User;
import com.evertour.service.impl.test.TestConfig;
import com.evertour.services.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback=true)
public class TestLogginController {

	@Autowired
	LoginControllers lc ; 
	

	@Autowired
	UserService userService ;
	
	@Test
	public void testLoginGuide(){
		ModelMap m = new ModelMap();
		assertEquals(lc.login("nikos", "panathinaikos", m),"redirect:home");
		assertEquals(lc.login("nikos", "paninaikos", m),"register");
	}
	
	
	@Test
	@Transactional
	public void testLoginUser(){
		ModelMap m = new ModelMap();
		
		User u = new User();
		u.setUserName("name");
		u.setPassword("pass");
		userService.saveUser(u);
		
		assertEquals(lc.login("name", "pass",  m),"redirect:home");
		assertEquals(lc.login("name", "paninaikos", m),"register");
	}
	
}
