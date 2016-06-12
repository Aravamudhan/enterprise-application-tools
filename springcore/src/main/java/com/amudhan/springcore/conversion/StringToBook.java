package com.amudhan.springcore.conversion;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToBook implements Converter<String,Book> {

	@Override
	public Book convert(String source) {
		String[] values=source.split(",");
		return new Book(values[0],values[1]);
	}

}
