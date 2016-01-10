package com.coursor.web.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.coursor.app.model.User;
import com.coursor.app.model.UserRole;
import com.coursor.app.service.UserRoleService;
import com.coursor.app.service.UserService;
import com.coursor.web.component.editor.UserRoleEditor;

@Controller
@RequestMapping(value= {"/manage/"})
public class UserManagementController {
	
	
	public static final String MODE_EDIT = "EDIT";
	public static final String MODE_CREATE = "CREATE";
	
	private final String UM_DIR = "um/";

	@Autowired 
	private UserRoleEditor userRoleEditor;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	
	@ModelAttribute("roleList")
	public List<String> roleList(){
		List<String> list = new ArrayList<String>();
		
		list.add("ROLE_ADMIN");
		list.add("ROLE_USER");
		list.add("ROLE_TEACHER");
		list.add("ROLE_STUDENT");
		return list;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(UserRole.class, this.userRoleEditor);
	}

	/*
	 * Sets the user creation view
	 */
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = {"/a/user/","/a/user/register"}, method = RequestMethod.GET)
	public ModelAndView createUserPage(ModelAndView model, @ModelAttribute("account") User user) {

		model.addObject("title", "USER MANAGEMENT");
		model.addObject("message", "ADMIN USER MANAGEMENT");
		model.addObject("manageMode",MODE_CREATE);
		
		model.addObject("userActionUrl","manage/a/user/register");
		
		model.setViewName(UM_DIR+"manage");
		
		model.addObject("command", new User());
		model.addObject("editorHeader","Create User");
		return model;

	}
	
	/*
	 * Registers a user
	 */
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = {"/a/user/register"}, method = RequestMethod.POST)
	public ModelAndView submitRegister(@Valid @ModelAttribute("account") User user, ModelAndView model, HttpServletRequest request){		
		model.addObject("command", user);
		
		Boolean usernameTaken = userService.getUserByUsername(user.getUsername()) != null;
		
		List<String[]> errorList = new ArrayList<String[]>();
		
		if(usernameTaken){
			errorList.add(new String[]{"username","Username already taken."});
		}
		
		Set<UserRole> urlist = user.getUserRole();
		for(UserRole userRole:urlist){
			userRole.setUser(user);
		}
		
		System.out.println("ATTR NAMES");
		System.out.println(request.getAttributeNames());
		
		if(!doRegister(user, model)){
			model.addObject("error", errorList);
			model.setViewName(UM_DIR+"manage");
		} else {
			model.addObject("msg", "User created successfully.");
			model.setView(new RedirectView("/manage/a/user/", true, true, false));
		}
		
		
		return model;
	}
	
	public boolean doRegister(User user, ModelAndView model){
		try{
			userService.addUser(user);
			Set<UserRole> urlist = user.getUserRole();
			for(UserRole userRole:urlist){
				userRoleService.addUserWithRole(userRole);
			}
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * Sets edit user view
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@RequestMapping(value = {"/a/user/{username}"}, method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable String username,  ModelAndView model, @ModelAttribute("account") User user){
		user = userService.getUserByUsername(username);

		List<String[]> errorList = new ArrayList<String[]>();
		
		if(user == null){
			errorList.add(new String[]{"general","User already exists"});
			user = new User();
			model.addObject("error", errorList);
		} else {
		}

		user.setUsername(username);
		model.addObject("account", user);
		model.addObject("editorHeader","Edit User");
		model.addObject("userActionUrl","manage/a/user/"+username);
		
		model.addObject("manageMode",MODE_EDIT);

		model.setViewName(UM_DIR + "manage");
		return model;
	}
	
	/*
	 * Updates a user's information
	 */
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = {"/a/user/{username}"}, method = RequestMethod.POST)
	public ModelAndView saveUser(ModelAndView model, User userForm, @PathVariable String username){
		User user = userService.getUserByUsername(username);
		
		//set details
		user.setEmail(userForm.getEmail());
		user.setFirstName(userForm.getFirstName());
		user.setMiddleName(userForm.getMiddleName());
		user.setLastName(userForm.getLastName());
		user.setEnabled(true);		
		
		//set password
		String newPass = userForm.getPassword();
		if(!StringUtils.isEmpty(newPass)){
			user.setPassword(newPass);
		}
		
		//set modifier
		User currUser = getLoggedInUser();
		user.setLastModBy(currUser.getId());
		
		//set last modification
		user.setLastModDate(getCurrentDate());
	
		userService.updateUser(user);
		
		//TODO set something here
		//set other parameters
		model.setView(new RedirectView("/manage/a/user/"+username,true,true,false));
		
		return model;
	}
	
	/*
	 * Get currently logged in User
	 */
	public User getLoggedInUser(){
		org.springframework.security.core.userdetails.User currUser = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = userService.getUserByUsername(currUser.getUsername());

		return user;
	}
	
	public static Date getCurrentDate(){
		return new Date(System.currentTimeMillis());
	}
	
	@RequestMapping(value = {"/login", "/loggen"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.addObject("username", request.getUserPrincipal());
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

}