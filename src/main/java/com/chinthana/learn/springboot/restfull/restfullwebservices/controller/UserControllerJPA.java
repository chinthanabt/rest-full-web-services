package com.chinthana.learn.springboot.restfull.restfullwebservices.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dao.UserDAO;
import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.Post;
import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.User;
import com.chinthana.learn.springboot.restfull.restfullwebservices.service.PostService;
import com.chinthana.learn.springboot.restfull.restfullwebservices.service.UserService;
import com.chinthana.learn.springboot.restfull.restfullwebservices.utill.UserNotFoundException;

@RestController
public class UserControllerJPA {
	
	@Autowired
    UserDAO userDao;
	
	@Autowired
    UserService userService;
	
	@Autowired
    PostService postService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/jpa/users")
	public List<User> getUsers() {
	    return  userService.getAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		
		//Hypermedia as the Engine of Application State
		//We can user HATEOAS to return other links back to end user
	     User user = userService.getUser(id);
	     if(user == null) {
	    	 throw new UserNotFoundException("id-" + id);
	     }	 
	     
	     Resource<User> resource = new Resource<User>(user);
	     ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers());
	     resource.add(linkTo.withRel("All-Users"));
	     //return user;
	     return resource;
	}
	
	@GetMapping(path = "/jpa/userByName/{name}")
	public Resource<User> getUser(@PathVariable String name) {
		
		//Hypermedia as the Engine of Application State
		//We can user HATEOAS to return other links back to end user
	     User user = userService.getUserByName(name);
	     if(user == null) {
	    	 throw new UserNotFoundException("id-" + name);
	     }	 
	     
	     Resource<User> resource = new Resource<User>(user);
	     ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers());
	     resource.add(linkTo.withRel("All-Users"));
	     //return user;
	     return resource;
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
	     User createdUser = userService.addUser(user);
	     //To bind the created recourse with response
	     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
	     return ResponseEntity.created(uri).build();     
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
	     userService.deleteById(id);
	     return ResponseEntity.ok().build();
	}
	
//	@GetMapping(path = "/goodmorning")
//	public String getMesage(@RequestHeader(name="Accept-Language", required=false) Locale locale) {	     
//	   return messageSource.getMessage("good.morning", null, locale);	
//	}
	
	@GetMapping(path = "/jpa/goodmorning")
	public String getMesage() {
		// If we are using LocaleContextHolder.getLocale() we do not need to get the
		// local from the request header.
		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> getPostByUserId(@PathVariable int id) {
		User user = userService.getUser(id);
		if(user == null)
			throw new UserNotFoundException("User not found for given criteria");
		return user.getPosts();
	}
	
	@GetMapping(path = "/jpa/users/posts/{id}")
	public Post getPostById(@PathVariable int id) {
		Post post = postService.findById(id);		
		return post;
	}	
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post) {
		User user = userService.getUser(id);
		if(user == null)
			throw new UserNotFoundException("User not found for given criteria");
	
		post.setUser(user);
		Post createdPost = postService.addPost(post);
		 //To bind the created recourse with response
	     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPost.getId()).toUri();		
		return ResponseEntity.created(uri).build(); 
	}
}
