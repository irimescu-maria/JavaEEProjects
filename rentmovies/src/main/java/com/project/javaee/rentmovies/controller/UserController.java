package com.project.javaee.rentmovies.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.model.User;
import com.project.javaee.rentmovies.service.UserService;

@Controller("userController")

public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "login";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") User user, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//	user = userService.findUserByEmail(auth.getName());
		model.addAttribute("user", user.getFirstname());

		return "home";
		
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "signup";
	}
	
	@RequestMapping(value = "/home", method=RequestMethod.POST)
	public String createUser(@Valid User user, BindingResult bindingResult) {
		Model model = null;
		User userExists = userService.findUserByEmail(user.getEmail());
		
		if(userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}
		if(bindingResult.hasErrors()) {
			model.addAttribute("/signup");
		}else {
			user.setFirstname(user.getFirstname());
			user.setLastname(user.getLastname());
			user.setEmail(user.getEmail());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			userService.saveUser(user);
			//model.add("msg", "User has been registered successfully!");
		//	model.addAttribute("user", new User());
		
		}
		return "home";
	}
//	
//	@RequestMapping(value = "/home", method=RequestMethod.GET)
//	public ModelAndView home() {
//		
//		ModelAndView model = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findUserByEmail(auth.getName());
//		
//		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
//		model.setViewName("home/home");
//		return model;
//	}
//	
//	@RequestMapping(value = {"/access_denied"}, method=RequestMethod.GET)
//	public ModelAndView accessDenied() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("error/access_denied");
//		return model;
//	}
}
