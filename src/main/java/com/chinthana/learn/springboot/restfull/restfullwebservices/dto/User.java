package com.chinthana.learn.springboot.restfull.restfullwebservices.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;;

public class User {
	
	private Integer id;
	
	@Min(value=1, message ="Age should be grattor than zero")
	private Integer age;
	
	@Size(min=5,  message ="Name should contains atleast two charactors")
	private String name;
	
	@Past
	private Date birthDate;
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		
}
