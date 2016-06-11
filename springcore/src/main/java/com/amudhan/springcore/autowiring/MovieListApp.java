package com.amudhan.springcore.autowiring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieListApp {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("autowireconfig.xml");
		MovieCatalogue movieCatalogue=(MovieCatalogue)context.getBean("movieCatalogue");
		Set<Movie> movieDetails=new HashSet<Movie>();
		
		Movie movie1=(Movie)context.getBean("movie");
		movie1.setName("Godfather");
		movie1.getDirector().setName("Scorsese");
		movie1.getActor().setName("Al pacino");
		movieDetails.add(movie1);
		Movie movie2=(Movie)context.getBean("movie");
		movie2.setName("Batman begins");
		movie2.getDirector().setName("Nolan");
		movie2.getActor().setName("Bale");
		movieDetails.add(movie2);
		
		movieCatalogue.setMovies(movieDetails);
		
		for(Movie movie:movieCatalogue.getMovies()){
			System.out.println("Movie name "+movie.getName());
			System.out.println("Director name "+movie.getDirector().getName());
			System.out.println("Actor name "+movie.getActor().getName());
		}

	}
}
