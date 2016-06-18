package com.amudhan.springcore.formatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.support.FormattingConversionService;

import com.amudhan.springcore.conversion.TopSellingBook;

public class FormatterServiceApp {
	private static ApplicationContext context;
	private static FormattingConversionService formattingConversionService;
	public static void main(String[] args){
		context=new ClassPathXmlApplicationContext("formattingserviceconfig.xml");
		formattingConversionService=(FormattingConversionService)context.getBean("conversionService");
		/*Explicitly calling convert method*/
		DebitCardNumber debitCardNumber=formattingConversionService.convert("1234-3242-4533-3432",
																			DebitCardNumber.class);
		System.out.println(debitCardNumber);
		System.out.println(formattingConversionService.canConvert(String.class, DebitCardNumber.class));
		/*for(String s:context.getBeanDefinitionNames())
			System.out.println(s);*/
		
		/*The cardDetails bean is created in the formattingserviceconfig.xml,
		with a DebitCardNumber bean injected into it. 
		The DebitCardBean is injected by injecting a string into the debitCardNumber property,
		which is formatted by using the DebitCardNumberFormatter*/
		CardDetails cardDetails=(CardDetails)context.getBean("cardDetails");
		System.out.println(cardDetails.getDebitCardNumber());
		
		TopSellingBook topSellingBook=(TopSellingBook)context.getBean("topSellingBook");
		System.out.println(topSellingBook.getBook());
	}
}
