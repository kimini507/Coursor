package com.coursor.app.service;

import java.util.List;

import com.coursor.app.model.User;

public interface UserService{
	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listUsers();
	public User getUserById(Long id);
	public User getUserByUsername(String username);
//	public void removeUser(Long id);
}
