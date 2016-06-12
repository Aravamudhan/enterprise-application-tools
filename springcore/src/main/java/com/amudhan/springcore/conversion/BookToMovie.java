package com.amudhan.springcore.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("bookToMovie")
public class BookToMovie implements Converter<Book,Movie> {

	@Override
	public Movie convert(Book source) {
		return new Movie(source.getName(),source.getCategory());
	}

}
