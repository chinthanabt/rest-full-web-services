package com.chinthana.learn.springboot.restfull.restfullwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {	
	
	public Post findById(int id);
	
	public void deleteById(int id);
}
