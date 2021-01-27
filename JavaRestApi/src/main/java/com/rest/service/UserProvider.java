package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.User;
import com.rest.repository.UserRepository;

@Service
public class UserProvider implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User postUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findByStatus(true);
	}

	@Override
	public User putUser(User user) {
		User u = userRepository.save(user);
		return u;
	}

	@Override
	public User getUser(Integer id) {
		System.out.println("service");		
		return userRepository.findById(Long.valueOf(id));
	}

	@Override
	public void deleteUser(Integer id) {
		User u = new User();
		u.setStatus(false);
		u.setId(Long.valueOf(id));
		userRepository.updateUser(id);
	}



}
