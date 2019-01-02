package com.project.javaee.rentmovies.service;

import java.util.List;

import com.project.javaee.rentmovies.model.Movie;

public interface MovieService {
	
	public Movie findMovie(Long movieId);
	
	public List<Movie> findAllMovies();
	
	public Movie add(Movie movie);
	
	public Movie update(Movie movie);
	
	public void delete(Long movieId);
}
