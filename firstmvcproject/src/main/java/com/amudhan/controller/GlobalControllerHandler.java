package com.amudhan.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

/*Adding controller advice annotation makes the methods in this class apply to all the controllers.
 *This annotation is used to define @ExceptionHandler, @InitBinder, and @ModelAttribute methods
 *that apply to all @RequestMapping methods.*/
@ControllerAdvice
public class GlobalControllerHandler {
	/*Same task can be performed by using simpleMappingExceptionResolver in the
	dispatcher-servlet.xml (i.e.)mapping exceptions to their respective views*/
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e){
		System.out.println("Exception has occured");
		e.printStackTrace();
		return "serverexception";
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=IOException.class)
	public String handleIOException(IOException e){
		System.out.println("IO Exception has occured");
		e.printStackTrace();
		return "ioexception";
	}
	
	@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(NullPointerException e){
		System.out.println("Null pointer exception has occured");
		e.printStackTrace();
		return "nullpointerexception";
	}
	/*For every model object, this method is called and the attribute and its value is added.
	 * Useful, if many model objects share certain value*/
	@ModelAttribute
	public void addingCommonObjects(Model model){
		model.addAttribute("headerMessage","Welcome to Student management system");
	}
}
