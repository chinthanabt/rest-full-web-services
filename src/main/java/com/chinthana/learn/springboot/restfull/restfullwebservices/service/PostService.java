package com.chinthana.learn.springboot.restfull.restfullwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.Post;
import com.chinthana.learn.springboot.restfull.restfullwebservices.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Post findById(int id) {
		return repository.findById(id);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public Post addPost(Post post) {
		repository.save(post);
		return post;
	}	
}
