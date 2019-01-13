package com.project.javaee.rentmovies.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "rental")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne
	@JoinColumn(name = "movieId")
	private Movie movie;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateRented;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateReturned;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getDateRented() {
		return dateRented;
	}

	public void setDateRented(Date dateRented) {
		this.dateRented = dateRented;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

}
