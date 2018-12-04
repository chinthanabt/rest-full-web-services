package com.chinthana.learn.springboot.restfull.restfullwebservices.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinthana.learn.springboot.restfull.restfullwebservices.data.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	@GetMapping(path = "/filtering")
	public MappingJacksonValue getSomeBean() {
		//Filter using dynamic filtering.
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field6", "field7");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanPropertyFilter", filter);
	 	SomeBean someBean = new SomeBean("field1", "field2", "field3", "field4", "field5", "field6", "field7");

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return 	mapping;
	}
}
