package com.coursor.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.coursor.app.dao.TopicDao;
import com.coursor.app.model.Course;
import com.coursor.app.model.Topic;
import com.coursor.app.model.User;

@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao{

	@Override
	public List<Topic> findByCourse(Long courseId) {
		List<Topic> topics = getSession().createCriteria(Topic.class)
				.add(Restrictions.eq("course.id", courseId))
				.list();
		return topics;
	}


}
