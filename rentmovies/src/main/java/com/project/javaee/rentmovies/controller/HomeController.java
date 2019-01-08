package com.project.javaee.rentmovies.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.javaee.rentmovies.model.Movie;
import com.project.javaee.rentmovies.model.User;
import com.project.javaee.rentmovies.service.MovieService;

@Controller
public class HomeController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if( user == null) {
			return "redirect:/login";
		}
		
		if(user.getEmail().contains("admin")) {
			return "redirect:/movies";
		}
		
		List<Movie> movies = movieService.findAllMovies();
		model.addAttribute("movies", movies);
	
		return "home";

	}
}
