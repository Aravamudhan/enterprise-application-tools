package com.amudhan.springcore.autowiring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("movie")
@Scope("prototype")
public class Movie {
	private String name;
	@Resource
	private Actor actor;
	@Resource
	private Director director;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Actor getActor() {
		return actor;
	}
	public Director getDirector() {
		return director;
	}
	
}
