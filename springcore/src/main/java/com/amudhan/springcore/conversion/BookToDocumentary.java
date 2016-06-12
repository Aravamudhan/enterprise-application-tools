package com.amudhan.springcore.conversion;

import org.springframework.core.convert.converter.Converter;

public class BookToDocumentary implements Converter<Book,Documentary>{

	@Override
	public Documentary convert(Book source) {
		return new Documentary(source.getName(),source.getCategory());
	}

}
