package com.project.javaee.rentmovies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.javaee.rentmovies.model.Genre;

@Repository("genreRepository")
public interface GenreRepository extends JpaRepository<Genre, Long>{

	List<Genre> findById(Long id);
}
