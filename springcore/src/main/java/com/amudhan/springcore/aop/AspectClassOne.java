package com.amudhan.springcore.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.amudhan.springcore.javaBasedConfiguration.Department;

@Aspect
@Component
class AspectClassOne {

	private final Logger logger = LogManager.getLogger(AspectClassOne.class); 
	/*
	 * A join point is any public method which returns a String. The return
	 * type, name and the arguments list are must. For return type and name to
	 * be anything '*(star)' wildcard should be mentioned instead. (..) - any
	 * type, any number of arguments, (*) - any type, only one argument.
	 */
	@Pointcut("execution( public String *(..))")
	@Order(100)
	public void publicMethodsThatReturnString() {
	}

	/* Any join point in the springcore or its subpackages */
	@Pointcut("within( com.amudhan.springcore..autowiring.*)")
	public void withInAutowiring() {
	}

	@Pointcut("execution(* set*(..))")
	@Order(50)
	public void methodBeginningWithSet() {
	}

	@Around("execution(* com.amudhan.springcore.validation.Contact.get*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.traceEntry();
		logger.info(joinPoint.getSignature().getName());
		Object returnValue = joinPoint.proceed();
		logger.info("The get method's return value", returnValue);
		logger.traceExit();
		return returnValue;
	}

	@Before("publicMethodsThatReturnString()")
	public void beforeAdvice(JoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().getName());
	}

	/*
	 * Unless proceed is called, the join points related to this point cut wont
	 * be called. Here, the methods whose name begin with set
	 */
	@Around("methodBeginningWithSet()")
	public void aroundAdviceForMethodBeginningWithSet(
			ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().getName());
		joinPoint.proceed();
	}

	/*
	 * An example of the power of Around advice. The method getName is
	 * intercepted before being called. It is intercepted after returning.
	 * "Mr." is appended and returned to the callee.
	 */
	@Around("execution(String com.amudhan..*.Student.getName())")
	public String getName(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("Before calling the method using proceed "+proceedingJoinPoint.getSignature().getName());
		String name = (String) proceedingJoinPoint.proceed();
		logger.info("After calling the method using proceed "+proceedingJoinPoint.getSignature().getName());
		return "Mr. " + name;
	}

	@AfterReturning("withInAutowiring()")
	public void afterReturningAdvice(JoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().getName());
	}

	@Before("args(java.lang.String)")
	public void beforeTheMethodThatReceivesString(JoinPoint joinPoint) {
		logger.info(joinPoint.getSignature().getName());
		for (Object object : joinPoint.getArgs()) {
			logger.info("Object "+object);
		}
	}

	/*
	 * This is binding form of args. The expression translates to the method
	 * "beginning with set" with one argument. The argument to the method in the
	 * args is bound to the afterSetDepartment's 2nd argument, since both have
	 * the same name "department". Multiple methods which begin with set and
	 * have one argument, will be tried to be mapped to the variable
	 * "department". But, since its type is "Department", only methods with
	 * "Department" as their argument will successfully intercepted.
	 */
	@AfterReturning("methodBeginningWithSet() && args(argument)")
	public void afterSetDepartment(JoinPoint joinPoint, Department argument) {
		logger.info(joinPoint.getSignature().getName());
		logger.info("The department name " + argument.getName());
	}

	/*
	 * Any join point with an annotation of type Auditable will be intercepted
	 */
	@Before("@annotation(auditable)")
	public void annotationPointcut(Auditable auditable) {
		String auditableMethodName = auditable.value();
		logger.info("Annotation:  " + auditableMethodName);
	}

	/* Interception for the join points which implement/extend Account */
	@After("this(Account)")
	public void thisMethod(JoinPoint joinPoint) {
		logger.info(joinPoint.getSignature().getName());
	}

}
