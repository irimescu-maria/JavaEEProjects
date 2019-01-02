package com.project.javaee.rentmovies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.javaee.rentmovies.dto.MovieDTO;
import com.project.javaee.rentmovies.model.Genre;
import com.project.javaee.rentmovies.model.Movie;
import com.project.javaee.rentmovies.service.GenreService;
import com.project.javaee.rentmovies.service.MovieService;

@Controller
/*@RequestMapping(value = "/admin")*/
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getMovies(Model model) {
		List<Movie> movies = movieService.findAllMovies();
		model.addAttribute("movies", movies);
		return "movies";
	}

	@RequestMapping(value = "/movies/add", method = RequestMethod.GET)
	public String getAddMovie(Model model) {

		//List all the genres for dropdown list
		List<Genre> genres = genreService.findAllGenres();
		model.addAttribute("genres", genres);

		MovieDTO movie = new MovieDTO();
		model.addAttribute("movie", movie);

		return "addMovie";
	}

	@RequestMapping(value = "/movies/add", method = RequestMethod.POST)
	public String addMovie(@Valid @ModelAttribute("movie") MovieDTO movieDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
			//List of all genres to model to populate the genre drop down
			List<Genre> genres = genreService.findAllGenres();
			model.addAttribute("genres", genres);
			return "addMovie";
		}else {
			Movie movie = new Movie();
			movie.setName(movieDTO.getName());
			movie.setDateAdded(movieDTO.getDateAdded());
			movie.setReleaseDate(movieDTO.getReleaseDate());
			movie.setNumberAvailable(movieDTO.getNumberAvailable());
			movie.setNumberInStock(movieDTO.getNumberInStock());
			movie.setGenre(new Genre(movieDTO.getGenreId()));
			movieService.add(movie);
			redirectAttributes.addFlashAttribute("message", "Successfully added..");
			return "redirect:/movies";
		}

	}


	@RequestMapping(value = "/movie/edit", method = RequestMethod.GET)
	public String getEditMovie(@RequestParam(value = "id", required = true) Long id, Model model, 
			RedirectAttributes redirectAttributes) {

		Movie movie = movieService.findMovie(id);

		if(movie != null) {
			//Create and put a MovieDTO to edit movie
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setId(movie.getId());
			movieDTO.setDateAdded(movie.getDateAdded());
			movieDTO.setName(movie.getName());
			movieDTO.setNumberAvailable(movie.getNumberAvailable());
			movieDTO.setNumberInStock(movie.getNumberInStock());
			movieDTO.setReleaseDate(movie.getReleaseDate());
			movieDTO.setGenreId(movie.getGenre().getId());

			model.addAttribute("movie", movieDTO);

			//Add a list with all genres for movie
			List<Genre> genres = genreService.findAllGenres();
			model.addAttribute("genres", genres);

			return "editMovie";
		}else {
			redirectAttributes.addFlashAttribute("errorMessage", "Movie with specified id not found");
			return "redirect:/movies";
		}
	}
	
	@RequestMapping(value = "/movie/edit", method = RequestMethod.POST)
	public String editMovie(@Valid @ModelAttribute("movie") MovieDTO movieDTO, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			List<Genre> genres = genreService.findAllGenres();
			model.addAttribute("genres", genres);
			
			return "editMovie";
		}else {
			Movie movie = new Movie();
			movie.setId(movieDTO.getId());
			movie.setDateAdded(movieDTO.getDateAdded());
			movie.setName(movieDTO.getName());
			movie.setNumberAvailable(movieDTO.getNumberAvailable());
			movie.setNumberInStock(movieDTO.getNumberInStock());
			movie.setDateAdded(movieDTO.getDateAdded());
			movie.setReleaseDate(movieDTO.getReleaseDate());
			movie.setGenre(new Genre(movieDTO.getGenreId()));
			movieService.update(movie);
			
			return "redirect:/movies";
		}		
	}
	
	@RequestMapping(value = "/movie/delete", method = RequestMethod.GET)
	public String deleteMovie(@Valid @ModelAttribute("id") Long id, BindingResult result, RedirectAttributes redirectAttributes) {
	try {
		movieService.delete(id);
		redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
	} catch (Exception e) {
		redirectAttributes.addFlashAttribute("errorMessage", "Delete error: " + e.getMessage());
	}
		return "redirect:/movies";
	}
}
