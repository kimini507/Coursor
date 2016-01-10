package com.coursor.app.service;

import java.util.List;

import com.coursor.app.model.Topic;

public interface TopicService {
	public boolean addTopic(Topic topic);
	public void updateTopic(Topic topic);
//	public List<Topic> listTopic(String courseId);
//	public Topic getTopicById(Long id);
	
	public int getNextSlideIndex(Long topicId);
	public Topic deleteTopic(Topic topic);
	void fixTopicSequence(Long courseId);
}
