package com.chinthana.learn.springboot.restfull.restfullwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chinthana.learn.springboot.restfull.restfullwebservices.bean.HelloWorldBean;

//Specify the controller
@RestController
public class HelloworldController {

	//Specify the HTTP method type -GET/POST/PUT/PATCH/DELETE
	//Specify the return type
	//Specify the URL - /hello
	//@RequestMapping(method=RequestMethod.GET, path="/hello")
	@GetMapping(path="/hello")
	public String Helloworld() {
		return "Hello world !!!";
	}
	
	@GetMapping(path="/hello-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Chinthana", 30);
	}
	
	@GetMapping(path="/hello-bean/{name}/{age}")
	public HelloWorldBean helloworldBean(@PathVariable String name, @PathVariable int age) {
		return new HelloWorldBean(name, age);
	}	
	
}
