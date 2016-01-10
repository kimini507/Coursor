package com.coursor.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.coursor.app.dao.UserDao;
import com.coursor.app.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	@SuppressWarnings("unchecked")
	public User findByUsername(String username) {
		List<User> users = getSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.list();
		
		if(users.size() > 0){
			return users.get(0);
		}
		
		return null;
	}
	
}
