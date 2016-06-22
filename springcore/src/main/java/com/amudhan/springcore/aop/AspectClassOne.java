package com.amudhan.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class AspectClassOne {
	
		
	@After("execution(* com.amudhan.springcore.validation.Contact.setMailId(..))")
	public void afterAdvice(JoinPoint jointPoint) throws Throwable{
		
		String mailId = (String)jointPoint.getArgs()[0];
		System.out.println("The mail id being set is "+ mailId);
		System.out.println("After setting mail id");
	}

}
