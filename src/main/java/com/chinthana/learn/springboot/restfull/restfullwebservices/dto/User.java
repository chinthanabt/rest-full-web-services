package com.chinthana.learn.springboot.restfull.restfullwebservices.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Min(value=1, message ="Age should be grattor than zero")
	private Integer age;
	
	@Size(min=5,  message ="Name should contains atleast two charactors")
	private String name;
	
	@Past
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	protected User() {
		super();
	}

	public User(Integer id, Integer age, String name, Date birthDate) {
		super();
		this.age = age;
		this.name = name;
		this.birthDate = birthDate;
		this.id = id;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
		
}
