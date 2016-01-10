package com.coursor.app.service;

import org.hibernate.Session;

import com.coursor.app.dao.SlideDao;
import com.coursor.app.model.Slide;

public interface SlideService {
	public boolean addSlide(Slide slide);
	public void updateSlide(Slide slide);
	public Slide getSlideById(Long id);
	
	public Slide deleteSlide(Slide slide);
	
	public Session getSession();
	public SlideDao getDao();
	void fixSlideSequence(Long topicId);
}
