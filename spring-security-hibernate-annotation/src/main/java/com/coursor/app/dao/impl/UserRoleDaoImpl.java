package com.coursor.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.coursor.app.dao.UserRoleDao;
import com.coursor.app.model.UserRole;

@Repository
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<UserRole> findByUserRole(String role) {
		List<UserRole> users = new ArrayList<UserRole>();
		
		users = getSession().createCriteria(UserRole.class)
				.add(Restrictions.eqOrIsNull("role", role))
				.list();
		
		return users;
	}

	@Override
	@SuppressWarnings("unchecked")
	public UserRole findByUsername(String username) {
		List<UserRole> users = new ArrayList<UserRole>();
		
		users = getSession().createCriteria(UserRole.class)
				.add(Restrictions.eq("username", username))
				.list();
		
		if(users.size() > 0){
			return users.get(0);
		}
		
		return null;
	}

}
