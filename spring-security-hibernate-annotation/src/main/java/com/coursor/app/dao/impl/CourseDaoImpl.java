package com.coursor.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.coursor.app.dao.CourseDao;
import com.coursor.app.model.Course;

@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{

	@Override
	@SuppressWarnings("unchecked")
	public Course findByCourseCode(String courseCode) {
		List<Course> list = getSession().createCriteria(Course.class)
				.add(Restrictions.eq("code", courseCode))
				.list();
		
		if(list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

}
