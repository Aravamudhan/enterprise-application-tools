package com.amudhan.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.amudhan.springcore.javaBasedConfiguration.Department;

@Aspect
@Component
class AspectClassOne {

	/*
	 * A join point is any public method which returns a String. The return
	 * type, name and the arguments list are must. For return type and name to
	 * be anything '*(star)' wildcard should be mentioned instead. (..) - any
	 * type, any number of arguments, (*) - any type, only one argument.
	 */
	@Pointcut("execution( public String *(..))")
	public void publicMethodsThatReturnString() {
	}

	/* Any join point in the springcore or its subpackages */
	@Pointcut("within( com.amudhan.springcore..autowiring.*)")
	public void withInAutowiring() {
	}

	@Pointcut("execution(* set*(..))")
	public void methodBeginningWithSet() {
	}
	
	@Around("execution(* com.amudhan.springcore.validation.Contact.get*(..))")
	public Object afterAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----------------------------------------------------");
		System.out.println("execution:Around execution of the method "
				+ joinPoint.getSignature().getName());
		Object returnValue=joinPoint.proceed();
		System.out.println("The get method's return value "+returnValue);
		return returnValue;
	}

	@Before("publicMethodsThatReturnString()")
	public void beforeAdvice(JoinPoint joinPoint) throws Throwable {
		System.out.println("-----------------------------------------------------");
		System.out.println("execution:Before execution of the method "
				+ joinPoint.getSignature().getName());
	}

	/*
	 * Unless proceed is called, the join points related to this point cut wont
	 * be called. Here, the methods whose name begin with set
	 */
	@Around("methodBeginningWithSet()")
	public void aroundAdviceForMethodBeginningWithSet(
			ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----------------------------------------------------");
		System.out
				.println("execution:Around execution of the method beginning with set "
						+ joinPoint.getSignature().getName());
		joinPoint.proceed();
	}

	@AfterReturning("withInAutowiring()")
	public void afterReturningAdvice(JoinPoint joinPoint) throws Throwable {
		System.out.println("-----------------------------------------------------");
		System.out.println("within:After returning from the method "
				+ joinPoint.getSignature().getName());
	}

	@Before("args(java.lang.String)")
	public void beforeTheMethodThatReceivesString(JoinPoint joinPoint) {
		System.out.println("-----------------------------------------------------");
		System.out
				.println("args:Before execution of the method that receives String "
						+ "" + joinPoint.getSignature().getName());
		for(Object object:joinPoint.getArgs()){
			System.out.println(object +"  ");
		}
	}
	
	/*
	 * This is binding form of args. 
	 * The expression translates to the method "beginning with set" with one argument. 
	 * The argument to the method in the args is bound to the afterSetDepartment's 2nd argument, 
	 * since both have the same name "department". Multiple methods which begin with set and have one argument,
	 * will be tried to be mapped to the variable "department". But, since its type is "Department", only methods with
	 * "Department" as their argument will successfully intercepted.
	 */
	@AfterReturning("methodBeginningWithSet() && args(argument)")
	public void afterSetDepartment(JoinPoint joinPoint,Department argument) {
		System.out.println("-----------------------------------------------------");
		System.out.println("execution:After returning from the setDepartment ");
		System.out.println("The department name "+argument.getName());
	}

}
