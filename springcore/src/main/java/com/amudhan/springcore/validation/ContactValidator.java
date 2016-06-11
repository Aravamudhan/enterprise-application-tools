package com.amudhan.springcore.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Contact.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "mailId", "mailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
		Contact contact=(Contact)target;
		if(contact.getPhoneNumber().length()!=10){
			errors.rejectValue("phoneNumber", "phoneNumber.invalid");
		}
			
	}

}
