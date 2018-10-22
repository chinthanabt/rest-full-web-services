package com.chinthana.learn.springboot.restfull.restfullwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dao.UserDAO;
import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.User;
import com.chinthana.learn.springboot.restfull.restfullwebservices.utill.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
    UserDAO userDao;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/users")
	public List<User> getUsers() {
	    return  userDao.getUsers();
	}
	
	@GetMapping(path = "/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		
		//Hypermedia as the Engine of Application State
		//We can user HATEOAS to return other links back to end user
	     User user = userDao.getUser(id);
	     if(user == null) {
	    	 throw new UserNotFoundException("id-" + id);
	     }	 
	     
	     Resource<User> resource = new Resource<User>(user);
	     ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers());
	     resource.add(linkTo.withRel("All-Users"));
	     //return user;
	     return resource;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
	     User createdUser = userDao.addUser(user);
	     //To bind the created recourse with response
	     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
	     return ResponseEntity.created(uri).build();     
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
	     User deletedUser = userDao.deleteUser(id);
	     if(deletedUser == null) {
	    	 throw new UserNotFoundException("id-" + id);
	     }
	     
	}
	
//	@GetMapping(path = "/goodmorning")
//	public String getMesage(@RequestHeader(name="Accept-Language", required=false) Locale locale) {	     
//	   return messageSource.getMessage("good.morning", null, locale);	
//	}
	
	@GetMapping(path = "/goodmorning")
	public String getMesage() {	  
		//If we are using LocaleContextHolder.getLocale() we do not need to get the local from the request header.
		   return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());	
		}
}
