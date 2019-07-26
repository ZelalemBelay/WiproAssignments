package com.movie.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
  
	int id;
	String movieTitle;
	List<Review> reviews = new ArrayList<>();
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieTitle=" + movieTitle + ", reviews=" + reviews + ", description="
				+ description + ", watchEnabled=" + watchEnabled + "]";
	}
	String description;
	boolean watchEnabled;
	
	public Movie(int id, String movieTitle, String description) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.description = description;
	}
	
	public Movie() {
		super();
	}

	public boolean isWatchEnabled() {
		return watchEnabled;
	}


	public void setWatchEnabled(boolean watchEnabled) {
		this.watchEnabled = watchEnabled;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
