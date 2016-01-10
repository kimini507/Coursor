package com.coursor.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Hibernate;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coursor.app.model.Course;
import com.coursor.app.model.Slide;
import com.coursor.app.model.Topic;
import com.coursor.app.model.User;
import com.coursor.app.service.CourseService;
import com.coursor.app.service.SlideService;
import com.coursor.app.service.TopicService;
import com.coursor.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserCourseController {
	@Autowired
	CourseService courseService;

	@Autowired
	UserService userService;
	
	@Autowired
	TopicService topicService;
	
	@Autowired
	SlideService slideService;
	
	@RequestMapping(value = {"get/user/list"}, method = RequestMethod.POST)
	public @ResponseBody List<User> getUsers(HttpServletRequest request){
		List<User> list;
		
		//TODO /list will also have a criteria on the request named "SEARCH"
		//filter it using that
		
		list = userService.listUsers();
		for(int i = 0; i<list.size(); i++)
			System.out.println("USER: " + list.get(i).getUsername() + " -- " + list.get(i).getUserRole());
		
		return list;
	}
	
	@RequestMapping(value = {"get/course/list"}, method = RequestMethod.POST)
	public @ResponseBody List<Course> getCourses(HttpServletRequest request){
		List<Course> list;
		
		//TODO /list will also have a criteria on the request named "SEARCH"
		//filter it using that
		
		list = courseService.listCourses();
		return list;
	}
	
	@RequestMapping(value={"get/course/outline"}, method = RequestMethod.POST)
	public @ResponseBody Course getCourseOutline(@RequestBody Course course){				
		course = courseService.getCourseByCourseCode(course.getCode());
		return course;
	}
	
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="create/a/topic/", method=RequestMethod.POST)
	public @ResponseBody Topic createTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
		return topic;
	}

	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="create/a/slide/", method=RequestMethod.POST)
	public @ResponseBody Slide createSlide(@RequestBody Slide slide){
		slideService.addSlide(slide);
		return slide;
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="save/a/slide/", method=RequestMethod.POST)
	public @ResponseBody Slide saveSlide(@RequestBody Slide slide){
		Slide oldSlide = slideService.getSlideById(slide.getId());
		
		oldSlide.setLastModDate(null);
		oldSlide.setContent(slide.getContent());
		oldSlide.setLastModBy(slide.getLastModBy());
		slideService.updateSlide(oldSlide);

		return slide;
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="delete/a/slide/", method=RequestMethod.POST)
	public @ResponseBody Slide deleteSlide(@RequestBody Slide slide){
		slideService.deleteSlide(slide);
		return slide;
	}

	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="delete/a/topic/", method=RequestMethod.POST)
	public @ResponseBody Topic deleteTopic(@RequestBody Topic topic){
		topicService.deleteTopic(topic);
		
		return topic;
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="update/a/topic/", method=RequestMethod.POST)
	public @ResponseBody Topic updateTopic(@RequestBody Topic topic){
		topicService.updateTopic(topic);
		return topic;
	}


	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="update/a/slide/", method=RequestMethod.POST)
	public @ResponseBody Slide updateSlide(@RequestBody Slide slide){
		System.out.println("IM HERE AT UPDATING");
		Slide oldSlide = slideService.getSlideById(slide.getId());
		
		oldSlide.setLastModDate(null);
		oldSlide.setHeader(slide.getHeader());
		oldSlide.setType(slide.getType());
		oldSlide.setLastModBy(slide.getLastModBy());
		slideService.updateSlide(oldSlide);

		return slide;
	}
}
