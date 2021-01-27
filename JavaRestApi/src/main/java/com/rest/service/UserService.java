package com.rest.service;

import java.util.List;

import com.rest.entity.User;

public interface UserService {
	
	User postUser(User user);
	User getUser(Integer id);
	List<User>getAllUsers();
	User putUser (User user);
	void deleteUser(Integer id);


}
