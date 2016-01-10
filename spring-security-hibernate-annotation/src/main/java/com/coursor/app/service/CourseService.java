package com.coursor.app.service;

import java.util.List;

import com.coursor.app.model.Course;

public interface CourseService {
	public boolean addCourse(Course course);
	public void updateCourse(Course course);
	public List<Course> listCourses();
	public Course getCourseById(Long id);
	public Course getCourseByCourseCode(String courseCode);
	public int getNextTopicIndex(Long courseId);
}
