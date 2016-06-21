package com.amudhan.springcore.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
class AspectClassOne {
	
	@Before("execution(*com.amudhan.springcore.validation.Contact.setMailId(...))")
	public void beforeAdvice(Joinpoint jointPoint){
		System.out.println("Before setting mail id for a contact");
	}

}
