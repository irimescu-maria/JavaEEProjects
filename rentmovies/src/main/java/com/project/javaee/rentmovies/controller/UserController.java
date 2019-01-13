package com.project.javaee.rentmovies.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.javaee.rentmovies.dto.UserDTO;
import com.project.javaee.rentmovies.model.Movie;
import com.project.javaee.rentmovies.model.Rental;
import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.model.User;
import com.project.javaee.rentmovies.service.MovieService;
import com.project.javaee.rentmovies.service.RentalService;
import com.project.javaee.rentmovies.service.RoleService;
import com.project.javaee.rentmovies.service.UserService;

@Controller("userController")

public class UserController {

	@Autowired
	private MovieService movieService;

	@Autowired
	UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RentalService rentalService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") User user, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, Model model) {

		user = userService.loginUser(email, password);

		if ("ADMIN".equals(user.getRole().getName())) {

			session.setAttribute("user", user);
			return "redirect:/movies";

		} else {
			session.setAttribute("user", user);
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("email");
		return "redirect:/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		List<Role> roles = roleService.findAllRoles();
		model.addAttribute("roles", roles);

		UserDTO user = new UserDTO();
		model.addAttribute("user", user);

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") UserDTO userDTO, 
			BindingResult bindingResult, Model model,
			HttpSession session) {
		User userExists = userService.findUserByEmail(userDTO.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}

		if (bindingResult.hasErrors()) {
			List<Role> roles = roleService.findAllRoles();
			model.addAttribute("roles", roles);

			return "signup";
		} else {

			User user = new User();

			user.setFirstname(userDTO.getFirstname());
			user.setLastname(userDTO.getLastname());
			user.setEmail(userDTO.getEmail());
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			// user.setPassword(userDTO.getPassword());
			user.setRole(new Role(userDTO.getRoleId()));
			userService.saveUser(user);

			if ("ADMIN".equals(user.getRole().getName())) {
				session.setAttribute("user", user);
				return "redirect:/movies";
			} else {
				session.setAttribute("user", user);
				return "redirect:/home";
			}
		}
	}
/*
	@RequestMapping(value = "/rent", method = RequestMethod.GET)
	public String rentMovie(Model model, HttpSession session) {

		  User user = (User) session.getAttribute("user");
		  model.addAttribute("user", user);

		  Rental rent = new Rental(); 
		  model.addAttribute("rent", rent);
		 
		return "rent";
	}*/

	@RequestMapping(value = "/rent")
	public String rentForm(@RequestParam(value = "id", required = true) Long id, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
				
		Movie movie = movieService.findMovie(id);
		user = userService.findById(user.getId());

		int count = movie.getNumberInStock();
		if(movie != null) {
			count--;
			movie.setNumberInStock(count);
			Rental rental = new Rental();
			rental.setUser(user);
			rental.setMovie(movie);
			movieService.update(movie);
			rentalService.save(rental);
			
			return "redirect:/home";
		}
				return null;
	}
}
