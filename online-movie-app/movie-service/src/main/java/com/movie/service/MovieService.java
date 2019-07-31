package com.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieService {

	@Autowired
	MovieServiceFeignProxy feignProxy;
	
	static List<Movie> allMovies = new ArrayList<Movie>();
	
	public List<Movie> getAllMovies() {
		
		return allMovies;
	}

	@HystrixCommand(fallbackMethod = "getMovieFallBack")
	public Movie getMovie(int id) {
		
		return this.getMovieById(id);
	}

	@HystrixCommand(fallbackMethod = "addMovieFallBack")
	public void addMovie(Movie movie) {
		allMovies.add(movie);
	}

	@HystrixCommand(fallbackMethod = "deleteMovieFallBack")
	public void deleteMovie(int id) {
		allMovies.remove(this.getMovieById(id));
	}

	@HystrixCommand(fallbackMethod = "updateMovieFallBack")
	public void updateMovie(int id, Movie newMovie) {
		allMovies.set(allMovies.indexOf(this.getMovieById(id)), newMovie);
	}

	private Movie getMovieById(int id) {
		return allMovies.stream().filter(mov -> mov.getId() == id).findAny().get();
	}

	//adding retry mechanism for the feign client call using hystrix. 
	@HystrixCommand(fallbackMethod = "sessionValidatorFallBack")
	public SessionValidityResponse validateSession(String sessionToken) {
		SessionValidityRequest request = new SessionValidityRequest();
		request.setSessionToken(sessionToken);
		
		SessionValidityResponse resposne = this.feignProxy.validateSession(request);
		return resposne;
	}

	public boolean validateAdminSession(String sessionToken) {
		return sessionToken.equals("admin-token");
	}
	
	public String getMovieFallBack() {
		return "Fallback for getMovie";
	}

	public String addMovieFallBack() {
		return "Fallback for addMovie";
	}
	
	public String updateMovieFallBack() {
		return "Fallback for updateMovie";
	}
	
	public String deleteMovieFallBack() {
		return "Fallback for deleteMovie";
	}
	
	public Object sessionValidatorFallBack(String sessionToken) {
		
		if(sessionToken== null)
			return null;
		SessionValidityRequest request = new SessionValidityRequest();
		request.setSessionToken(sessionToken);
		
		SessionValidityResponse resposne = this.feignProxy.validateSession(request);
		return resposne;
	}
}
