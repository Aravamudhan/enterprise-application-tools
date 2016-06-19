package com.amudhan.springcore.springExpressionLanguage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.amudhan.springcore.conversion.Book;

public class SpringExpressionLanguageApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springexpressionlanguage.xml"); 
		Book book1 = new Book("Effective Java", "Programming languages");
		Book book2 = new Book("Art of programming", "Programming languages");
		ExpressionParser exParser = new SpelExpressionParser();
		Expression nameExp = exParser.parseExpression("name");
		Expression categoryExp = exParser.parseExpression("category");

		/* Expressions are evaluated in an evaluation context. */
		System.out.println("Getting a value by supplying EvaluationContext");
		/* Here the book2 is called Root object */
		EvaluationContext evalContext = new StandardEvaluationContext(book2);
		System.out.println(nameExp.getValue(evalContext));
		System.out.println(categoryExp.getValue(evalContext));
		/* Values can be changed */
		nameExp.setValue(evalContext, "Code complete");
		System.out.println(book2.getName());
		/*
		 * If no EvaluationContext is present the default evaluation context is
		 * used
		 */
		System.out
				.println("Getting a value by supplying root object without supplying"
						+ "EvaluationContext");
		System.out.println(nameExp.getValue(book1));
		System.out.println(categoryExp.getValue(book1));
		/*
		 * EvaluationContext is created without using a root object.Later on any
		 * object can be used to get values of expressions
		 */
		EvaluationContext anotherEvalContext = new StandardEvaluationContext();
		System.out.println(nameExp.getValue(anotherEvalContext, book1));
		System.out.println(nameExp.getValue(anotherEvalContext, book2));
		
		RandomNumberGenerator randomNumberGenerator = (RandomNumberGenerator)context.getBean("randomNumberGenerator");
		System.out.println(randomNumberGenerator);
		
		/*
		 * threeDigitRandomNumber bean is created and its value is injected from
		 * randomNumberGenerator bean
		 */ 
		Integer threeDigitRandomNumber = (Integer)context.getBean("threeDigitRandomNumber");
		System.out.println(threeDigitRandomNumber);
		
		

	}
}
