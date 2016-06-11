package com.amudhan.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
	
	/*The interceptor makes sure that if this method returns true, application will handle the request.
	If false is returned, application will not handle the request*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == 2){ /*On tuesdays the request will not be passed down to controllers*/
			response.getWriter().write("The website is down for maintenance");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,
								Object handler,ModelAndView modelAndView) throws Exception{
		System.out.println("In the post handle method for "+request.getRequestURI().toString());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
			Object handler,Exception e) throws Exception{
		System.out.println("In the after completion for "+request.getRequestURI().toString());
		
	}
}
