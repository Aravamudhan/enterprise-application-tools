package com.amudhan.springcore.formatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.support.FormattingConversionService;

public class FormatterServiceApp {
	private static ApplicationContext context;
	private static FormattingConversionService formattingConversionService;
	public static void main(String[] args){
		context=new ClassPathXmlApplicationContext("conversionserviceconfig.xml");
		formattingConversionService=(FormattingConversionService)context.getBean("formattingConversionService");
		DebitCardNumber debitCardNumber=formattingConversionService.convert("1234-3242-4533-3432",
																			DebitCardNumber.class);
		System.out.println(debitCardNumber);
		/*System.out.println(formattingConversionService.canConvert(String.class, DebitCardNumber.class));*/
		/*for(String s:context.getBeanDefinitionNames())
			System.out.println(s);*/
		
		/*CardDetails cardDetails=(CardDetails)context.getBean("cardDetails");
		System.out.println(cardDetails.getDebitCardNumber());*/
	}
}
