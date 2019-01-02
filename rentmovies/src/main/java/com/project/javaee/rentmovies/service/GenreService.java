package com.project.javaee.rentmovies.service;

import java.util.List;

import com.project.javaee.rentmovies.model.Genre;

public interface GenreService {
	
	public List<Genre> findAllGenres();
}
