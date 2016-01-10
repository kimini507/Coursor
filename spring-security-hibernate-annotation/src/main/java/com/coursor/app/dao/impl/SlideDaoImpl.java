package com.coursor.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.coursor.app.dao.SlideDao;
import com.coursor.app.model.Slide;

@Repository
public class SlideDaoImpl extends BaseDaoImpl<Slide> implements SlideDao{

	@Override
	public List<Slide> findByTopic(Long topicId) {
		List<Slide> list = getSession().createCriteria(Slide.class)
				.add(Restrictions.eq("topic.id", topicId))
				.list();
		return list;
	}

}
