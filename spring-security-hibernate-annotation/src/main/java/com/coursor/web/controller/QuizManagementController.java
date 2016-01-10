package com.coursor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/manage/"})
public class QuizManagementController {

	@RequestMapping(value="/a/quiz/", method=RequestMethod.GET)
	public ModelAndView createCourse(ModelAndView model){
		
		model.setViewName("qm/manage");
		return model;
	}
	
}
