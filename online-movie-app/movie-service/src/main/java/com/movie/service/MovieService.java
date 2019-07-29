package com.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;

@Service
public class MovieService {

	@Autowired
	MovieServiceFeignProxy feignProxy;
	
	static List<Movie> allMovies = new ArrayList<Movie>();
	
	public List<Movie> getAllMovies() {
		
		return allMovies;
	}

	public Movie getMovie(int id) {
		
		return this.getMovieById(id);
	}

	public void addMovie(Movie movie) {
		allMovies.add(movie);
	}

	public void deleteMovie(int id) {
		allMovies.remove(this.getMovieById(id));
	}

	public void updateMovie(int id, Movie newMovie) {
		allMovies.set(allMovies.indexOf(this.getMovieById(id)), newMovie);
	}

	private Movie getMovieById(int id) {
		return allMovies.stream().filter(mov -> mov.getId() == id).findAny().get();
	}

	public SessionValidityResponse validateSession(String sessionToken) {
		SessionValidityRequest request = new SessionValidityRequest();
		request.setSessionToken(sessionToken);
		
		SessionValidityResponse resposne = this.feignProxy.validateSession(request);
		return resposne;
	}

	public boolean validateAdminSession(String sessionToken) {
		return sessionToken.equals("admin-token");
	}
	
}
