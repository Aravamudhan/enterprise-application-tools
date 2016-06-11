package com.amudhan.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby,String>{

	private String listOfValidHobbies;
	/*First initialize function then to isValid function*/
	@Override
	public void initialize(IsValidHobby isValidHobby) {
		listOfValidHobbies=isValidHobby.listOfValidHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {
		if(studentHobby==null)
			return false;
		if(studentHobby.matches(listOfValidHobbies))
			return true;
		else
			return false;
	}

}
