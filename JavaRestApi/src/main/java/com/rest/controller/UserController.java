package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rest.entity.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/postUser")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		user.setStatus(true);
		User u = userService.postUser(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(Integer id) {
		User u = this.userService.getUser(id);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> u = this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(u, HttpStatus.OK);
	}

	@PutMapping("/putUser")
	public ResponseEntity<User> putUser(@RequestBody User user) {
		User u = userService.putUser(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@PutMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
		 userService.deleteUser(id);
		return new ResponseEntity<User>( HttpStatus.OK);
	}
}
