package com.chinthana.learn.springboot.restfull.restfullwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
@SpringBootApplication
public class RestFullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullWebServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		//If we are using LocaleContextHolder.getLocale() we have to use AcceptHeaderLocaleResolver instead of SessionLocaleResolver.
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	
	//If we are setting the Basename in application.properties we do not need to set a Basename.	
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();//		
//		messageSource.addBasenames("messages");
//		return messageSource; 
//	}
	
}
