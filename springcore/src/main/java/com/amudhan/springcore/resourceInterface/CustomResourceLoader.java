package com.amudhan.springcore.resourceInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class CustomResourceLoader {
	
	private static ApplicationContext context;
	
	public static void displayResources(Resource resource){
		InputStream in;
		BufferedReader reader;
		try {
			in = resource.getInputStream();
			reader= new BufferedReader(new InputStreamReader(in));
			while (true) {
	            String line = reader.readLine();
	            if (line == null)
	                break;
	          	System.out.println(line);
	        }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		context= new ClassPathXmlApplicationContext();
		Resource localFile = context.getResource("file:/home/amudhan/Desktop/problemsfaced");
		Resource classPathFile=context.getResource("classpath:properties/name.properties");
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		displayResources(localFile);
		displayResources(classPathFile);
		try {
			for(Resource fileByWildCard:resolver.getResources("classpath*:resourceProperties/*.properties"))
				displayResources(fileByWildCard);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
