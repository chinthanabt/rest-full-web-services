package com.chinthana.learn.springboot.restfull.restfullwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {	
	
	public User findById(int id);
	
	public User findByName(String name);
	
	public void deleteById(int id);
}
