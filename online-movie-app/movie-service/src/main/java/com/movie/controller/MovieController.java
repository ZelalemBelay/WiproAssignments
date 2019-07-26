package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.model.Review;
import com.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies(@RequestHeader String sessionToken) {
		return this.movieService.getAllMovies();
	}

	@GetMapping("/movie/{id}")
	public Movie getMovie(@RequestHeader String sessionToken, @PathVariable int id) {

		Movie movie = this.movieService.getMovie(id);
		movie.setWatchEnabled(true);
		return movie;
	}

	@PostMapping("/movie/{id}/submitReview")
	public Movie addReview(@RequestHeader String sessionToken, @PathVariable int id, @RequestBody Review review) {

		Movie movie = this.movieService.getMovie(id);
		movie.getReviews().add(review);
		return movie;
	}

	@PostMapping("/movie/add")
	public Movie addMovie(@RequestHeader String sessionToken, @RequestBody Movie movie) {
		//gets the token from the user service and validated here. 
		if (sessionToken.equals("admin-token")) //this is to mock token based oauth2 authorization manager which will be used in both services. 
			this.movieService.addMovie(movie);
		else
			movie = null;
		return movie;
	}
	
	@PutMapping("/movie/update/{id}")
	public Movie updateMovie(@RequestHeader String sessionToken, @PathVariable int id, @RequestBody Movie movie) {

		if (sessionToken.equals("admin-token"))  //this is to mock token based oauth2 authorization manager which will be used in both services. 
			this.movieService.updateMovie(id, movie);
		else
			movie = null;
		return movie;
	}
	
	@DeleteMapping("/movie/delete/{id}")
	public Movie deleteMovie(@RequestHeader String sessionToken, @PathVariable int id) {

		Movie movie = this.movieService.getMovie(id);
		if (sessionToken.equals("admin-token"))
			this.movieService.deleteMovie(id);
		else
			movie = null;
		return movie;
	}
}
