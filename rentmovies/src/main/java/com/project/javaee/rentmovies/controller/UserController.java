package com.project.javaee.rentmovies.controller;

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
import com.project.javaee.rentmovies.dto.UserDTO;
import com.project.javaee.rentmovies.model.Movie;
import com.project.javaee.rentmovies.model.Rental;
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
	private BCryptPasswordEncoder passwordEncoder;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") User user,	@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, Model model) {

		// Read parameters from request.
		/*String email = request.getParameter("email");
		String password = request.getParameter("password");
*/
		// user = userService.loginUser(email, passwordEncoder.encode(password));
		user = userService.loginUser(email, password);
		System.err.println("======================================= user: " + user);
		if (user == null) {
			model.addAttribute("Error logging in.  Please try again.");
			//model.addAttribute("user", user);
			return "login";
		}
	
		Role role = roleService.findRoleById(user.getRole().getId());
		System.err.println("user: " + user.getEmail() + user.getRole());
		if (user.getRole().getId() == role.getId()) {
			session.setAttribute("user", user);
			return "redirect:/movies";
		} else {
			session.setAttribute("user", user);
			//model.addAttribute("user", user);
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
			BindingResult bindingResult, Model model) {
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
			// user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			user.setPassword(userDTO.getPassword());
			user.setRole(new Role(userDTO.getRoleId()));
			userService.saveUser(user);

			if (user.getEmail().contains("admin")) {

				return "redirect:/movies";
			} else {
				return "redirect:/home";
			}
		}

	}


	@RequestMapping(value = "/rent", method = RequestMethod.GET)
	public String rentMovie(Model model) {

		Rental rent = new Rental();
		model.addAttribute("rent", rent);
		return "rent";
	}

	@RequestMapping(value = "/rent", method = RequestMethod.POST)
	public String rentForm(@Valid @ModelAttribute("rental") Rental rental, BindingResult result, Model model) {
		List<Movie> movies = movieService.findAllMovies();
		User user = new User();
		Movie movie = new Movie();
		for (Movie item : movies) {
			int count = item.getNumberAvailable();
			if (item.getNumberAvailable() == 0) {
				result.reject("Movie is not available");
			}
			count--;

			Rental rent = new Rental();
			rent.setUser(user);
			rent.setMovie(movie);
			rent.setDateRented(new Date());
		}
		return null;
	}
}
