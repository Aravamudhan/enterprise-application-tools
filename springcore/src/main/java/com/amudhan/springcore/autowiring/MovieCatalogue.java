package com.amudhan.springcore.autowiring;

import java.util.Set;

import org.springframework.stereotype.Component;
@Component("movieCatalogue")
public class MovieCatalogue {
	
	private Set<Movie> movies;
	
	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
}
