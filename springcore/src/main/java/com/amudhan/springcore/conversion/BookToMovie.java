package com.amudhan.springcore.conversion;

import java.util.Map;

import org.springframework.core.convert.converter.Converter;

public class BookToMovie implements Converter<Book,Movie> {

	@Override
	public Movie convert(Book source) {
		return new Movie(source.getName(),source.getCategory());
	}

}
