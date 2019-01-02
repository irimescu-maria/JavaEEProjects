package com.project.javaee.rentmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.javaee.rentmovies.model.Movie;

import antlr.collections.List;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long>{

	 Movie findByName(String name);

	Movie findById(Long movieId);

	void deleteById(Long movieId);
}
