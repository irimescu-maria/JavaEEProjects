package com.project.javaee.rentmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.Genre;
import com.project.javaee.rentmovies.repository.GenreRepository;

@Service("genreService")
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public List<Genre> findAllGenres() {
		
		return genreRepository.findAll();
	}
	
}
