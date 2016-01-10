package com.coursor.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursor.app.dao.SlideDao;
import com.coursor.app.model.Slide;
import com.coursor.app.model.Topic;
import com.coursor.app.service.SlideService;
import com.coursor.app.service.TopicService;

@Service
public class SlideServiceImpl implements SlideService{
	
	@Autowired
	SlideDao slideDao;
	
	@Autowired
	TopicService topicService;
	
	@Override
	@Transactional
	public boolean addSlide(Slide slide) {
		int nextSeq = topicService.getNextSlideIndex(slide.getTopic().getId());
		slide.setSeqno(nextSeq);
		slide = slideDao.save(slide);
		return true;
	}

	@Override
	@Transactional
	public void updateSlide(Slide slide) {
		slideDao.saveOrUpdate(slide);
	}

	@Override
	public Slide getSlideById(Long id) {
		Slide slide = slideDao.findById(id);
		return slide;
	}

	public Session getSession(){
		return slideDao.getSession();
	}

	@Override
	public SlideDao getDao() {
		return slideDao;
	}

	@Override
	@Transactional
	public Slide deleteSlide(Slide slide) {
		slideDao.delete(slide);
		return slide;
	}
	
	@Override
	@Transactional
	public void fixSlideSequence(Long topicId){
		List<Slide> list = slideDao.findByTopic(topicId);
		List<Slide> orderedList = new ArrayList<Slide>();
		System.out.println("COUNTOFTOPICS ("+topicId+"): " + list.size());
		int curSeqno = 1;
		int seqno = 999;
		int rows = list.size();
		while(curSeqno <= rows){
			seqno = 999;
			int curRowSeqno;
			//if topic is ordered, nothing should be saved
			int i = 0;
			for(Slide slide: list){
				curRowSeqno = slide.getSeqno();
				
				if(curRowSeqno <= seqno){
					seqno = curRowSeqno;
				}
				if(slide.getSeqno() == curSeqno){
					curSeqno++;
					orderedList.add(list.remove(i));
					break;
				}
				i++;
			}
			
			//if not in order reorder
			i=0;
			for(Slide slide: list){
				if(slide.getSeqno() == seqno){
					Slide temp = list.remove(i);
					temp.setSeqno(curSeqno);
					orderedList.add(temp);
					curSeqno++;
					break;
				}
				i++;
			}
		}
		
		for(Slide slide : list){
			System.out.println("SAVING: Topic" + slide.getSeqno() + " " + slide.getHeader());
			slideDao.saveOrUpdate(slide);
		}
	}
}
