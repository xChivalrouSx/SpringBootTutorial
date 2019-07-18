package com.chivalrous.app.ws.springbootappwstutorial.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chivalrous.app.ws.springbootappwstutorial.ui.model.UpdateUserDetails;
import com.chivalrous.app.ws.springbootappwstutorial.ui.model.User;
import com.chivalrous.app.ws.springbootappwstutorial.ui.model.UserDetails;
import com.chivalrous.app.ws.springbootappwstutorial.ui.service.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	Map<String, User> users;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " and limit  = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetails userDetails) throws Exception {

		User returnValue = userService.createUser(userDetails);
		return new ResponseEntity<>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public User updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetails userDetails) {
		User storedUser = users.get(userId);
		storedUser.setFirstName(userDetails.getFirstName());
		storedUser.setLastName(userDetails.getLastName());

		users.put(userId, storedUser);
		return storedUser;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
