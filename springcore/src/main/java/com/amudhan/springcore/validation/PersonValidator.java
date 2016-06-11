package com.amudhan.springcore.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator{

	private ContactValidator contactValidator;
	
	public PersonValidator(ContactValidator contactValidator) {
		this.contactValidator=contactValidator;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		Person person = (Person) target;
        if (person.getAge() <= 0) {
            errors.rejectValue("age", "age.negative");
        } else if (person.getAge() > 110) {
            errors.rejectValue("age", "age.tooHigh");
        } else if(person.getAge()==0){
        	errors.rejectValue("age", "age.zero");
        }
        errors.pushNestedPath("contact");
        ValidationUtils.invokeValidator(this.contactValidator, person.getContact(), errors);
        errors.popNestedPath();
	}

}
