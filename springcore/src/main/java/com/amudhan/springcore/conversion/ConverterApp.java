package com.amudhan.springcore.conversion;

/*This application creates a Book object and converts it into Movie and Documentary objects
 * To do that necessary converter is received from a ConverterFactory object by mentioning 
 * the target class type. After receiving the necessary converter, the convert method is called 
 * along with the source object which is a Book. The convert method returns the converted object*/

/*Note:Converters are not supposed to be used directly. They should be registered with 
ConversionService APIs for better readability and maintainability.*/
public class ConverterApp {
	public static void main(String[] args){
		Book book=new Book("A song of ice and fire","fantasy");
		ConverterFactoryImpl converterFactory = new ConverterFactoryImpl();
		BookToMovie bookToMovieConverter=(BookToMovie) converterFactory.getConverter(Movie.class);
		BookToDocumentary bookToDocumentaryConverter=(BookToDocumentary) 
													converterFactory.getConverter(Documentary.class);
		Movie movie=bookToMovieConverter.convert(book);
		Documentary documentary=bookToDocumentaryConverter.convert(book);
		System.out.println(movie);
		System.out.println(documentary);
	}
}
