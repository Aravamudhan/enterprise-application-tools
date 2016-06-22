package com.amudhan.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
class AspectClassOne {
	
	@Pointcut("execution( public * *(..))")
	public void beforePublicMethod(JoinPoint joinPoint){}
	
		
	@After("execution(* com.amudhan.springcore.validation.Contact.setMailId(..))")
	public void afterAdvice(JoinPoint joinPoint) throws Throwable{
		
		String mailId = (String)joinPoint.getArgs()[0];
		System.out.println("The mail id being set is "+ mailId);
		System.out.println("After execution of the method "+joinPoint.getSignature().getName());
	}
	
	@Before("beforePublicMethod(joinPoint)")
	public void beforeAdvice(JoinPoint joinPoint) throws Throwable{
		System.out.println("Before execution of the method "+joinPoint.getSignature().getName());
	}

}
