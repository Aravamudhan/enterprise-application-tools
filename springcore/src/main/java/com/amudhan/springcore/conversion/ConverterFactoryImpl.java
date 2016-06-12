package com.amudhan.springcore.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/*This returns converters based on their target types*/
public class ConverterFactoryImpl implements ConverterFactory<Book,Medium> {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Medium> Converter<Book, T> getConverter(
			Class<T> targetType) {
		Converter<Book, T> converter=null;
		switch(targetType.getSimpleName()){
			case "Movie":
				converter=(Converter<Book, T>) new BookToMovie();
				break;
			case "Documentary":
				converter=(Converter<Book, T>) new BookToDocumentary();
				break;
				
		}
		return converter;
	}

}
