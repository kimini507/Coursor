package com.coursor.app.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursor.app.dao.UserDao;
import com.coursor.app.model.User;
import com.coursor.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao ud;
	
	@Autowired
	public void setUserDAO(UserDao userDAO){
		this.ud = userDAO;
	}
	
	@Override
	@Transactional
	public void addUser(User user){
		this.ud.save(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		this.ud.save(user);		
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		List<User> l = this.ud.findAll();
		return l;
	}

	@Override
	public User getUserById(Long id) {
		User user = this.ud.findById(id);
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = this.ud.findByUsername(username);
		return user;
	}
	
	
}
