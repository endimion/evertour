package com.evertour.services;

import java.util.List;
import com.evertour.model.DMO.User;

public interface UserService {
	public User getUserById(Long id);
	public User getUserByName(String name);
	public void saveUser(User user);
	public List<User> getAllUsers();
}
