package com.chinthana.learn.springboot.restfull.restfullwebservices.data;

public class UserV2 {
	
	private Name name;

	public UserV2() {
		super();
	}

	public UserV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
