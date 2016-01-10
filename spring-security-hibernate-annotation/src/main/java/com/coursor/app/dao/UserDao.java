package com.coursor.app.dao;


import com.coursor.app.model.User;

public interface UserDao extends BaseDao<User>{
	public User findByUsername(String username);
}

