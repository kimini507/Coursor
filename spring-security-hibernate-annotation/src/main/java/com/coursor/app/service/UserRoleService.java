package com.coursor.app.service;

import java.util.List;

import com.coursor.app.model.User;
import com.coursor.app.model.UserRole;

public interface UserRoleService {
	public void addUserWithRole(User user, String role);
	public void addUserWithRole(UserRole userRole);
	public void updateUserWithRole(UserRole userRole);
	public List<UserRole> listUsersWithRoles(String role);
	
}
