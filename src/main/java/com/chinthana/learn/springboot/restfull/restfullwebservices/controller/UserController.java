package com.chinthana.learn.springboot.restfull.restfullwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dao.UserDAO;
import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.User;
import com.chinthana.learn.springboot.restfull.restfullwebservices.utill.error.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
    UserDAO userDao;
	
	@GetMapping(path = "/users")
	public List<User> gtUsers() {
	    return  userDao.getUsers();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
	     User user = userDao.getUser(id);
	     if(user == null) {
	    	 throw new UserNotFoundException("id-" + id);
	     }	     
	     return user;	     
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
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
}
