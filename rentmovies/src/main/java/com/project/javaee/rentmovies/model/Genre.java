package com.project.javaee.rentmovies.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "genre")
	private Collection<Movie> movies = new LinkedList<Movie>();

	public Genre() {
		
	}
	
	public Genre(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Collection<Movie> movies) {
		this.movies = movies;
	}
	
	
}
