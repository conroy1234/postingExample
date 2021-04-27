package com.posting.postingExample.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.posting.postingExample.model.User;

@Component
public class UserService {
	private static List<User> users = new ArrayList<>();	

	static {
		users.add(new User(1, "conroy White", "32 Marston Avenue Dagenham"));
		users.add(new User(2, "Timothy White", "West palm beach Florida"));
		users.add(new User(3, "Delroy White", "Leicester UK"));
	}
	
	private int currentCount = users.size();

	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		for (User us : users) {
			if (us.getId() == id) {
				return us;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = (User) iterator.next();
			if(user.getId()==id) {
				users.remove(user);
				return user;
			}
		}
		
		return null;
	}
	
	public User createUser(User user) {
		if(user.getId()==0) {
			user.setId(users.size()+1);
		}
		users.add(user);
		return user;
	}
	
	

}
