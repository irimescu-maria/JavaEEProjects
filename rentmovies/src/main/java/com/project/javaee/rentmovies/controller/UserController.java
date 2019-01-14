package com.project.javaee.rentmovies.controller;

import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String createUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model,
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

	@RequestMapping(value = "/rent")
	@ResponseBody
	public String rentForm(@RequestParam(value = "id", required = true) Long id, HttpSession session,
			RedirectAttributes redirectAttributes) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}

		Movie movie = movieService.findMovie(id);
		user = userService.findById(user.getId());

		int count = movie.getNumberInStock();

		// Add 10 days tocurrent date
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 10);
		date = calendar.getTime();

		count--;
		if (count > 0) {
			movie.setNumberInStock(count);

			Rental rental = new Rental();
			rental.setUser(user);
			rental.setMovie(movie);
			rental.setDateRented(new Date());
			rental.setDateReturned(date);
			movieService.update(movie);
			rentalService.save(rental);

			redirectAttributes.addFlashAttribute("message",
					"You are rented the movie " + movie.getName() + " until " + rental.getDateRented());
		}
		return "redirect:/home";

	}
}
