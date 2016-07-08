package com.evertour.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertour.model.DAO.UserDAO;
import com.evertour.model.DMO.User;
import com.evertour.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		return userDAO.getUserByName(name);
	}

	@Override
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
