package com.chinthana.learn.springboot.restfull.restfullwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinthana.learn.springboot.restfull.restfullwebservices.dto.User;

@Component
public class UserDAO {
	private static List<User> users = new ArrayList<User>();
	private static int idCount = 4;
	static {
		
		users.add(new User(1, 10,"Chinthana", new Date()));
		users.add(new User(2, 10,"Shanika", new Date()));
		users.add(new User(3, 10,"Seth", new Date()));
		users.add(new User(4, 10,"Hiru", new Date()));
	}
	

	
	public List<User> getUsers(){
		return users;
	}
	
	
	public User addUser(User user){
		user.setId(++idCount);
		users.add(user);
		return user;
	}
	
	public User getUser(int id){
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;		
	}
	
	public User deleteUser(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
}
