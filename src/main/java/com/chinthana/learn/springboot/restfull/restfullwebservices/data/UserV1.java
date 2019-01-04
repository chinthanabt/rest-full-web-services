package com.chinthana.learn.springboot.restfull.restfullwebservices.data;

public class UserV1 {
	
	private String name;

	public UserV1() {
		super();
	}
	
	public UserV1(String name) {
		super();
		this.name = name;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
