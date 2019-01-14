package com.project.javaee.rentmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.javaee.rentmovies.exception.DuplicateRecordException;
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

		// Check if already exist a movie with same name
		Movie existingMovie = movieRepository.findByName(movie.getName());
		if (existingMovie != null) {
			String errorMessage = "Already exists a movie with same name: " + movie.getName();
			try {
				throw new DuplicateRecordException(errorMessage);
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (movie.getName() == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}

		if (movie.getDateAdded() == null) {
			throw new IllegalArgumentException("Date cannot be null!");
		}

		if (movie.getGenre() == null) {
			throw new IllegalArgumentException("Genre cannot be null!");
		}

		if (movie.getImagePath() == null) {
			throw new IllegalArgumentException("Image cannot be null!");
		}
		
		if(movie.getNumberAvailable() == 0)
			throw new IllegalArgumentException("Number available cannot be null!");
		
		if(movie.getNumberInStock() == 0)
			throw new IllegalArgumentException("Number in Stock cannot be null!");
		
		if(movie.getReleaseDate() == null)
			throw new IllegalArgumentException("Date cannot be null!");
		
		movieRepository.save(movie);
		return movie;
	}

	@Override
	@Transactional
	public Movie update(Movie movie) {

		Movie existingMovie = movieRepository.findById(movie.getId());
		if (existingMovie == null) {
			String errorMessage = "Movie with id " + movie.getId() + " not found.";
		}
		
		if (movie.getName() == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}

		if (movie.getDateAdded() == null) {
			throw new IllegalArgumentException("Date cannot be null!");
		}

		if (movie.getGenre() == null) {
			throw new IllegalArgumentException("Genre cannot be null!");
		}

		if (movie.getImagePath() == null) {
			throw new IllegalArgumentException("Image cannot be null!");
		}
		
		if(movie.getNumberAvailable() == 0)
			throw new IllegalArgumentException("Number available cannot be null!");
		
		if(movie.getNumberInStock() == 0)
			throw new IllegalArgumentException("Number in Stock cannot be null!");
		
		if(movie.getReleaseDate() == null)
			throw new IllegalArgumentException("Date cannot be null!");
		
		
		return movieRepository.save(movie);
	}

	@Override
	@Transactional
	public void delete(Long movieId) {
		// TODO Auto-generated method stub
		Movie movie = movieRepository.findById(movieId);
		if (movie != null) {
			movieRepository.deleteById(movieId);
		} else {
			String errorMessage = "Movie with id " + movie.getId() + " not found.";
		}
	}

}
