package com.amudhan.springcore.conversion;

import java.util.List;
import java.util.Scanner;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

public class ConversionServiceApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		
		GenericConversionService conversionService=new DefaultConversionService();
		String source="one,two,three";
		stringToArray(source,conversionService);
		stringToList(source,conversionService);
		
		GenericConversionService userDefinedConversionService=new GenericConversionService();
		Converter<String,Book> converter=new StringToBook();
		userDefinedConversionService.addConverter(converter);
		System.out.println("Enter a book's name and category separated by coma: ");
		String bookDetails=in.nextLine();
		Book book=userDefinedConversionService.convert(bookDetails,Book.class);
		System.out.println(book);
	}
	public static void stringToArray(String source,GenericConversionService conversionService){
		System.out.println("In String to String[]");
		String[] target= conversionService.convert(source, String[].class);
		for(String s:target){
			System.out.println(s);
		}
	}
	public static void stringToList(String source,GenericConversionService conversionService){
		System.out.println("In String to List");
		@SuppressWarnings("unchecked")
		List<String> target= (List<String>)conversionService.convert(source, List.class);
		System.out.println(target);
	}

}
