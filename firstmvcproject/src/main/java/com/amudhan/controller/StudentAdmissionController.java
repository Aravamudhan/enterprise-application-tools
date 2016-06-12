package com.amudhan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	/*To customize data binding feature. Check WebDataBinder API for more customizations.
	 *The InitBinder is applicable to all the request mappings handled by this controller.*/
	@InitBinder
	public void initBinder(WebDataBinder binder){
		/*To ignore studentMobile field*/
		/*binder.setDisallowedFields(new String[]{"studentMobile"});*/
		/*Customizes date format
		 * There are many property editor classes available like CustomDateEditor
		 * */
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		/*CustomDateEditor converts String to Date*/
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat,false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	@RequestMapping(value="/admissionForm.htm", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception{
		/*The following code was used to test ExceptionHandler*/
		/*if(true){
			//throw new Exception();
			throw new IOException();
			//throw new NullPointerException();
		}*/
		ModelAndView modelAndView = new ModelAndView("admissionform");
		return modelAndView;
	}
	/*By specifying @ModelAttribute, form data is bound to the Student object.
	 * Another way to do the same task, albeit verbose, is using @PathVariable and @RequestParam(see the difference)
	 * Each form variable has to be bound manually*/
	/*BindingResult is helpful in handling errors in data binding. With out this default error page from server is returned
	 * @Valid annotation - Informs Spring MVC to consider the form validation annotations(that are placed in the model class)
	 * only during data binding. If not mentioned, the form validation annotations, for example, @Size in the studentHobby,
	 * will be ignored. These annotations are called "Bean validation" annotations. 
	 * JSR(Java Specification Request) 303/349 is the specification of the Java API for JavaBean validation in Java EE and Java SE, 
	 * provided by JCP(Java Community Process). */
	@RequestMapping(value="/submitAdmissionForm.htm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student")Student student,BindingResult result){
		if(result.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("admissionform");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("admissionsuccess");
		return modelAndView;
	}
}
