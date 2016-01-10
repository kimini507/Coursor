package com.coursor.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coursor.app.model.Course;
import com.coursor.app.model.Topic;

public interface TopicDao extends BaseDao<Topic> {
	public List<Topic> findByCourse(Long courseId);
}
