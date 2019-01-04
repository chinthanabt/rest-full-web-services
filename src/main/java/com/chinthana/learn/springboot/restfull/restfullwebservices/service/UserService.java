package com.chinthana.learn.springboot.restfull.restfullwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.User;
import com.chinthana.learn.springboot.restfull.restfullwebservices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {
		return repository.findAll();
	}
	
	public User getUser(int id) {
		return repository.findById(id);
	}
	
	public User getUserByName(String name) {
		return repository.findByName(name);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public User addUser(User user) {
		repository.save(user);
		return user;
	}	
}
