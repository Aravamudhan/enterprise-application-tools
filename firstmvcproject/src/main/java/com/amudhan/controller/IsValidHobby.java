package com.amudhan.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*Creating custom annotation*/
@Documented
@Constraint(validatedBy=HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
	
	/*Enables the custom annotation to accept string parameters*/
	/*The default values are used when there is no argument along with annotation*/
	String listOfValidHobbies() default "Music|Reading|Cricket"; 
	String message() default "Please provide a valid hobby;"+
					"accepted hobbies are - Music, Reading, Cricket";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
