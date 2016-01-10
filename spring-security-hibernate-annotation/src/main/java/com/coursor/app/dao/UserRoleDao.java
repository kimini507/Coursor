package com.coursor.app.dao;

import java.util.List;

import com.coursor.app.model.UserRole;

public interface UserRoleDao extends BaseDao<UserRole>{
	public List<UserRole> findByUserRole(String role); 
	public UserRole findByUsername(String username);
}
