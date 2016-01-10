package com.coursor.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursor.app.dao.TopicDao;
import com.coursor.app.model.Slide;
import com.coursor.app.model.Topic;
import com.coursor.app.service.CourseService;
import com.coursor.app.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicDao topicDao;

	@Autowired
	private CourseService courseService;
	
	@Override
	@Transactional
	public boolean addTopic(Topic topic) {
		int nextIndex = courseService.getNextTopicIndex(topic.getCourse().getId());
		topic.setSeqno(nextIndex);
		topic = topicDao.save(topic);
		return true;
	}

	@Override
	@Transactional
	public void updateTopic(Topic topic) {
		topicDao.saveOrUpdate(topic);
	}

	@Override
	@Transactional
	public int getNextSlideIndex(Long topicId) {
		System.out.println("TOPICID:" + topicId);
		Topic topic = topicDao.findById(topicId);
		List<Slide> list = topic.getSlides();
		
		if(list == null){
			return 1;
		}
		
		return list.size()+1;
	}

	@Override
	@Transactional
	public Topic deleteTopic(Topic topic) {
		topicDao.delete(topic);
		fixTopicSequence(topic.getCourse().getId());
		return topic;
	}
	
	@Override
	@Transactional
	public void fixTopicSequence(Long courseId){
		List<Topic> list = topicDao.findByCourse(courseId);
		List<Topic> orderedList = new ArrayList<Topic>();
		System.out.println("COUNTOFTOPICS ("+courseId+"): " + list.size());
		int curSeqno = 1;
		int seqno = 999;
		int rows = list.size();
		while(curSeqno <= rows){
			seqno = 999;
			int curRowSeqno;
			//if topic is ordered, nothing should be saved
			int i = 0;
			for(Topic topic: list){
				curRowSeqno = topic.getSeqno();
				
				if(curRowSeqno <= seqno){
					seqno = curRowSeqno;
				}
				if(topic.getSeqno() == curSeqno){
					curSeqno++;
					orderedList.add(list.remove(i));
					break;
				}
				i++;
			}
			
			//if not in order reorder
			i=0;
			for(Topic topic: list){
				if(topic.getSeqno() == seqno){
					Topic temp = list.remove(i);
					temp.setSeqno(curSeqno);
					orderedList.add(temp);
					curSeqno++;
					break;
				}
				i++;
			}
		}
		
		for(Topic topic : list){
			System.out.println("SAVING: Topic" + topic.getSeqno() + " " + topic.getHeader());
			topicDao.saveOrUpdate(topic);
		}
	}

}
