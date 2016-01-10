package com.coursor.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.coursor.app.model.Course;
import com.coursor.app.service.CourseService;

@Controller
@RequestMapping(value= {"/manage/"})
public class CourseManagementController {

	@Autowired
	CourseService courseService;

	private final String CM_DIR = "cm/";

	@ModelAttribute("roleList")
	public List<String> roleList(){
		List<String> list = new ArrayList<String>();
		
		list.add("ROLE_ADMIN");
		list.add("ROLE_USER");
		list.add("ROLE_TEACHER");
		list.add("ROLE_STUDENT");
		return list;
	}

	
	@RequestMapping(value="/a/course/", method=RequestMethod.GET)
	public ModelAndView createCourse(ModelAndView model){
		
		model.setViewName("um/manage");
		return model;
	}
	
	@RequestMapping(value="/a/course/", method=RequestMethod.POST)
	public @ResponseBody CreateCourseResponse createCourse(@RequestBody Course course, HttpServletResponse response){
		courseService.addCourse(course);
		
		CreateCourseResponse result = new CreateCourseResponse();
		
		result.setStatus("OK");
		result.setCourse(course);

		return result;
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/a/course/{code}", method=RequestMethod.GET)
	public ModelAndView manageCourse(ModelAndView model, @PathVariable String code){
		
		model.addObject("courseId",courseService.getCourseByCourseCode(code).getId());
		model.addObject("courseCode", code);
		model.setViewName(CM_DIR+"editCourse");
		return model;
	}
	
	class CreateCourseResponse{
		private Course course;
		private String status;

		public Course getCourse() {
			return course;
		}
		
		public void setCourse(Course course) {
			this.course = course;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		
	}
}
