package com.coursor.app.service.impl;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursor.app.dao.CourseDao;
import com.coursor.app.model.Course;
import com.coursor.app.model.Topic;
import com.coursor.app.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Override
	@Transactional
	public boolean addCourse(Course course) {
		courseDao.save(course);
		return true;
	}

	@Override
	@Transactional
	public void updateCourse(Course course) {
		courseDao.saveOrUpdate(course);
	}

	@Override
	public List<Course> listCourses() {
		List<Course> list = courseDao.findAll();
		return list;
	}

	@Override
	public Course getCourseById(Long id) {
		Course course = courseDao.findById(id);
		return course;
	}

	@Override
	public Course getCourseByCourseCode(String courseCode) {
		Course course = courseDao.findByCourseCode(courseCode);
		return course;
	}

	@Override
	public int getNextTopicIndex(Long courseId) {
		Course course = courseDao.findById(courseId);
		
		List<Topic> l = course.getTopics();
    	
		if(l == null){
			return 0; 
		}

		System.out.println("LIST OF TOPICS FOR " + courseId);
    	for(Topic t : l){
    		System.out.println(t.getHeader());
    	}
    	
		return l.size()+1;
	}
	
}
