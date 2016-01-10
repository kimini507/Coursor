package com.coursor.app.dao;

import java.util.List;

import com.coursor.app.model.Slide;

public interface SlideDao extends BaseDao<Slide>{
	public List<Slide> findByTopic(Long topicId);
}
