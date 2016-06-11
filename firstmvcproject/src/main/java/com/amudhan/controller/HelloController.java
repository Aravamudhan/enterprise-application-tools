package com.amudhan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController{

	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable("countryName")String countryName,
									@PathVariable("userName") String userName) {
		ModelAndView modelAndView = new ModelAndView("hellopage");
		modelAndView.addObject("msg","Hello "+userName+" from "+countryName+"! Welcome");
		return modelAndView;
	}
	
	@RequestMapping("/hi/{countryName}/{userName}")
	public ModelAndView hiWorld(@PathVariable Map<String,String> pathVars){
		ModelAndView modelAndView = new ModelAndView("hellopage");
		modelAndView.addObject("msg", "Hi "+pathVars.get("userName")+" from "+pathVars.get("countryName")+
								"! Welcome to our humble aboad");
		return modelAndView;
	}
}
