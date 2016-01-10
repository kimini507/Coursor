package com.coursor.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursor.app.dao.UserRoleDao;
import com.coursor.app.model.User;
import com.coursor.app.model.UserRole;
import com.coursor.app.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao urd;

	@Override
	@Transactional
	public void addUserWithRole(User user, String role) {
		addUserWithRole(new UserRole(user, role));
	}

	@Override
	@Transactional
	public void addUserWithRole(UserRole userRole) {
		urd.save(userRole);
	}

	
	@Override
	@Transactional
	public void updateUserWithRole(UserRole userRole) {
		urd.saveOrUpdate(userRole);
	}

	@Override
	@Transactional
	public List<UserRole> listUsersWithRoles(String role) {
		List<UserRole> list = urd.findByUserRole(role);
		return list;
	}


}
