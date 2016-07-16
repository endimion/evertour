package com.evertour.services;

import java.util.List;
import com.evertour.model.DMO.User;

public interface UserService {
	public User getUserById(Long id);
	public User getUserByUserName(String name);
	public long saveUser(User user);
	public List<User> getAllUsers();
}
