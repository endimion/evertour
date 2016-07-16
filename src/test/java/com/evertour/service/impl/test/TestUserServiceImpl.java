package com.evertour.service.impl.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DMO.User;
import com.evertour.services.UserService;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback=true)
public class TestUserServiceImpl {

	@Autowired
	UserService userService ;
	
	@Test
	public void testGetAllUSers(){
		List<User> users = userService.getAllUsers();
		System.out.println(users.size());
	}
	
	@Test
	@Transactional
	public void saveUser(){
		User u = new User();
		u.setName("name");
		u.setPassword("pass");
		u.setUserName("user");
		u.setPassword("pass");
		long id = userService.saveUser(u);
		assert(id > 1);
	}

	@Test
	@Transactional
	public void getUserById(){
		User u = new User();
		u.setName("name");
		u.setPassword("pass");
		u.setUserName("user");
		u.setPassword("pass");
		long id = userService.saveUser(u);
		assertEquals(userService.getUserById(id).getId(), id);
	}
	
	
	@Test
	@Transactional
	public void getUserByUserName(){
		User u = new User();
		u.setName("name");
		u.setPassword("pass");
		u.setUserName("user");
		u.setPassword("pass");
		u.setUserName("user");
		long id = userService.saveUser(u);
		assertEquals(userService.getUserByUserName(u.getUserName()).getId(), id);
	}
	

}//end of test class
