package com.project.javaee.rentmovies.controller;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

import com.project.javaee.rentmovies.dto.UserDTO;
import com.project.javaee.rentmovies.model.Genre;
import com.project.javaee.rentmovies.model.Movie;
import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.model.User;
import com.project.javaee.rentmovies.service.MovieService;
import com.project.javaee.rentmovies.service.RoleService;
import com.project.javaee.rentmovies.service.UserService;

@Controller("userController")

public class UserController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
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

		@SuppressWarnings("unused")
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//user = userService.findUserByEmail(auth.getName());
		model.addAttribute("user", user.getFirstname());
	
	
		if	(user.getRole().equals("CUSTOMER")) {
			return "redirect:/home";
		}else {
			return "redirect:/movies";
		}
	
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		List<Role> roles = roleService.findAllRoles();
		model.addAttribute("roles", roles);

		
		UserDTO user = new UserDTO();
		
		model.addAttribute("user", user);
		
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByEmail(userDTO.getEmail());
		
		if(userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}
		if(bindingResult.hasErrors()) {
			List<Role> roles = roleService.findAllRoles();
			model.addAttribute("roles", roles);
			return "signup";
		}else {
			User user = new User();
			
			user.setFirstname(userDTO.getFirstname());
			user.setLastname(userDTO.getLastname());
			user.setEmail(userDTO.getEmail());
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			user.setRole(new Role(userDTO.getRoleId()));
			userService.saveUser(user);
			//model.add("msg", "User has been registered successfully!");
		//	model.addAttribute("user", new User());
			return "home";
		
		}
	
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<Movie> movies = movieService.findAllMovies();
		model.addAttribute("movies", movies);
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
