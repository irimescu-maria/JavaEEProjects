package com.project.javaee.rentmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.javaee.rentmovies.model.Movie;
import com.project.javaee.rentmovies.repository.MovieRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	private MovieRepository movieRepository;
	@Override
	public Movie findMovie(Long movieId) {
		 Movie movie = movieRepository.findById(movieId);
		return movie;
	}

	@Override
	@Transactional
	public List<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	@Transactional
	public Movie add(Movie movie) {
		movieRepository.save(movie);
		return movie;
	}

	@Override
	@Transactional
	public Movie update(Movie movie) {
		
		Movie existingMovie = movieRepository.findById(movie.getId());
		if(existingMovie == null) {
			String errorMessage = "Movie with id "+ movie.getId()+ " not found.";
		}
		return movieRepository.save(movie);
	}

	@Override
	@Transactional
	public void delete(Long movieId) {
		// TODO Auto-generated method stub
		Movie movie = movieRepository.findById(movieId);
		if(movie!=null) {
			movieRepository.deleteById(movieId);
		}else {
			String errorMessage = "Movie with id "+ movie.getId()+ " not found.";
		}
	}

}
