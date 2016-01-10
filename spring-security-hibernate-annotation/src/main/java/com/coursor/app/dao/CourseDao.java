package com.coursor.app.dao;

import org.springframework.stereotype.Repository;

import com.coursor.app.model.Course;

public interface CourseDao extends BaseDao<Course> {
	public Course findByCourseCode(String courseCode);
}
