package com.evertour.model.DAO;

import java.util.List;

import com.evertour.model.DMO.User;

public interface UserDAO {

	
	public User getUserById(Long id);
	public User getUserByUserName(String name);
	public long saveUser(User user);
	public List<User> getAllUsers();
	


}
